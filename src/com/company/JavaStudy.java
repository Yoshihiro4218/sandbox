package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    //  Lambda
    @FunctionalInterface
    private static interface Predicate {
        public boolean test(String test);
    }

    private static List<String> filter(List<String> list,
                                       Predicate predicate) {
        List<String> ret = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                ret.add(s);
            }
        }
        return ret;
    }

    public static void stringFilter(String... args) {
//        Lambda使う前はこんな感じ。。
//        filter(new ArrayList<>(Arrays.asList(args)), new JavaStudy.Predicate() {
//            @Override
//            public boolean test(String value) {
//                return value.length() > 4;
//            }
        List<String> list =
                filter(new ArrayList<>(Arrays.asList(args)), value -> value.length() > 4);
        System.out.println("前: " + Arrays.asList(args));
        System.out.println("5文字以上: " + list);
        methodReference(list);
    }

    private static void methodReference(List<String> list) {
        System.out.println("-------------------------------------");
        System.out.println("[メソッド参照の練習]");
        list.forEach(System.out::println);
    }

    public static boolean bofMatched(String bankName) {
        Pattern pattern = Pattern.compile("福岡銀行");
        Matcher matcher = pattern.matcher(bankName);
        return matcher.matches();
    }

    public static void stringIndexOfAndStartsWithEtc() {
        System.out.println("FukuokaFinancialGroup".contains("Financial"));
        System.out.println("FukuokaFinancialGroup".indexOf("F"));
        System.out.println("FukuokaFinancialGroup".lastIndexOf("F"));
        System.out.println(Pattern.matches("[0-9]{4}", "8354"));
        System.out.println("FukuokaBank".startsWith("Fuk"));
        System.out.println("FukuokaBank".endsWith("Bank"));
        System.out.println("fukuokafinancialGroup".replace("f", "F"));
//        replaceAllでは引数に指定した文字を正規表現と見なして置き換える。
        System.out.println("FukuokaFinancialGroup".replaceAll("[A-Z]", "@"));
        System.out.println("FukuokaFinancialGroup".replaceFirst("[A-Z]", "@"));
        System.out.println(Arrays.toString("福岡銀行 熊本銀行 親和銀行 十八銀行".split("\\s", 4)));
        System.out.println(Arrays.toString("福岡銀行,熊本銀行,親和銀行,十八銀行, ".split(",", -1)));
        System.out.println("FukuokaFinancialGroup".substring(7));
        System.out.println("FukuokaFinancialGroup".substring(7, 16));
    }
}
