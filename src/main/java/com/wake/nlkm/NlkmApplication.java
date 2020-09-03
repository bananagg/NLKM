package com.wake.nlkm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class NlkmApplication {

    public static void main(String[] args) {
        SpringApplication.run(NlkmApplication.class, args);
    }

}
