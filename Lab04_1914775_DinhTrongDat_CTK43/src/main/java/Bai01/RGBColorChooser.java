/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai01;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author ADMIN
 */
public class RGBColorChooser extends  JFrame implements ChangeListener{

    private JSlider redSL, greenSL,blueSL;
    private JLabel redLB,greenLB,blueLB;
    private JPanel colorPatch;

    public RGBColorChooser() {
        redSL=new JSlider(JSlider.HORIZONTAL,0,255,0);
        greenSL=new JSlider(JSlider.HORIZONTAL,0,255,0);
        blueSL=new JSlider(JSlider.HORIZONTAL,0,255,0);
        
        redLB=new JLabel(" R = 0");
        greenLB=new JLabel(" G = 0");
        blueLB=new JLabel(" B = 0");
        
        redLB.setBackground(Color.white);
        redLB.setForeground(Color.red);
        redLB.setOpaque(true);
        
        greenLB.setBackground(Color.white);
        greenLB.setForeground(new Color(0,150,0));
        greenLB.setOpaque(true);
        
        blueLB.setBackground(Color.white);
        blueLB.setForeground(Color.blue);
        blueLB.setOpaque(true);
        
        redSL.addChangeListener(this);
        greenSL.addChangeListener(this);
        blueSL.addChangeListener(this);
        
        colorPatch = new JPanel();
        colorPatch.setBackground(Color.black);
        
        setBackground(Color.gray);
        getContentPane().setBackground(Color.gray);
        
        getContentPane().setLayout(new GridLayout(1,3,3,3));
        JPanel scrolls = new JPanel();
        JPanel labels = new JPanel();
        scrolls.setBackground(Color.gray);
        labels.setBackground(Color.gray);
        getContentPane().add(scrolls);
        getContentPane().add(labels);
        getContentPane().add(colorPatch);
        
        scrolls.setLayout(new GridLayout(3,1,2,2));
        scrolls.add(redSL);
        scrolls.add(greenSL);
        scrolls.add(blueSL);
        labels.setLayout(new GridLayout(3,1,2,2));
        labels.add(redLB);
        labels.add(greenLB);
        labels.add(blueLB);
    }
    
    
    @Override
    public void stateChanged(ChangeEvent e) {
        int r = redSL.getValue();
        int g = greenSL.getValue();
        int b = blueSL.getValue();
        redLB.setText(" R = " + r);
        greenLB.setText(" G = " + g);
        blueLB.setText(" B = " + b);
        colorPatch.setBackground(new Color(r,g,b));
    }
    
}
