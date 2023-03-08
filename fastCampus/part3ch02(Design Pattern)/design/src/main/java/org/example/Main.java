package org.example;


import org.example.adapter.*;
import org.example.aop.AopBrowser;
import org.example.decorator.*;
import org.example.observer.Button;
import org.example.observer.IButtonListener;
import org.example.proxy.Browser;
import org.example.proxy.BrowserProxy;
import org.example.proxy.IBrowser;
import org.example.sigleton.*;

import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args){

        Button button = new Button("버튼");

        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });

        button.click("메세지 전달 : click1");
        button.click("메세지 전달 : click2");
        button.click("메세지 전달 : click3");
        button.click("메세지 전달 : click4");

    }
}
