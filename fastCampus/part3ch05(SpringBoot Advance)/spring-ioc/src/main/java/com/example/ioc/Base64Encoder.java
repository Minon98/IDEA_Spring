package com.example.ioc;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component("base75Encoder") // 명칭을 변경 가능하다.
public class Base64Encoder implements IEncoder{

    public String encode(String message){
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
