package com.basics.javabasics.controllers;

import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TooEasyController {

    public boolean isPalindrome(String text) {
        /* The hard way:
        int i1 = 0;
        int i2 = text.length() - 1;
        while (i2 > i1) {
            if (text.charAt(i1) != text.charAt(i2)) {
                return false;
            }
            ++i1;
            --i2;
        }
         */
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        StringBuilder plain = new StringBuilder(clean);
        StringBuilder reverse = plain.reverse();
        return (reverse.toString()).equals(clean);
    }

    public Boolean isPrime(Integer n) {
        boolean isPrime = true;
        for (int i = n - 1; i > 1; i--) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    // reverse a string
    public String revStr(String s) {
        /* The hard way:
         String result = "";
         for (int i = 0; i < s.length(); i++) {
            result += s.charAt(s.length() - i - 1);
         }
         return result;
        */
        String result = new StringBuilder(s).reverse().toString();
        return result;
    }

    // get max integer from a list
    public int maxArr(Integer[] list){
        /* The hard way:
         int max = list[0];
         for (int i : list) {
            if (i > max) {
                max = i;
            }
         }
         */
        Arrays.sort(list);
        int max = list[list.length-1];
        return max;
    }

    // get the second largest integer from a list
    public int secMaxArr(Integer[] list){
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < list.length; i++) {
            if (list[i] > max) {
                secondMax = max;
                max = list[i];
            }
            if (list[i] < max && list[i] > secondMax) {
                secondMax = list[i];
            }
        }
        return secondMax;
    }

    // shift characters by a value (Caesar Cipher)
    public String cipher(String msg, int shift){
        String s = "";
        int len = msg.length();
        for(int x = 0; x < len; x++){
            char c = (char)(msg.charAt(x) + shift);
            if (c > 'z')
                s += (char)(msg.charAt(x) - (26-shift));
            else
                s += (char)(msg.charAt(x) + shift);
        }
        return s;
    }
}
