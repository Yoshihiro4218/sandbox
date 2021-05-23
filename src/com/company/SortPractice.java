package com.company;

import java.util.*;

public class SortPractice {
    private final RandomGenerator randomGenerator = new RandomGenerator();

    // Bogo Sort
    public void executeBogoSort() {
        System.out.println("======== Bogo Sort START! ========");
        List<Integer> integers = randomGenerator.randomIntegers(100, 5);
        System.out.println(integers);
        int shuffleCount = 0;
        while (!isInOrder(integers)) {
            shuffleIntegers(integers);
            shuffleCount ++;
        }
        System.out.println("ShuffleCount: " + shuffleCount);
        System.out.println("======== Bogo Sort COMPLETE! ========");
    }

    private boolean isInOrder(List<Integer> integers) {
        for (int i = 0; i < integers.size() - 1; i++) {
            if (integers.get(i) > integers.get(i + 1)) return false;
        }
        return true;
    }

    private void shuffleIntegers(List<Integer> integers) {
        Collections.shuffle(integers);
        System.out.println(integers);
    }


    // Bubble Sort
    public void executeBubbleSort() {
        System.out.println("======== Bubble Sort START! ========");
        List<Integer> integers = randomGenerator.randomIntegers(100, 7);
        System.out.println(integers);
        int length = integers.size();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1 - i; j ++) {
                if (integers.get(j) > integers.get(j + 1)) {
                    int front = integers.get(j);
                    int back = integers.get(j + 1);
                    integers.set(j, back);
                    integers.set(j + 1, front);
                    System.out.println(integers);
                }
            }
        }
        System.out.println(integers);
        System.out.println("======== Bubble Sort COMPLETE! ========");
    }

    // Cocktail Sort
    public void executeCocktailSort() {
        System.out.println("======== Cocktail Sort START! ========");
        List<Integer> integers = randomGenerator.randomIntegers(100, 7);
        boolean swapped = true;
        int start = 0;
        int end = integers.size() - 1;

        while (swapped) {
            swapped = false;
            for (int i = start; i < end; i ++) {
                if (integers.get(i) > integers.get(i + 1)) {
                    int front = integers.get(i);
                    int back = integers.get(i + 1);
                    integers.set(i, back);
                    integers.set(i + 1, front);
                    swapped = true;
                    System.out.println(integers);
                }
            }
            if (!swapped) break;

            swapped = false;
            end --;
            for (int i = end - 1; i > start - 1; i --) {
                if (integers.get(i) > integers.get(i + 1)) {
                    int front = integers.get(i);
                    int back = integers.get(i + 1);
                    integers.set(i, back);
                    integers.set(i + 1, front);
                    swapped = true;
                    System.out.println(integers);
                }
            }
            start ++;
        }
        System.out.println(integers);
        System.out.println("======== Cocktail Sort COMPLETE! ========");
    }

    // Comb Sort
    public void executeCombSort() {
        System.out.println("======== Comb Sort START! ========");
        List<Integer> integers = randomGenerator.randomIntegers(100, 7);
        int gap = integers.size();
        boolean swapped = true;

        while (gap != 1 || swapped) {
            gap = (int) Math.floor(gap / 1.3);
            if (gap < 1) gap = 1;
            swapped = false;
            for (int i = 0; i < integers.size() - gap; i ++) {
                if (integers.get(i) > integers.get(i + gap)) {
                    int front = integers.get(i);
                    int back = integers.get(i + gap);
                    integers.set(i, back);
                    integers.set(i + gap, front);
                    swapped = true;
                    System.out.println(integers);
                }
            }
        }
        System.out.println("======== Comb Sort COMPLETE! ========");
    }
}
