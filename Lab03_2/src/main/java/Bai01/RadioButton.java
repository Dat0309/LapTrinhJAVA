/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai01;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author ADMIN
 */
public class RadioButton extends JFrame implements ActionListener{
    JRadioButton redRadio,blueRadio,greenRadio,blackRadio;
    JLabel jlb;

    public RadioButton() {
        getContentPane().setLayout(new GridLayout(5,1));
        
        ButtonGroup colorGroup=new ButtonGroup();
        
        redRadio=new JRadioButton("Red");
        colorGroup.add(redRadio);
        redRadio.addActionListener(this);
        getContentPane().add(redRadio);
        
        blueRadio=new JRadioButton("Blue");
        colorGroup.add(blueRadio);
        blueRadio.addActionListener(this);
        getContentPane().add(blueRadio);
        
        greenRadio=new JRadioButton("Green");
        colorGroup.add(greenRadio);
        greenRadio.addActionListener(this);
        getContentPane().add(greenRadio);
        
        blackRadio=new JRadioButton("Black");
        colorGroup.add(blackRadio);
        blackRadio.addActionListener(this);
        getContentPane().add(blackRadio);
        
        blackRadio.setSelected(true);
        
        jlb=new JLabel("Black is selected",JLabel.CENTER);
        jlb.setForeground(Color.white);
        jlb.setBackground(Color.black);
        jlb.setOpaque(true);
        getContentPane().add(jlb);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(blackRadio.isSelected()){
            jlb.setBackground(Color.black);
            jlb.setText("Black is selected");
        }
        else if(redRadio.isSelected()){
            jlb.setBackground(Color.red);
            jlb.setText("Red is selected");
        }
        else if(blueRadio.isSelected()){
            jlb.setBackground(Color.blue);
            jlb.setText("Blue is selected");
        }
        else if(greenRadio.isSelected()){
            jlb.setBackground(Color.green);
            jlb.setText("Green is selected");
        }
    }
    
}
