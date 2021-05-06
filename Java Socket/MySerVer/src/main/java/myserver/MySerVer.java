/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ADMIN
 */
public class MySerVer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Chuoi nhan thong tin tu client
        String fromClient;
        //Chuoi gui thong tin den client
        String toClient;
        //De giao tiep voi client, chung ta dung ServerSocket
        ServerSocket Server;
        Socket conn;
        System.out.println("TCP server dang cho de duoc ket noi tu client");
        
        try {
            while(true){
                Server= new ServerSocket(5000);
                conn= Server.accept();
                System.out.println("Client"+" "+ conn.getInetAddress()+":"+conn.getPort()+ "is connected");
                
                //Doi tuong inFromUser giu thong tin can gui cho client
                BufferedReader inFromUser= new BufferedReader(new InputStreamReader(System.in));
                
                //Doi tuong giu thong tin tu client gui toi
                BufferedReader inFromClient=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                
                //Doi tuong chiu trach nhiem gui thong tin den client
                PrintWriter outToClient= new PrintWriter(new OutputStreamWriter(conn.getOutputStream()),true);
                
                while(true){
                    System.out.println("Go chu q de thoat cuoc tro chuyen");
                    toClient= inFromUser.readLine();
                    
                    if(toClient.equals("q")){
                        outToClient.println(toClient);
                        conn.close();
                        break;
                    }
                    else{
                        outToClient.println(toClient);
                        System.out.println("Waitting for chat");
                        System.out.println("RECEIVED:"+inFromClient.readLine());
                    }
                }
                break;
            }
        } catch (Exception e) {
        }
    }
    
}
