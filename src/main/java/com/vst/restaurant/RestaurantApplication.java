package com.vst.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.vst.restaurant")
public class RestaurantApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RestaurantApplication.class, args);


//        String[] beanNames = context.getBeanDefinitionNames();
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
    }
}
