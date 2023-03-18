package com.example.swagger.controller;

import com.example.swagger.dto.UserRequest;
import com.example.swagger.dto.UserResponse;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"API 정보를 제공하는 Controller"})
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }

    @ApiImplicitParams({
                    @ApiImplicitParam(name = "x", value = "x값", required = true, dataType = "int", paramType = "path"),
                    @ApiImplicitParam(name = "y", value = "y값", required = true, dataType = "int", paramType = "query")
    })

    @GetMapping("/plus/{x}")
    public int plus(@PathVariable int x, @PathVariable int y){
        return x+y;
    }

    @ApiResponse(code = 502, message = "사용자의 나이가 10살 이하")
    @ApiOperation(value = "사용자의 이름과 나이를 리턴하는 메소드")
    @GetMapping("/user")
    public UserResponse user(UserRequest userRequest){
        return new UserResponse(userRequest.getName(), userRequest.getAge());
    }

    @PostMapping("/user")
    public UserResponse userPost(@RequestBody UserRequest userRequest){
        return new UserResponse(userRequest.getName(), userRequest.getAge());

    }

}