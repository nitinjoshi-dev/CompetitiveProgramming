package com.concept.practice.thread;

public class Example1ThreadBasic {

    public static void main(String[] args) {
        Example1ThreadBasic example1ThreadBasic = new Example1ThreadBasic();
        example1ThreadBasic.doSomething();
    }

    private void doSomething() {
        Thread th = new WorkerThread();
        th.start();
        th.yield();
        System.out.println("Still inside main thread " + Thread.currentThread());
    }

    static class WorkerThread extends Thread {



        public WorkerThread(Runnable runnable) {
            super(runnable);
        }

        public WorkerThread() {
            super();
        }

        @Override
        public void run() {
            System.out.println("Inside thread " + Thread.currentThread());
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                System.out.println("Error!! interruption");
            }
            System.out.println("Still Inside thread " + Thread.currentThread());
        }
    }
}
