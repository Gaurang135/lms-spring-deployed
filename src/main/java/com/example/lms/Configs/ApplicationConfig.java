package com.example.lms.Configs;


import java.util.HashMap;
import java.util.List;

import com.example.lms.Entities.Borrower;
import com.example.lms.Entities.Loan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;



@Configuration
public class ApplicationConfig {

    @Bean
    public HashMap<Borrower,List<Loan>> myMap(){
        HashMap<Borrower, List<Loan>> allRecord = new HashMap<>();
        return allRecord;
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }

}
