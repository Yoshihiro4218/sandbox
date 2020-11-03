package com.company;

import com.company.template_method_pattern_functional_interface.*;

public class Main {
    public static void main(String[] args) {
        Greeting greeting1 = new Greeting() {
            @Override
            public void exec(String targetName, String word) {
                System.out.println("（こちらに" + targetName + "が向かってくるぞ！）");
                System.out.println(word);
            }
        };
        greeting1.exec("上司", "おはようございます！");


        Greeting greeting2 = (targetName, word) -> {
            System.out.println("（こちらに" + targetName + "が向かってくるぞ！）");
            System.out.println(word);
        };
        greeting2.exec("同僚", "ういーっす");


        Greeting greeting3 = (targetName, word) -> System.out.println(targetName + word);
        greeting3.exec("田中さん", "おはようございます。");

        Greeting greeting4 = (x, y) -> System.out.println(x + y);
        greeting4.exec("鈴木さん", "おはようございます。");

        Greeting2 greeting2_1 = (word) -> System.out.println(word);
        greeting2_1.exec("おはよう");

        Greeting2 greeting2_2 = System.out::println;
        greeting2_2.exec("おはよう");
    }
}