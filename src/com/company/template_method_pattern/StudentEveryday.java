package com.company.template_method_pattern;

public class StudentEveryday extends AbstractEveryday {

    @Override
    protected void morning() {
        System.out.println("(。-ω-)zzz. . . (。ﾟωﾟ) ﾊｯ! 3限ｶﾗ行ｺｳ");
    }

    @Override
    protected void daytime() {
        System.out.println("(。-ω-)zzz. . . (。ﾟωﾟ) ﾊｯ! 講義ｵﾜｯﾃﾀ");
    }

    @Override
    protected void night() {
        System.out.println("飲み会ウェーイ！！ｗｗｗｗ");
        System.out.println("　 　 　　　＿＿＿_");
        System.out.println("　 　　　／⌒　　⌒　　　＼");
        System.out.println("　　　／（ ●） 　（●）　　＼");
        System.out.println("　 ／::::::⌒（__人__）⌒:::::＼");
        System.out.println("　 |　　　　　|r┬-|　　　　　|");
        System.out.println("　 ＼ 　　 　 `ー'´ 　 　 ／");
    }
}
