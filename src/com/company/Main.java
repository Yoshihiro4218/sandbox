package com.company;

import com.company.strategy_pattern.*;
import com.company.template_method_pattern.*;
import com.company.template_method_pattern_functional_interface.*;
import com.company.template_method_pattern_interface.*;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            Java8ToJava17Diff.java9();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void history() {
        Enemy.enemyCount();
        System.out.println("---------------------------");
        Enemy e1 = new Enemy("D子", 100, 70);
        Enemy.enemyCount();
        e1.attack();
        Enemy e2 = new Enemy("ロイド", 80, 50);
        Enemy.enemyCount();
        e2.attack();

        Boss b1 = new Boss("大和田常務", 500, 250, "私は常務だぞ！常務だァ！！");
        Enemy.enemyCount();
        b1.attack();
        b1.attack();
        b1.speakSpecialMessage();


        //Mapの宣言
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 1);
        map.put("orange", 2);
        map.put("melon", 3);
        System.out.println(map);

        //Listを宣言し、keySetメソッドを使用してキーの値を取得する
        List<String> list = new ArrayList<>(map.keySet());
        System.out.println(list);

        FizzBuzz.execute(0);
        FizzBuzz.execute(30);
        FizzBuzz.execute(-10);

        System.out.println("-------------------------------------");

        Account account1 = new Account(1234567, "福岡太郎",
                                       25, 1000000);
        account1.recommendSuggestionContents();

        Account account2 = new Account(2345678, "親和花子",
                                       35, 800000);
        account2.recommendSuggestionContents();

        System.out.println("-------------------------------------");
        System.out.println(Recursive.factorial(0));
        System.out.println(Recursive.factorial(4));
        System.out.println(Recursive.factorial(15));
        System.out.println("-------------------------------------");

        JavaStudy.forBreakPractice();
        System.out.println("-------------------------------------");

        JavaStudy.switchPractice("福岡銀行");
        System.out.println("-------------------------------------");
        JavaStudy.switchPractice("MUFG");
        System.out.println("-------------------------------------");
//        JavaStudy.switchPractice("西日本シティ銀行");
//        System.out.println("-------------------------------------");
        JavaStudy.doWhilePractice(10);
        System.out.println("-------------------------------------");
        JavaStudy.doWhilePractice(0);
        System.out.println("-------------------------------------");

        JavaStudy.tryWithResourcePractice();
        System.out.println("-------------------------------------");

        JavaStudy.tryFinallyPractice();
        System.out.println("-------------------------------------");

        JavaStudy.stringFilter("java", "public", "static", "void",
                               "main", "testMethod", "ruby_on_rails",
                               "spring_boot");
        System.out.println("-------------------------------------");
        System.out.println(JavaStudy.bofMatched("福岡銀行"));
        System.out.println(JavaStudy.bofMatched("親和銀行"));
        System.out.println("-------------------------------------");
        JavaStudy.stringIndexOfAndStartsWithEtc();
        System.out.println("-------------------------------------");
        JavaStudy.listEtc();
        System.out.println("-------------------------------------");
        JavaStudy.mapEtc();
        System.out.println("-------------------------------------");
        JavaStudy.streamPractice();
        System.out.println("-------------------------------------");
        JavaStudy.math();
        System.out.println("-------------------------------------");
        JavaStudy.file();
        System.out.println("-------------------------------------");
        System.out.println(new RandomGenerator().generateStringAndNumber(10));
        System.out.println(new RandomGenerator().generateNumber(15));
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
// テンプレートメソッドパターン
        BankerEveryday bankerEveryday = new BankerEveryday();
        bankerEveryday.start();
        System.out.println("-------------------------------------");
        StudentEveryday studentEveryday = new StudentEveryday();
        studentEveryday.start();
        System.out.println("-------------------------------------");
// テンプレートメソッドパターン_インターフェイス
        BankerEveryday2 bankerEveryday2 = new BankerEveryday2();
        bankerEveryday2.start();
        System.out.println("-------------------------------------");
        StudentEveryday2 studentEveryday2 = new StudentEveryday2();
        studentEveryday2.start();
        System.out.println("-------------------------------------");
// テンプレートメソッドパターン_インターフェイス_ファンクショナル
//        Everyday3 bankerEveryday3 = new Everyday3() {
//            @Override
//            public void daytime(String daytimeActivity) {
//                System.out.println(daytimeActivity);
//            }
//        };
//        Everyday3 bankerEveryday3 = daytimeActivity -> System.out.println(daytimeActivity);
        Everyday3 bankerEveryday3 = System.out::println;
        bankerEveryday3.start("仕事ツラいンゴ.......");
        System.out.println("-------------------------------------");
        bankerStart(System.out::println);
        System.out.println("-------------------------------------");
        Everyday3 studentEveryday3 = System.out::println;
        studentEveryday3.start("講義寝るンゴ (つ∀-)ｵﾔｽﾐｰ");
        System.out.println("-------------------------------------");
// ストラテジーパターン
        EverydayContext bankerEverydayContext = new EverydayContext(new BankerEverydayStrategy());
        bankerEverydayContext.start();
        System.out.println("-------------------------------------");
        EverydayContext studentEverydayContext = new EverydayContext(new StudentEverydayStrategy());
        studentEverydayContext.start();
        System.out.println("-------------------------------------");


        // ソート練習
        SortPractice sortPractice = new SortPractice();
        sortPractice.executeBogoSort();
        sortPractice.executeBubbleSort();
        sortPractice.executeCocktailSort();
        sortPractice.executeCombSort();
        System.out.println("-------------------------------------");

        // timer
        timer();
    }

    private static void bankerStart(Everyday3 everyday3) {
        everyday3.start("仕事ツラいンゴ.......");
    }

    private static void timer() {
        // 処理前の時刻を取得
        long startTime = System.currentTimeMillis();

        // 時間計測をしたい処理
        int result = 0;
        for (int i = 0; i < 1000000; i++) {
            result += 1;
        }

        // 処理後の時刻を取得
        long endTime = System.currentTimeMillis();

        System.out.println("開始時刻：" + startTime + " ms");
        System.out.println("終了時刻：" + endTime + " ms");
        System.out.println("処理時間：" + (endTime - startTime) + " ms");
    }
}