package com.concept.practice.thread;

public class Example3SynchronizedBlock {



    public static void main(String[] args) {
        Example3SynchronizedBlock obj = new Example3SynchronizedBlock();
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
        anotherPrint();
    }

    synchronized public void print(int i) {
        System.out.println("Inside sync " + i + " " + Thread.currentThread());
    }

    synchronized public void anotherPrint() {
        for (int i = 0; i < 100; i++) {
            System.out.println("From main " + i);
        }
    }

    static synchronized public void printStatic(int i) {
        System.out.println("Inside sync " + i + " " + Thread.currentThread());
    }


    class Worker implements Runnable {

        private int start;
        private Example3SynchronizedBlock lock;

        Worker(int start, Example3SynchronizedBlock lock) {
            this.start = start;
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) { // -> lock
                for (int i = start; i < 100; i += 2) {
                    lock.print(i); // --> lock
                    try {
                        Thread.sleep(100l);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    lock.printStatic(i); // --> a
                }
            }
        }
    }

}
