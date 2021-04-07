/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author ADMIN
 */
public class MainDisplayClock {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame=new JFrame("Display Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(330,330));
        DisplayClock dc=new DisplayClock();
        dc.setPreferredSize(new Dimension(320,320));
        dc.init();
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(dc,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
    
}
