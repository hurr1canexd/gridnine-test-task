package com.gridnine.testing.util;

import com.gridnine.testing.model.Flight;

import java.util.List;

/**
 * Class for displaying information
 */
public class Debug {

    public static void Write(String str) {
        System.out.println(str);
    }

    public static void Write(List<Flight> list) {
        list.forEach(System.out::println);
    }

}
