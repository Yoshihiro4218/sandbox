package com.company;

public class Boss extends Enemy {

    String specialMessage;

    public Boss(String name, int hp, int power, String specialMessage) {
        super(name, hp, power);
        System.out.println("ボス敵が発生した...ｯ！！");
        this.specialMessage = specialMessage;
    }

    @Override
    public void attack() {
        for (int i = 0; i < 1; i++) {
            System.out.println(this.name + "の攻撃！：" + this.power + "ダメージを与えた！大ダメージだ～！！");
            i++;
        }
    }

    public void speakSpecialMessage() {
        System.out.println(specialMessage);
        System.out.println("---------------------------");
    }
}
