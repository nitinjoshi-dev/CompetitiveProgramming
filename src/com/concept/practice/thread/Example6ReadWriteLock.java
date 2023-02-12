package com.concept.practice.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Example6ReadWriteLock {

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);

    public static void main(String[] args) {
        Example6ReadWriteLock obj = new Example6ReadWriteLock();
        obj.perform();
    }

    private void perform() {
        Thread th = new Thread(new Worker());
        th.setName("First");
        th.start();
        th = new Thread(new Worker());
        th.setName("Second");
        th.start();
        th = new Thread(() -> readTask());
        th.setName("Third");
        th.start();
        System.out.println("Still inside main thread " + Thread.currentThread());
    }


    class Worker implements Runnable {

        @Override
        public void run() {
            updateTask();
            readTask();
            tryLockExample();
        }
    }

    public void updateTask() {
        readWriteLock.writeLock().lock();
        System.out.println("Update task called by " + Thread.currentThread());
        try {
            Thread.sleep(100l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("After update task done " + Thread.currentThread());
        readWriteLock.writeLock().unlock();
    }

    public void readTask() {
        readWriteLock.readLock().lock();
        System.out.println("Read task called by " + Thread.currentThread());
        try {
            Thread.sleep(100l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("After read task done " + Thread.currentThread());
        readWriteLock.readLock().unlock();
    }

    public void tryLockExample() {
        try {
            if (readWriteLock.writeLock().tryLock(300, TimeUnit.MILLISECONDS)) {
                System.out.println("Try lock example " + Thread.currentThread());
                readTask();
                Thread.sleep(100l);
                System.out.println("After try lock example done " + Thread.currentThread());
                readWriteLock.writeLock().unlock();
            } else {
                System.out.println("Unable to acquire lock " + Thread.currentThread());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
