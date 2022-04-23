package com.basics.javabasics.controllers;

import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

@Controller
public class Java8Controller {

    // average of a list of numbers
    public Double average(Integer[] list){
        List<Integer> mylist = Arrays.asList(list);
        return mylist.stream()
                .mapToInt(i -> i)
                .average()
                .getAsDouble();
    }

    // set a list of strings to upper case
    public List<String> upperArr(String[] list){
        List<String> mylist = Arrays.asList(list);
        return mylist.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    // search a list of strings for starting character and length
    public List<String> strSearch(List<String> list, String start, int len) {
        return list.stream()
                .filter(s -> s.startsWith(start))
                .filter(s -> s.length() == len)
                .collect(Collectors.toList());
    }

    // label integers as 'e' for even or 'o' for odd
    public String getLabelledInts(List<Integer> list) {
        return list.stream()
                .map(i -> i % 2 == 0 ? "e" + i : "o" + i)
                .collect(joining(","));
    }
}
