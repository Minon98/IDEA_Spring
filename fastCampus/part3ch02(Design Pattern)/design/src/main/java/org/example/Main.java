package org.example;


import org.example.strategy.*;

public class Main {
    public static void main(String[] args){
        Encoder encoder = new Encoder();

        //base 64
        EncodingStrategy base64 = new Base64Strategy();

        //normal
        EncodingStrategy normal = new NormalStrategy();

        String message = "hello java";

        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);
        System.out.println(base64Result);

        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);
        System.out.println(normalResult);

        //append
        AppendStrategy appendStrategy = new AppendStrategy();
        encoder.setEncodingStrategy(appendStrategy);
        String appendResult = encoder.getMessage(message);
        System.out.println(appendResult);
    }
}
