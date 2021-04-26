/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai02;

import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author ADMIN
 */
public class Menu extends JFrame{
    JMenu menu;
    JMenuItem jmNew =new JMenuItem("New"),jmOpen =new JMenuItem("Open"), jmExit=new JMenuItem("Exit"); 

    public Menu() {
     menu=new JMenu("File");
     menu.setMnemonic(KeyEvent.VK_F);
    JFrame f=new JFrame("Menu");
    JMenuBar mb=new JMenuBar();

    menu.add(jmNew);
    menu.add(jmOpen);
    menu.add(jmExit);
    
    
    jmNew.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
    jmOpen.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
    jmExit.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));
    mb.add(menu);
    f.setJMenuBar(mb);
    f.setSize(500,500);
    f.setLayout(null);
    f.setVisible(true);
    f.addWindowListener(new WindowAdapter(){
         @Override
         public void windowClosing(WindowEvent e) {
             System.exit(0);
         }
        
    });
    }


    
    
    
    
}
