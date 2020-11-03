package com.company.template_method_pattern_functional_interface;

@FunctionalInterface
public interface Greeting {
    void exec(String targetName, String word);
}
