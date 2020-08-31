package com.company.strategy_pattern;

public interface EverydayStrategy {
    /**
     * 1. 朝
     * 2. 昼
     * 3. 夜
     * 4. 寝る
     */

    default void start() {
        System.out.println("[ S T A R T !! ]");
        morning();
        System.out.println("↓");
        daytime();
        System.out.println("↓");
        night();
        System.out.println("↓");
        System.out.println("(つ∀-)ｵﾔｽﾐｰ..... [ E N D !! ]");
    }

    void morning();

    void daytime();

    void night();
}
