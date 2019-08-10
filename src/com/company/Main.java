package com.company;

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
    }
}
