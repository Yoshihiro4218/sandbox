package com.company;

public class JavaStudy {

    public static void forBreakPractice() {
        for (int i = 0; i < 10; i++) {
            if (i < 7) {
                System.out.println(i);
            } else {
                System.out.println("おわり＼(^o^)／ｵﾜﾀ");
                break;
            }
        }
    }

    public static void switchPractice(String bankName) {
        switch (bankName) {
            case "福岡銀行":
                System.out.println("わたしが福岡銀行です！");
                break;
            case "熊本銀行":
                System.out.println("わたしが熊本銀行です！");
                break;
            case "親和銀行":
                System.out.println("わたしが親和銀行です！");
                break;
            case "西日本シティ銀行":
                throw new FukuokaBankException("NCは他行やんけ！");
            default:
                System.out.println("(どれでもないか・・・)");
                System.out.println("わたしたちがふくおかフィナンシャルグループです！");
        }
    }

    public static void doWhilePractice(int max) {
        int i = 1;
        do {
            System.out.println(i + "回目〜！");
            i ++;
        } while (i < max);
    }

    public static class FukuokaBankException extends RuntimeException {
        public FukuokaBankException(String message) {
            super(message);
        }
    }
}
