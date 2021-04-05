/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ADMIN
 */
public class Calcul extends JFrame implements ActionListener{
    
    JButton btPlus=new JButton("+");
    JButton btMinus =new JButton("-");
    JButton btMul=new JButton("*");
    JButton btDiv=new JButton("/");
    JTextField jtX,jtY,jtKQ;
    double result;
    Container cont;
    JPanel jp1=new JPanel(); 
    JPanel jp2=new JPanel();
    public Calcul(String s){
        super(s);
        cont=this.getContentPane();
        
        JLabel x = new JLabel("X: ");
        jtX= new JTextField();
        JLabel y=new JLabel("Y: ");
        jtY=new JTextField();
        JLabel kq=new JLabel("Result: ");
        jtKQ=new JTextField();
        jtKQ.setEditable(false);
        
        jp1.setLayout(new GridLayout(1,5));
        jp1.add(x);
        jp1.add(jtX);
        jp1.add(y);
        jp1.add(jtY);
        jp1.add(kq);
        jp1.add(jtKQ);
        
        jp2.setLayout(new GridLayout(1,5));
        jp2.add(btPlus);
        jp2.add(btMinus);
        jp2.add(btMul);
        jp2.add(btDiv);

        cont.add(jp1);
        cont.add(jp2,"South");      
        
        btPlus.addActionListener(this);
        btMinus.addActionListener(this);
        btMul.addActionListener(this);
        btDiv.addActionListener(this);
        
        this.pack();
        this.setVisible(true);
    }
    public void Plus(){
        result=Double.parseDouble(jtX.getText())+Double.parseDouble(jtY.getText());
        jtKQ.setText(String.valueOf(result));
    }
    public void Minus(){
        result=Double.parseDouble(jtX.getText())+Double.parseDouble(jtY.getText());
        jtKQ.setText(String.valueOf(result));
    }
    public void Multi(){
        result=Double.parseDouble(jtX.getText())*Double.parseDouble(jtY.getText());
        jtKQ.setText(String.valueOf(result));
    }
    public void Div(){
        result=Double.parseDouble(jtX.getText())/Double.parseDouble(jtY.getText());
        jtKQ.setText(String.valueOf(result));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btPlus)
            Plus();
        if(e.getSource()==btMinus)
            Minus();
        if(e.getSource()==btMul)
            Multi();
        if(e.getSource()==btDiv)
            Div();
    }
}
