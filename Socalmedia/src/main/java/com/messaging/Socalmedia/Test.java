package com.messaging.Socalmedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
class Test implements Runnable{
    @Autowired
    private Student st;
    public static void main(String[] args)   {
    }

    @Override
    public void run() {
        System.out.println(st);
    }
}


@Configuration
class Student{
    public  void studing(){
        System.out.println("I am Studying");
    }
    @Bean
    public Student getStudent(){
        return new Student();
    }
}