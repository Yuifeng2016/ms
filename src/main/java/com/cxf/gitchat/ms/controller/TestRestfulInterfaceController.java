package com.cxf.gitchat.ms.controller;

import com.cxf.gitchat.ms.config.StudentConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/restful")
public class TestRestfulInterfaceController {

    @Autowired
    StudentConfig studentConfig;

    @RequestMapping("/test")
    public String TestRestfulInterface(String name){
        return  "hello " + name;
    }

    @GetMapping("/printStudentInfo")
    public String getStudentInfo(){
        return "studentName: "+ studentConfig.getName()+ " studentAge: "+ studentConfig.getAge();
    }
}
