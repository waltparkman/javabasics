package com.basics.javabasics;

import com.basics.javabasics.controllers.RecursiveController;
import com.basics.javabasics.controllers.TooEasyController;
import com.basics.javabasics.controllers.CollectionsController;
import com.basics.javabasics.controllers.Java8Controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

@SpringBootApplication
public class JavabasicsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(JavabasicsApplication.class, args);

		Integer ints[] = {55,77,66,44,33};

		TooEasyController teCon = (TooEasyController) ctx.getBean("tooEasyController");
		CollectionsController tsCon = (CollectionsController) ctx.getBean("collectionsController");
		RecursiveController reCon = (RecursiveController) ctx.getBean("recursiveController");
		Java8Controller j8Con = (Java8Controller) ctx.getBean("java8Controller");

		System.out.println("----------- simple Java puzzles -----------");

		System.out.println("---Palindrome Test:");
		String text = "Evil olive";
		System.out.println(teCon.isPalindrome(text) ? text + " is a Palindrome" : text + "is not a Palindrome");

		System.out.println("---Prime Number Test:");
		int primeint = 7919;
		System.out.println(teCon.isPrime(primeint) ? String.valueOf(primeint)+" is prime" : String.valueOf(primeint)+" is not prime");
		primeint = 7918;
		System.out.println(teCon.isPrime(primeint) ? String.valueOf(primeint)+" is prime" : String.valueOf(primeint)+" is not prime");

		System.out.println("---Find the largest number in array "+ Arrays.toString(ints));
		System.out.println(teCon.maxArr(ints));

		System.out.println("---Find the 2nd largest number in array "+Arrays.toString(ints));
		System.out.println(teCon.secMaxArr(ints));

		System.out.println("---Reverse the String 'Fun Times':");
		System.out.println(teCon.revStr("Fun Times"));

		System.out.println("---shift characters by a value (Caesar Cipher)");
		System.out.println(teCon.cipher("abc", 3));

		System.out.println("----------- Java 8 puzzles -----------");

		System.out.println("---Find the average in array "+Arrays.toString(ints));
		System.out.println(j8Con.average(ints));

		System.out.println("---Label integers with 'e' for even and 'o' for odd");
		List<Integer> lint = Arrays.asList(ints);
		System.out.println(j8Con.getLabelledInts(lint));

		System.out.println("---Print upper case of String array:");
		String[] names = new String[]{"Ava", "Emma", "Olivia", "Sophia"};
		System.out.println(String.join(", ", j8Con.upperArr(names)));

		System.out.println("---Given a list of strings, find those of length 3 that start with 'a'");
		List<String> list = j8Con.strSearch(Arrays.asList(new String[]{"all", "these", "words", "are", "short"}),"a",3);
		System.out.println(list.toString());

		System.out.println("----------- recursive Java puzzles -----------");

		System.out.println("---Print factorial of 20 using recursive:");
		long facto = reCon.factorial(20);
		System.out.println(String.format("%,d", facto));

		System.out.println("---Print Fibonacci series 20 long using recursive:");
		int count=20;
		System.out.print("0 1");
		reCon.printFibonacci(count-2);//n-2 because 2 numbers are already printed
		System.out.println(" ");

		int i1 = 35624;
		int i2 = 2546;
		System.out.println("---The greatest common divisor between "+i1+" and "+i2+" is "+reCon.gcd(i1,i2));

		System.out.println("----------- Java Collections -----------");

		System.out.println("---Print results of merged String arrays using TreeSet:");
		String[] names1 = new String[]{"Ava", "Emma", "Olivia"};
		String[] names2 = new String[]{"Olivia", "Sophia", "Emma"};
		System.out.println(String.join(", ", tsCon.uniqueNames(names1, names2)));

		System.out.println("---Print Accountants in our company:");
		ArrayList<Employee> company = tsCon.makeEmployees();
		company.stream()
			.filter(e -> e.getDepartment().equals("Accounting"))
			.forEach(e -> System.out.println(e.getName()));

		System.out.println("---FizzBuzz using Java 8 Stream---");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number for the FizzBuzz range:");
        //reads an integer from the user
		int num = sc.nextInt();
        //the rangeClosed() method returns a sequential IntStream for the specified range of int elements
        //for-each iterate over the Stream and prints the elements
		IntStream.rangeClosed(1, num).mapToObj(i->i%3==0?(i%5==0? "FizzBuzz ":"Fizz "):(i%5==0? "Buzz ": i+" ")).forEach(System.out::print);
        //close the Scanner
		sc.close();

	}

}
