package com.company;

public class Account {

    private int cmf;
    private String name;
    private int age;
    private int balance;

    private static int accountCountSum;
    private static int balanceSum;

    public Account(int cmf, String name, int age, int balance) {
        this.cmf = cmf;
        this.name = name;
        this.age = age;
        this.balance = balance;

        balanceSum += balance;
        accountCountSum++;

        newAccountInfo();
    }

    public void recommendSuggestionContents() {
        System.out.println("----------" + name + "さん" + "----------");
        if (age < 30) {
            System.out.println("医療保険の提案をしましょう。");
        } else {
            System.out.println("投資信託の提案をしましょう。");
        }
        System.out.println("---------------------------------");
    }

    private void newAccountInfo() {
        System.out.println("-------------------------------------");
        System.out.println("[INFO] " + "CMF:" + cmf + " 名前:" + name + " 年齢:" + age + " 口座残高:" +
                                   String.format("%,d", balance) + "円 で口座を開設しました！");

        System.out.println("[INFO] 自店の口座数合計は現在、" + String.format("%,d", accountCountSum) + "口座です。");
        System.out.println("[INFO] 自店の預金残高合計は現在、" + String.format("%,d", balanceSum) + "円です。");
        System.out.println("-------------------------------------");
    }
}
