package org.example.facade;

public class Writer {

    private String fileName;

    public Writer(String fileName){
        this.fileName=fileName;
    }

    public void fileConnect(){
        String massage = String.format("Writer %s로 연결 합니다.", fileName);
        System.out.println(massage);
    }

    public void fileWrite(){
        String massage = String.format("Writer %s로 파일쓰기를 합니다..", fileName);
        System.out.println(massage);
    }

    public void fileDisconnect(){
        String massage = String.format("Writer %s로 연결 종료 합니다..", fileName);
        System.out.println(massage);
    }
}
