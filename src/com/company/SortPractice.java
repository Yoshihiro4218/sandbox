package com.company;

import java.util.*;

public class SortPractice {
    private final RandomGenerator randomGenerator = new RandomGenerator();

    // Bogo Sort
    public void printBogoSort() {
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
}
