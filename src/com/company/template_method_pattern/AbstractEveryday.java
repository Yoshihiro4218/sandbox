package com.company.template_method_pattern;

public abstract class AbstractEveryday {
    /**
     * 1. 朝
     * 2. 昼
     * 3. 夜
     * 4. 寝る
     */

    public void start() {
        startMessage();
        morning();
        separate();
        daytime();
        separate();
        night();
        separate();
        sleep();
    }

    private void startMessage() {
        System.out.println("[ S T A R T !! ]");
    }

    protected abstract void morning();

    protected abstract void daytime();

    protected abstract void night();

    private void sleep() {
        System.out.println("(つ∀-)ｵﾔｽﾐｰ..... [ E N D !! ]");
    }

    private void separate() {
        System.out.println("=============");
    }
}
