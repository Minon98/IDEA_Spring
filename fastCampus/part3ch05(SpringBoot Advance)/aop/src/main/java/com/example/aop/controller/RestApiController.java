package com.example.aop.controller;


import com.example.aop.annotation.Decode;
import com.example.aop.annotation.Timer;
import com.example.aop.dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String  get(@PathVariable Long id, @RequestParam String name){
//        System.out.println("get method : ");
//        System.out.println("get method : "+id);
//        System.out.println("get method : "+name);
        return id+" "+name;
    }

    @PostMapping("/post")
    public User post(@RequestBody User user){
//        System.out.println("post method : "+user);
        return user;
    }

    @Timer
    @DeleteMapping("/delete")
    public void delete() throws InterruptedException {
        //db logic
        Thread.sleep(1000*2);
    }

    @Decode
    @PutMapping("/put")
    public User put(@RequestBody User user){
        System.out.println("put");
        System.out.println(user);
        return user;
    }
}
