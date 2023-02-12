package com.concept.practice.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Example5Lock {

    private Lock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        Example5Lock obj = new Example5Lock();
        obj.perform();
    }

    private void perform() {
        Thread th = new Thread(new Worker());
        th.setName("First");
        th.start();
        th = new Thread(new Worker());
        th.setName("Second");
        th.start();
        System.out.println("Still inside main thread " + Thread.currentThread());
    }


    class Worker implements Runnable {

        @Override
        public void run() {
            readTask();
            updateTask();
            tryLockExample();
        }
    }

    public void updateTask() {
        lock.lock();
        System.out.println("Update task called by " + Thread.currentThread());
        try {
            Thread.sleep(100l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("After update task done " + Thread.currentThread());
        lock.unlock();
    }

    public void readTask() {
        lock.lock();
        System.out.println("Read task called by " + Thread.currentThread());
        try {
            Thread.sleep(100l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("After read task done " + Thread.currentThread());
        lock.unlock();
    }

    public void tryLockExample() {
        try {
            if (lock.tryLock(300, TimeUnit.MILLISECONDS)) {
                System.out.println("Try lock example " + Thread.currentThread());
                readTask();
                Thread.sleep(100l);
                System.out.println("After try lock example done " + Thread.currentThread());
                lock.unlock();
            } else {
                System.out.println("Unable to acquire lock " + Thread.currentThread());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
