package com.example.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello")    // http://localhost:9090/api/get/hello
    public String Hello(){
        return "get Hello";
    }

//    @RequestMapping("/hi")      // get / post / put / delete  네가지 다 사용

    @RequestMapping(path = "/hi", method = RequestMethod.GET)   // get 만 사용
    public String hi(){
        return "hi";
    }
    //이전 방식의 GetMapping이다.

    // http://localhost:9090/api/get/path-variable/{name}
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable(name = "name") String pathName){
        System.out.println("PathVariable : " + pathName);
        return pathName;
    }

    //
}
