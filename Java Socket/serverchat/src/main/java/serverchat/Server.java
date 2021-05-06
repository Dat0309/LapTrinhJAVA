/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import messagechat.ChatMesageSocket;

/**
 *
 * @author ADMIN
 */
public class Server extends JFrame implements ActionListener{
    private ChatMesageSocket mSocket;
    
    JLabel lbMessage,lbtitle;
    JSeparator separator;
    JTextPane txpfromClient;
    JTextField txftoClient;
    JButton send,connect;
    
    public Server() {
        initUI();
    }

     private void initUI(){
        lbtitle= new JLabel("SERVER");
        lbMessage= new JLabel("Message: ");
        separator= new JSeparator();
        txpfromClient= new JTextPane();
        txftoClient= new JTextField();
        send= new JButton("Send");
        send.addActionListener(this);
        connect= new JButton("Connect");
        connect.addActionListener(this);
        
        JPanel basic= new JPanel();
        basic.setLayout(new BoxLayout(basic,BoxLayout.Y_AXIS));
        add(basic);
        
        JPanel mess= new JPanel();
        mess.setLayout(new BoxLayout(mess,BoxLayout.X_AXIS));
        mess.add(lbMessage);
        mess.add(txftoClient);
        
        basic.add(lbtitle);
        basic.add(connect);
        basic.add(separator);
        basic.add(Box.createVerticalGlue());
        basic.add(txpfromClient);
        basic.add(Box.createVerticalGlue());
        basic.add(mess);
        basic.add(send);
        basic.add(Box.createRigidArea(new Dimension(0,15)));
        
        setTitle("Server Chat");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
     
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==connect){
           try {
               ServerSocket serverSocket= new ServerSocket(8000);
               
               Thread th= new Thread(){
                   public void run(){
                       try {
                        txpfromClient.setText(txpfromClient.getText()+"Connecting....");
                        Socket socket= serverSocket.accept();
               
                        mSocket= new ChatMesageSocket(socket,txpfromClient);
                         } catch (Exception exp) {
                                            JOptionPane.showMessageDialog(this, " Error: "+ exp.getMessage());
                                            exp.printStackTrace();
                       }
                   }
               };
               th.start();

           } catch (Exception ex) {
               JOptionPane.showMessageDialog(this, " Error: "+ ex.getMessage());
               ex.printStackTrace();
           }
       }
       if(e.getSource()==send){
           if(txftoClient.getText().equals(""))
               return;
           mSocket.send(txftoClient.getText());
       }
    }
    
}
