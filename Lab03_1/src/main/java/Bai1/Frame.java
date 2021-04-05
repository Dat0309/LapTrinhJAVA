/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author ADMIN
 */
public class Frame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
        MicrowaveOven mo=new MicrowaveOven("The front view of a MicrowaveOven");
        mo.setSize(600,400);
        mo.setLocation(d.width/2-mo.getWidth()/2,d.height/2-mo.getHeight()/2);
        mo.setVisible(true);
        mo.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               System.exit(1);
            }
            
        });
    }
    
}
