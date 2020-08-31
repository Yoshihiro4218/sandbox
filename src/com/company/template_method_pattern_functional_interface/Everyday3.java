package com.company.template_method_pattern_functional_interface;

@FunctionalInterface
public interface Everyday3 {
    /**
     * 1. 日中
     * 2. 寝る
     */

    default void start(String daytimeActivity) {
        System.out.println("[ S T A R T !! ]");
        daytime(daytimeActivity);
        System.out.println("(つ∀-)ｵﾔｽﾐｰ..... [ E N D !! ]");
    }

    void daytime(String daytimeActivity);
}
