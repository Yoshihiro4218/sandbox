package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    }
}