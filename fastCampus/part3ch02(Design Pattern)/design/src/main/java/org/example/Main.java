package org.example;


import org.example.adapter.*;
import org.example.aop.AopBrowser;
import org.example.decorator.*;
import org.example.facade.Ftp;
import org.example.facade.Reader;
import org.example.facade.SftpClient;
import org.example.facade.Writer;
import org.example.observer.Button;
import org.example.observer.IButtonListener;
import org.example.proxy.Browser;
import org.example.proxy.BrowserProxy;
import org.example.proxy.IBrowser;
import org.example.sigleton.*;

import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args){

        Ftp ftpClient = new Ftp("www.abc.co.kr", 22, "/home/etc");
        ftpClient.connect();
        ftpClient.moveDirectory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.fileWrite();

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        reader.fileDisconnect();
        writer.fileDisconnect();
        ftpClient.disConnect();

        // facade
        SftpClient sftpClient = new SftpClient("www.abc.co.kr", 22, "/home/etc", "text.tmp");
        sftpClient.connect();
        sftpClient.write();
        sftpClient.read();
        sftpClient.disConnect();
    }
}
