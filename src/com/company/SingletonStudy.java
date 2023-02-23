package com.company;

public class SingletonStudy {
    public static void start() {
        System.out.println("============== single thread ver ===============");
        MySingleton mySingleton1 = MySingleton.getInstance();
        MySingleton mySingleton2 = MySingleton.getInstance();
        System.out.println(mySingleton1);
        System.out.println(mySingleton2);
        System.out.println(mySingleton1.getRandomInt());
        System.out.println(mySingleton2.getRandomInt());
        System.out.println("============== single thread ver ===============");
        System.out.println("============== multi thread ver ===============");
        MySingletonMultiThread mySingletonMultiThread1 = MySingletonMultiThread.getInstance();
        MySingletonMultiThread mySingletonMultiThread2 = MySingletonMultiThread.getInstance();
        System.out.println(mySingletonMultiThread1);
        System.out.println(mySingletonMultiThread2);
        System.out.println(mySingletonMultiThread1.getRandomInt());
        System.out.println(mySingletonMultiThread2.getRandomInt());
        System.out.println("============== multi thread ver ===============");
    }

    static class MySingleton {
        private static final MySingleton mySingleton = new MySingleton();
        private final int randomInt;

        private MySingleton() {
            System.out.println("Instance is Created!");
            RandomGenerator randomGenerator = new RandomGenerator();
            randomInt = randomGenerator.randomInt(100);
        }

        public static MySingleton getInstance() {
            return mySingleton;
        }

        public int getRandomInt() {
            return randomInt;
        }
    }

    static class MySingletonMultiThread {
        private static class SingletonHolder {
            private static final MySingletonMultiThread INSTANCE = new MySingletonMultiThread();
        }
        private final int randomInt;

        private MySingletonMultiThread() {
            System.out.println("Instance is Created!");
            RandomGenerator randomGenerator = new RandomGenerator();
            randomInt = randomGenerator.randomInt(100);
        }

        public static MySingletonMultiThread getInstance() {
            return SingletonHolder.INSTANCE;
        }

        public int getRandomInt() {
            return randomInt;
        }
    }
}
