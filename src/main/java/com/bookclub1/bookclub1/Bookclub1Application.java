package com.bookclub1.bookclub1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // This scans all sub-packages including .controller
public class Bookclub1Application {
    public static void main(String[] args) {
        SpringApplication.run(Bookclub1Application.class, args);
    }
}
