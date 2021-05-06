/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientChat;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
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
public class Client extends JFrame implements  ActionListener{

    private ChatMesageSocket mSocket;
    
    JLabel lbMessage,lbtitle;
    JSeparator separator;
    JTextPane txpfromServer;
    JTextField txftoServer;
    JButton send,connect;

    public Client() {
        initUI();
    }
    
    private void initUI(){
        lbtitle= new JLabel("SERVER");
        lbMessage= new JLabel("Message: ");
        separator= new JSeparator();
        txpfromServer= new JTextPane();
        txftoServer= new JTextField();
        send= new JButton("Send");
        connect= new JButton("Connect");
        send.addActionListener(this);
        connect.addActionListener(this);
        
        JPanel basic= new JPanel();
        basic.setLayout(new BoxLayout(basic,BoxLayout.Y_AXIS));
        add(basic);
        
        JPanel mess= new JPanel();
        mess.setLayout(new BoxLayout(mess,BoxLayout.X_AXIS));
        mess.add(lbMessage);
        mess.add(txftoServer);
        
        basic.add(lbtitle);
        basic.add(connect);
        basic.add(separator);
        basic.add(Box.createVerticalGlue());
        basic.add(txpfromServer);
        basic.add(Box.createVerticalGlue());
        basic.add(mess);
        basic.add(send);
        basic.add(Box.createRigidArea(new Dimension(0,15)));
        
        setTitle("Client Chat");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==connect){
            try {
                Socket socket= new Socket(InetAddress.getLocalHost(),8000);
                
                mSocket= new ChatMesageSocket(socket,txpfromServer);
                txpfromServer.setText(txpfromServer.getText()+" Connected!! ");
            } catch (Exception ex) {
                               JOptionPane.showMessageDialog(this, " Error: "+ ex.getMessage());
                                ex.printStackTrace();
            }
        }
        if(e.getSource()==send){
            if(txftoServer.getText().equals(""))
                return;
            mSocket.send(txftoServer.getText());
        }
    }
    
}
