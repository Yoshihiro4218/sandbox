package com.company;

import com.company.template_method_pattern.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
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
    }
}