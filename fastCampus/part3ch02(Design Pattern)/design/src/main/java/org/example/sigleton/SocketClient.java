package org.example.sigleton;

public class SocketClient {

    private static SocketClient socketClient = null;

    private SocketClient(){
    //public  SocketClient(){

    }

    public static SocketClient getInstance(){       //싱글톤: 한번만 생성되게 제어

        if(socketClient == null){
            socketClient = new SocketClient();
        }
        return socketClient;
    }

    public void connect(){
        System.out.println("connect");
    }


}
