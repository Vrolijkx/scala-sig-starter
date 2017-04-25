package be.aca.java.demo;

import java.util.Arrays;
import java.util.stream.Collectors;

public class HelloWorld {

    public static void main(String[] args) {
        String readableArgs = Arrays.stream(args).collect(Collectors.joining(","));
        System.out.println("Hello world");
        System.out.println("arguments = " + readableArgs);
    }
}

