package org.example;

import com.company.design.Sigleton.Aclazz;
import com.company.design.Sigleton.BClazz;
import com.company.design.Sigleton.SocketClient;
import com.company.design.adapter.*;

public class Main {
    public static void main(String[] args){
        /*
        Aclazz aclazz = new Aclazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aclazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println("두개의 객채가 동일한가?");
        System.out.println(aClient.equals(bClient));

         */

        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        Electronic110V adapter = new SocketAdapter(cleaner);    //adapter
        connect(adapter);

        Airconditioner airconditioner = new Airconditioner();
        Electronic110V airAdapter = new SocketAdapter(airconditioner);
        connect(airAdapter);
    }
    //콘센트
    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }
}
