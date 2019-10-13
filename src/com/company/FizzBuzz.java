package com.company;

public final class FizzBuzz {

    public static void execute(int iteration) {
        if (checkIterationIsNaturalNumber(iteration)) {
            startFizzBuzzGame(iteration);
        } else {
            printSleepingMessage();
        }
    }

    private static boolean checkIterationIsNaturalNumber(int iteration) {
        return iteration > 0;
    }

    private static void startFizzBuzzGame(int iteration) {
        printStartMessage();
        judgmentFizzBuzz(iteration);
        printEndMessage();
    }

    private static void judgmentFizzBuzz(int iteration) {
        for (int i = 1; i <= iteration; i++) {
            if (i % 15 == 0) {
                printFizzBuzz();
            } else if (i % 3 == 0) {
                printFizz();
            } else if (i % 5 == 0) {
                printBuzz();
            } else {
                printNum(i);
            }
        }
    }

    private static void printStartMessage() {
        printSeparate();
        System.out.println("FizzBuzz Start!(^^)b");
    }

    private static void printEndMessage() {
        System.out.println("FizzBuzz End!( *・ω・)*_ _))ﾍﾟｺﾘﾝ");
        printSeparate();
    }

    private static void printSleepingMessage() {
        printSeparate();
        System.out.println("FizzBuzz Sleeping...( ˘ω˘)ｽﾔｧ");
        printSeparate();
    }

    private static void printSeparate() {
        System.out.println("---------------------");
    }

    private static void printFizzBuzz() {
        System.out.println("FizzBuzz!");
    }

    private static void printFizz() {
        System.out.println("Fizz!");
    }

    private static void printBuzz() {
        System.out.println("Buzz!");
    }

    private static void printNum(int num) {
        System.out.println(num);
    }
}