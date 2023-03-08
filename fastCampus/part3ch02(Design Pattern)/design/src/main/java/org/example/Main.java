package org.example;


import org.example.adapter.*;
import org.example.aop.AopBrowser;
import org.example.proxy.Browser;
import org.example.proxy.BrowserProxy;
import org.example.proxy.IBrowser;
import org.example.sigleton.*;

import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args){

//        Browser browser = new Browser("www.naver.com");
//        browser.show();
//        browser.show();
//        browser.show();
//        browser.show();

//        IBrowser browser = new BrowserProxy("www.naver.com");
//        browser.show();
//        browser.show();
//        browser.show();
//        browser.show();

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser aopBrowser = new AopBrowser("www.naver.com", () -> {
                        System.out.println("before");
                        start.set(System.currentTimeMillis());
                }, () -> {
                        long now = System.currentTimeMillis();
                        end.set(now-start.get());
                });

        aopBrowser.show();
        System.out.println("loading time : "+end.get());

        aopBrowser.show();
        System.out.println("loading time : "+end.get());
    }
    //콘센트
    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }
}
