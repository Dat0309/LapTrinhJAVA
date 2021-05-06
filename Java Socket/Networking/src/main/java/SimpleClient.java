
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class SimpleClient extends JFrame implements ActionListener{

    private JTextField tfa,tfb,tfc;
    private JLabel lbHeso,lbNghiem;
    private JButton send;

    public SimpleClient() {
        initUI();
        
    }
    
    private void initUI(){
        JPanel basic= new JPanel();
        basic.setLayout(new BoxLayout(basic,BoxLayout.Y_AXIS));
        add(basic);
        
        lbHeso= new JLabel("Nhap cac he so cua pt bac 2: ");
        tfa= new JTextField(10);
        tfb= new JTextField(10);
        tfc= new JTextField(10);
        send= new JButton("Send");
        lbNghiem= new JLabel("Nghiem: ");
        
        JPanel nhapA= new JPanel();
        JPanel nhapB= new JPanel();
        JPanel nhapC= new JPanel();
        
        nhapA.setLayout(new BoxLayout(nhapA,BoxLayout.X_AXIS));
        nhapB.setLayout(new BoxLayout(nhapB,BoxLayout.X_AXIS));
        nhapC.setLayout(new BoxLayout(nhapC,BoxLayout.X_AXIS));
        
        nhapA.add(new JLabel("Nhap a: "));
        nhapA.add(tfa);
        
        nhapB.add(new JLabel("Nhap b: "));
        nhapB.add(tfb);
        
        nhapC.add(new JLabel("Nhap c: "));
        nhapC.add(tfc);
        
        basic.add(lbHeso);
        basic.add(nhapA);
        basic.add(nhapB);
        basic.add(nhapC);
        basic.add(send);
        send.addActionListener(this);
        basic.add(lbNghiem);
        
        setTitle("Simple Clien");
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==send){
            Socket client;
            DataOutputStream output;
            DataInputStream input;
            String sNghiem;
            
            try {
                client= new Socket(InetAddress.getLocalHost(),8000);
                
                output = new DataOutputStream(client.getOutputStream());
                output.writeUTF(tfa.getText()+","+tfb.getText()+","+tfc.getText());
                
                input = new DataInputStream(client.getInputStream());
                
                sNghiem= input.readUTF();
                lbNghiem.setText(sNghiem);
            } catch (Exception ex) {
            }
        }
    }
    
}
