package com.company.template_method_pattern;

public class BankerEveryday extends AbstractEveryday {

    @Override
    protected void morning() {
        System.out.println("おはようございます！＼(^o^)／ﾂﾗﾀﾝ");
        System.out.println("昨日の投信収益額は 500,000円 でした！ (*^^*)");
        System.out.println("昨日の平準払保険の獲得はありませんでした！ ＼(^o^)／ｵﾜﾀ");
        System.out.println("上司「で、いつ取るの？(ｶﾞﾁｷﾞﾚ)」");
        System.out.println("「「ｲﾏﾃﾞｼｮｰ」」");
    }

    @Override
    protected void daytime() {
        System.out.println("平均待ち時間！");
        System.out.println("消費性ローン！");
        System.out.println("電話セールス！");
        System.out.println("融資実行！");
    }

    @Override
    protected void night() {
        System.out.println("飲み会！");
        System.out.println("上司「俺が若い頃は云々(ry」");
    }
}
