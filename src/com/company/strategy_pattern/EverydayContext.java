package com.company.strategy_pattern;

public class EverydayContext {
    EverydayStrategy everydayStrategy;

    public EverydayContext(EverydayStrategy everydayStrategy) {
        this.everydayStrategy = everydayStrategy;
    }

    public void start() {
        everydayStrategy.start();
    }
}
