/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author nguyenBaoHuy
 */
public class Listener extends Thread{
    static ServerSocket server = null;
    static Socket conn = null;
    private int PORT = 9000;
    
    public Listener(int userID) {
        this.PORT += userID;
    }
    public void run(){
        try {
            server = new ServerSocket(PORT);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){
            try {
                conn =  server.accept();
            } catch (IOException e) {
                System.err.println("I/O error: " + e);
            }

            new EchoThread(conn).start();
        }
    }
    
}
