package com.company;

public class ThreadLocalStudy {

    private static class MyRunnable implements Runnable {

        static String name = "NANA MIZUKI";
        static ThreadLocal<String> threadLocalName = ThreadLocal.withInitial(() -> "NANA MIZUKI");

        @Override
        public void run() {
            System.out.println("========== Thread Start ==========");
            System.out.println("==== Before ====");
            System.out.println(name);
            name = "YUI HORIE";
            System.out.println("==== After ====");
            System.out.println(name);
            System.out.println("========== Thread End ==========");

            System.out.println("========== Thread Local Start ==========");
            System.out.println("==== Before ====");
            System.out.println(threadLocalName.get());
            threadLocalName.set("YUI HORIE");
            System.out.println("==== After ====");
            System.out.println(threadLocalName.get());
            System.out.println("========== Thread Local End ==========");
        }
    }

    public static void start() {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);
        Thread thread3 = new Thread(myRunnable);

        thread1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread3.start();
    }
}
