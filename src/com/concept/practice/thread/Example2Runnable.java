package com.concept.practice.thread;

public class Example2Runnable {

    public static void main(String[] args) {
        Example2Runnable obj = new Example2Runnable();
        obj.perform();
    }

    private void perform() {
        Thread th = new Thread(new Worker(0));
        th.setName("First");
        th.start();
        th = new Thread(new Worker(1));
        th.setName("Second");
        th.start();
        System.out.println("Still inside main thread " + Thread.currentThread());
    }


    class Worker implements Runnable {

        private int start;

        Worker(int start) {
            this.start = start;
        }

        @Override
        public void run() {
            for (int i = start; i < 100; i+=2) {
                System.out.println(Thread.currentThread() + " --> " + i);
                try {
                    Thread.sleep(100l);
                } catch (InterruptedException e) {
                    System.out.println("Error!! Interruption");
                }
            }
        }
    }
}
