package com.playwith.dropwizard;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class D {
    A a;


    public static void main(String[] args) {
        Supplier<String> stringSupplier;
        List<String> arrays = Arrays.asList("abc");
        arrays.add("a");
        for (String a : arrays) {
            arrays.add("s");
        }
    }
}
