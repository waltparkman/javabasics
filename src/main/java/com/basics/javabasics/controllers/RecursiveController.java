package com.basics.javabasics.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class RecursiveController {

    // starting numbers for Fibonacci
    int n1=0,n2=1,n3=0;
    public void printFibonacci(int count){
        if(count>0){
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            System.out.print(" "+n3);
            printFibonacci(count-1);
        }
    }

    // get factorial, but the long max value is 9,223,372,036,854,775,807
    public long factorial(int n) {
        long facto = n;
        for (int j = n - 1; j > 0; j--) {
            facto = facto * j;
        }
        return facto;
    }

    // greatest common divisor, keep passing remainder in as q until it is zero
    public Integer gcd(Integer p, Integer q) {
        if (q == 0) {
            return p;
        }
        return gcd(q, p % q);
    }
}
