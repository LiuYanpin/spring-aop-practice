package com.thoughtworks;

import com.thoughtworks.aspect.UserAspect;
import com.thoughtworks.aspect.ValueHolderAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAopApplication {

    @Bean(name = "userAspect")
    public UserAspect userAspect() {
        return new UserAspect();
    }

    @Bean(name = "valueHolderAspect")
    public ValueHolderAspect valueHolderAspect() {
        return new ValueHolderAspect();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringAopApplication.class, args);
    }
}
