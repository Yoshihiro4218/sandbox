package com.company;

@Beta(from = "1.0.0")
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
            i++;
        } while (i < max);
    }

    public static void tryWithResourcePractice() {
        try (ClosableSample sample = new ClosableSample()) {
            System.out.println("リソースを使った処理を行っています....");
            sample.printWei();
        }
        catch (Exception e) {
            throw new FukuokaBankException("connectionに何かあったﾝｺﾞww");
        }
    }

    // Java6以前は try-finallyで！
    public static void tryFinallyPractice() {
        ClosableSample sample = new ClosableSample();
        try {
            System.out.println("リソースを使った処理を行っています....");
            sample.printWei();
        }
        catch (Exception e) {
            throw new FukuokaBankException("connectionに何かあったﾝｺﾞww");
        }
        finally {
            // Apache CommonsのIOUtils クラスにあるcloseQuietlyを使えばキレイに。
            try {
                sample.close();
            }
            catch (Exception e) {
                throw new FukuokaBankException("connectionに何かあったﾝｺﾞww");
            }
        }
    }

    public static class ClosableSample implements AutoCloseable {
        public ClosableSample() {
            System.out.println("ClosableなClass. connection開始するお.");
//            throw new RuntimeException();
        }

        public void printWei() {
            System.out.println("うぇ〜い！ｗｗｗ");
        }

        @Override
        public void close() throws Exception {
            System.out.println("closeしま〜す(閉店ｶﾞﾗｶﾞﾗwww)");
        }
    }

    public static class FukuokaBankException extends RuntimeException {
        public FukuokaBankException(String message) {
            super(message);
        }
    }
}
