/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author ADMIN
 */
public class Calculater {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
        Calcul c=new Calcul("Calculator");
        c.setSize(800,100);
        c.setVisible(true);
        
        c.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
            
        });
    }
    
}
