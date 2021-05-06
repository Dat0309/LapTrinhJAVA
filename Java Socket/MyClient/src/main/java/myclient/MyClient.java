/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author ADMIN
 */
public class MyClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //Chuoi nhan thong tin tu Server
        String fromServer;
        //Chuoi nay gui thong tin den server
        String toServer;
            Socket clientSocket= new Socket("DESKTOP-6VV4HQK",5000);
        
        //Doi tuong giu thong tin tu Server gui toi
        BufferedReader inFromClient= new BufferedReader(new InputStreamReader(System.in));
        //Doi tuong chiu trach nhiem gui thong tin den Server
        PrintWriter outToServer= new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()),true);
        //Doi tuong giu thong tin gui toi Server
        BufferedReader inFromServer= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        while(true){
            System.out.println("Cho server tra loi: ...");
            fromServer= inFromServer.readLine();
            if(fromServer.equals("q")){
                clientSocket.close();
                break;
            }
            else{
                System.out.println("Received: "+fromServer);
                toServer=inFromClient.readLine();
                outToServer.println(toServer);
            }
        }
    }
    
}
