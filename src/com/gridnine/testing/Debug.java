package com.gridnine.testing;

import java.util.List;

public class Debug {

    public static void Write(String str) {
        System.out.println(str);
    }

    public static void Write(List<Flight> list) {
        for (Flight item: list) {
            System.out.println(item);
        }
    }

}
