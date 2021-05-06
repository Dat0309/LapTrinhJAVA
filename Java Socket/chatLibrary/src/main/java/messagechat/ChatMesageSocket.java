/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messagechat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JTextPane;

/**
 *
 * @author ADMIN
 */
public class ChatMesageSocket {
    private Socket socket;
    private JTextPane txpMessage;
    private PrintWriter out;
    private BufferedReader reader;

    public ChatMesageSocket(Socket socket, JTextPane txpMessage) throws IOException {
        this.socket = socket;
        this.txpMessage = txpMessage;
        
        out= new PrintWriter(socket.getOutputStream());
        reader= new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        received();
    }
    
    //Phương thức cho phép nhận dữ liệu
    private void received(){
        Thread th= new Thread(){
            public void run(){
            while(true){
                try {
                    String line= reader.readLine();
                    if(line!=null){
                        txpMessage.setText(txpMessage.getText()+ " \n<Received>: " +line );
                        
                    }
                } catch (Exception e) {
                }
            }
            }
        };
           th.start();
           
    }
    
    //Phương thức cho phép gửi dữ liệu
    public void send(String mess){
        String current=txpMessage.getText();
        txpMessage.setText(current+"\n <Send>: " +mess);
        out.println(mess);
        //Phương thức để đẩy dữ liệu qua mạng, đổi dữ liệu để máy có thể chuyển qua mạng
        out.flush();
    }
    
    //Phương thức để đóng dữ liệu
    public void close(){
        try {
            out.close();
            reader.close();
            socket.close();
        } catch (Exception e) {
        }
    }
    
    
}
