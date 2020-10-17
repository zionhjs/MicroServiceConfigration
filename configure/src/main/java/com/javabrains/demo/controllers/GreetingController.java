package com.javabrains.demo.controllers;

import com.javabrains.demo.dto.DbSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RefreshScope
public class GreetingController {
    @Autowired
    private DbSettings dbSettings;

    @Value("${my.greeting: default value}")  // get val from the properties file
    private String greetingMessage;

    @Value("some static string!")
    private String staticMessage;

    @Value("${my.list.values}")
    private List<String> listValues;

    @Value("#{${dbValues}}")
    private Map<String, String> dbValues;

    public GreetingController(){};

    @GetMapping("/greeting")
    public String greeting(){
        return dbSettings.getConnection() + dbSettings.getHost() + dbSettings.getPort();
    }

    @Autowired
    private Environment env;

    @GetMapping("/envdetails")
    public String envDetails(){
        return env.toString();
    }
}



