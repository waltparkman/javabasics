package com.basics.javabasics.controllers;

import com.basics.javabasics.Employee;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

@Controller
public class CollectionsController {

    // make an array of unique names from two arrays
    public String[] uniqueNames(String[] names1, String[] names2) {
        TreeSet<String> tset = new TreeSet<>();
        for (String s : names1) {
            tset.add(s);
        }
        for (String s : names2) {
            tset.add(s);
        }
        return tset.toArray(new String[tset.size()]);
    }

    public ArrayList<Employee> makeEmployees() {
        ArrayList<Employee> company = new ArrayList<>();
        company.add(new Employee("Elvis", "Entertainment"));
        company.add(new Employee("Priscilla", "Accounting"));
        company.add(new Employee("Colonel Parker", "Management"));
        company.add(new Employee("Lisa Marie", "Accounting"));
        return company;
    }
}
