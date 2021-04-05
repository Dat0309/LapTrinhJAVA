/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicArrowButton;

/**
 *
 * @author ADMIN
 */
public class MicrowaveOven extends JFrame implements ActionListener{
    
    JButton btFood= new JButton("Food to be place here");
    JTextField tfTime= new JTextField("Time to be displayed here");
    JButton b1=new JButton("1");
    JButton b2=new JButton("2");
    JButton b3=new JButton("3");
    JButton b4=new JButton("4");
    JButton b5=new JButton("5");
    JButton b6=new JButton("6");
    JButton b7=new JButton("7");
    JButton b8=new JButton("8");
    JButton b9=new JButton("9");
    JButton b0=new JButton("0");
    JButton jbStart=new JButton("Start");
    JButton jbStop=new JButton("Stop");

    public MicrowaveOven(String title) throws HeadlessException {
        super(title);
        setLayout(new BorderLayout());
        add(btFood,BorderLayout.WEST);
        
        JPanel pMain= new JPanel(new BorderLayout());
        pMain.add(tfTime,BorderLayout.NORTH);
        JPanel pNumber=new JPanel(new GridLayout(4,3));
        pNumber.add(b1);
        pNumber.add(b2);
        pNumber.add(b3);
        pNumber.add(b4);
        pNumber.add(b5);
        pNumber.add(b6);
        pNumber.add(b7);
        pNumber.add(b8);
        pNumber.add(b9);
        pNumber.add(b0);
        pNumber.add(jbStart);
        pNumber.add(jbStop);
        pMain.add(pNumber,BorderLayout.CENTER);
        
        add(pMain,BorderLayout.CENTER);
        
        
        //even
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        jbStart.addActionListener(this);
        jbStop.addActionListener(this);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
          String s=tfTime.getText()+"1";
          tfTime.setText(s);
        }
        else if(e.getSource()==b2){
            String s=tfTime.getText()+"2";
            tfTime.setText(s);
        }
        else if(e.getSource()==b3){
            String s=tfTime.getText()+"3";
            tfTime.setText(s);
        }
        else if(e.getSource()==b4){
            String s=tfTime.getText()+"4";
            tfTime.setText(s);
        }
        else if(e.getSource()==b5){
            String s=tfTime.getText()+"5";
            tfTime.setText(s);
        }
        else if(e.getSource()==b6){
            String s=tfTime.getText()+"6";
            tfTime.setText(s);
        }
        else if(e.getSource()==b7){
            String s=tfTime.getText()+"7";
            tfTime.setText(s);
        }
        else if(e.getSource()==b8){
            String s=tfTime.getText()+"8";
            tfTime.setText(s);
        }
        else if(e.getSource()==b9){
            String s=tfTime.getText()+"9";
            tfTime.setText(s);
        }
        else if(e.getSource()==b0){
            String s=tfTime.getText()+"0";
            tfTime.setText(s);
        }
        else if(e.getSource()==jbStop){
            System.exit(1);
            tfTime.setText("");
        }
        else if(e.getSource()==jbStart){
            tfTime.setText("");
        }
    }
}
