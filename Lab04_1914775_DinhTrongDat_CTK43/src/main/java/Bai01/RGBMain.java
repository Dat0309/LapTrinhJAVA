/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai01;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author ADMIN
 */
public class RGBMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
        RGBColorChooser rgb=new RGBColorChooser();
        rgb.setSize(500,500);
        rgb.setLocation(d.width/2-rgb.getWidth()/2,d.height/2-rgb.getHeight()/2);
        rgb.setVisible(true);
        rgb.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
            
        });
    }
    
}
