package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    // http://localhost:9090/api/get/query-param?user=steve&email=steve&gamil.com&age=30


    //파라미터가 뭐가 들어올지 모른다면 Map으로 파라미터를 받을 수 있다.
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){

        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(entry-> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+" = "+entry.getValue()+"\n");
        });

        return sb.toString();
    }

    // 파라미터를 명시적으로 할 수 있다. 파라미터가 많아지면 불편하다.
    @GetMapping("/query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name+" "+email+" "+age;

    }

    //객체 getter setter로 간단히 가능
    @GetMapping("/query-param03")
    public String queryParam03(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();

    }
}
