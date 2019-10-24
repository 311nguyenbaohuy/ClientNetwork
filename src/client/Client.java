/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import commom.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author nguyenBaoHuy
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    
    static Socket conn;
    private TagReader reader;
    private TagWriter writer;

    private List<User> getUsers(byte [] content){
        String string = new String(content);
        string = string.replace("<", "");
        string = string.replace(">", "");
        
        String[] arrString = string.split("\\|");
        List<User> users = new ArrayList<>();
        
        for (String str : arrString) {
            String[] arrAttr = str.split(" ");
            users.add(new User(Integer.parseInt(arrAttr[0]), arrAttr[1], arrAttr[2], Integer.parseInt(arrAttr[3])));
        }
        return users;
    }
    
    public Client() throws UnknownHostException, IOException {

        conn = new Socket(InetAddress.getLocalHost(), 9000);
        reader = new TagReader(conn.getInputStream());  
        writer = new TagWriter(conn.getOutputStream());   

        String[] request = {Tags.LOGIN, "<bao 1 1.1.1.1>"};
//        String[] request = {Tags.REGISTER, "<huyy 1>"};
//        String[] request = {Tags.LOGOUT, "<huy>"};
//        String[] request = {Tags.SEARCH, "<bao>"};
//            String[] request = {Tags.FIND_FRIEND, "<bao>"};
//            String[] request = {Tags.LOGOUT, "<bao>"};
//        String[] request = {Tags.REQUEST, "<bao huyy>"};
        try {
            TagValue tv = new TagValue(request[0], request[1].getBytes());
            writer.writeTag(tv);
            writer.flush();
            tv = reader.getTagValue();
            System.out.println(tv.getTag());
            System.out.println(new String(tv.getContent()));
            List<User> users = getUsers(tv.getContent());
            for (User usr : users){
                System.out.println(usr.getUser_name());
            }

        } catch (Exception e) {
            System.err.println("Network error");
        }
    }
    
    public static void main(String[] args) throws UnknownHostException, MalformedURLException, IOException{

           ParseRoute pr = ParseRoute.getInstance();
            System.out.println( "Gateway: " + pr.getGateway() );
            System.out.println( "IP: " + pr.getLocalIPAddress() );
 
    }
}
