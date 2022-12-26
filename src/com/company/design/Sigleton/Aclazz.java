package com.company.design.Sigleton;

public class Aclazz {

    private SocketClient socketClient;

    public Aclazz(){
        this.socketClient = SocketClient.getInstance();     //인스턴스를 통해 생성
        //this.socketClient = new SocketClient();
    }

    public SocketClient getSocketClient(){
        return this.socketClient;
    }
}
