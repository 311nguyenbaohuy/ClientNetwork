/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import commom.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.*;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguyenBaoHuy
 */
public class EchoThread extends Thread{
    protected Socket conn = null;
    private TagReader reader;
    private TagWriter writer;
    
    public EchoThread(Socket clientSocket){
        conn = clientSocket;
    }

    public void run(){

//        try{
//            reader = new TagReader(conn.getInputStream());  
//            writer = new TagWriter(conn.getOutputStream());
//            
//            TagValue tv = reader.getTagValue();
//            String content = new String(tv.getContent());
////            System.out.println(content);
//            content = content.replace("<", "");
//            content = content.replace(">", "");
//            
//            String[] arrContent;
//            
//            switch (tv.getTag()){
//                
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(EchoThread.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }
    
}
