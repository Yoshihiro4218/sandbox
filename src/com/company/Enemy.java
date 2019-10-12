package com.company;

public class Enemy {
    private static int enemyCount = 0;

    String name;
    int hp;
    int power;

    public Enemy(String name, int hp, int power) {
        this.name = name;
        this.hp = hp;
        this.power = power;

        enemyCount++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void attack() {
        System.out.println(this.name + "の攻撃！：" + this.power + "ダメージを与えた！");
        System.out.println("---------------------------");
    }

    public static void enemyCount() {
        System.out.println("敵は" + enemyCount + "体いるぞ！！");
    }
}
