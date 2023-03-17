package com.example.springcalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Res {
    private int result;

    private Body response;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Body{
        private String resultCode = "OK";
    }
}
