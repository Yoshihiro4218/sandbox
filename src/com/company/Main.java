package com.company;

public class Main {

    public static void main(String[] args) {
        Enemy.enemyCount();
        Enemy e1 = new Enemy("D子", 100, 70);
        Enemy.enemyCount();
        Enemy e2 = new Enemy("ロイド", 80, 50);
        Enemy.enemyCount();
        e1.attack();
        e2.attack();
    }
}
