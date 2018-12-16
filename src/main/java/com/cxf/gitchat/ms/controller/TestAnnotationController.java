package com.cxf.gitchat.ms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestAnnotationController {
    Logger logger = LoggerFactory.getLogger(TestAnnotationController.class);
    @GetMapping("/setUserInfo")
    public String setUserInfo( String userName){
        System.out.println(userName);
        return "success";
    }

}
