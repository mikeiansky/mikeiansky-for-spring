package com.winson.spring.dependency.source.demo;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author winson
 * @date 2021/10/3
 **/
public class StreamDebugDemo {

    public static StreamDebugDemo getBridge(){
        return new StreamDebugDemo();
    }

    public Stream<Integer> getStream(){
        return Stream.of(1, 2, 3, 4, 5, 6, 7, 8);
    }

    public static void main(String[] args) {

            getBridge().getStream()
                .map(i -> i + 2)
                .filter(i -> i > 2)
                .forEach(System.out::println);

    }

}
