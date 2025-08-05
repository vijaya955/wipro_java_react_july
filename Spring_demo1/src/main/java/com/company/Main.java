package com.company;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("company-config.xml");

        Employee employee = context.getBean("employee", Employee.class);
        System.out.println(employee);
    }
}
