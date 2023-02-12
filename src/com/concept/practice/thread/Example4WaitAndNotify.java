package com.concept.practice.thread;

public class Example4WaitAndNotify {

    public static void main(String[] args) {
        Example4WaitAndNotify obj = new Example4WaitAndNotify();
        obj.perform();
    }

    private void perform() {
        Thread th = new Thread(new Worker(0, this));
        th.setName("First");
        th.start();
        th = new Thread(new Worker(1, this));
        th.setName("Second");
        th.start();
        System.out.println("Still inside main thread " + Thread.currentThread());
    }


    class Worker implements Runnable {

        private int start;
        private Object lock;

        Worker(int start, Object lock) {
            this.start = start;
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = start; i < 100; i += 2) {
                    System.out.println(Thread.currentThread() + " --> " + i);
                    try {
                        lock.notify();
                        lock.wait(100);
                        Thread.sleep(100l);
                    } catch (InterruptedException e) {
                        System.out.println("Error!! Interruption");
                    }
                }
            }
        }
    }

}
