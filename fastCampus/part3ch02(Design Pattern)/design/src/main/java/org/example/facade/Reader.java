package org.example.facade;

public class Reader {

    private String fileName;

    public Reader(String fileName){
        this.fileName=fileName;
    }

    public void fileConnect(){
        String massage = String.format("Reader %s로 연결 합니다.", fileName);
        System.out.println(massage);
    }

    public void fileRead(){
        String massage = String.format("Reader %s의 내용을 읽어 옵니다.", fileName);
        System.out.println(massage);
    }

    public void fileDisconnect(){
        String massage = String.format("Reader %s로 연결 종료 합니다..", fileName);
        System.out.println(massage);
    }
}
