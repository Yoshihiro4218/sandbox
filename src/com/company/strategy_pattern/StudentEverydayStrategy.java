package com.company.strategy_pattern;

public class StudentEverydayStrategy implements EverydayStrategy {
    @Override
    public void morning() {
        System.out.println("(。-ω-)zzz. . . (。ﾟωﾟ) ﾊｯ! 3限ｶﾗ行ｺｳ");
    }

    @Override
    public void daytime() {
        System.out.println("(。-ω-)zzz. . . (。ﾟωﾟ) ﾊｯ! 講義ｵﾜｯﾃﾀ");
    }

    @Override
    public void night() {
        System.out.println("飲み会ウェーイ！！ｗｗｗｗ");
        System.out.println("　 　 　　　＿＿＿_");
        System.out.println("　 　　　／⌒　　⌒　　　＼");
        System.out.println("　　　／（ ●） 　（●）　　＼");
        System.out.println("　 ／::::::⌒（__人__）⌒:::::＼");
        System.out.println("　 |　　　　　|r┬-|　　　　　|");
        System.out.println("　 ＼ 　　 　 `ー'´ 　 　 ／");
    }
}
