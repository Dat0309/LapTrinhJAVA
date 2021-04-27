/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.TextArea;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/**
 *
 * @author ADMIN
 */
public class Borderlayout extends  JFrame{

    public Borderlayout() {
        initUI();
    }
    
    public final void initUI(){
        //create menubar
        JMenuBar menubar= new JMenuBar();
        JMenu file=new JMenu("File");
        
        menubar.add(file);
        setJMenuBar(menubar);
        
        //create toolbar (NORTH)
        JToolBar horizontalToolBar=new JToolBar();
        horizontalToolBar.setFloatable(false);
        
        ImageIcon exitIcon= new ImageIcon("C:/Users/ADMIN/Documents/NetBeansProjects/JavaSwimSelfStudy/src/main/java/Layout/Exit.png");
        JButton exitBtn=new JButton(exitIcon);
        exitBtn.setBorder(new EmptyBorder(0,0,0,0));
        horizontalToolBar.add(exitBtn);
        
        add(horizontalToolBar,BorderLayout.NORTH);
        
        //create vertical toolbar (WEST)
        JToolBar verticalToolBar=new JToolBar(JToolBar.VERTICAL);
        verticalToolBar.setFloatable(false);
        verticalToolBar.setMargin(new Insets(10,5,5,5));
        
        JButton driveBtn= new JButton("Driver");
        JButton computerBtn=new JButton("Computer");
        JButton printBtn=new JButton("Print");
        
        driveBtn.setBorder(new EmptyBorder(3,0,3,0));
        computerBtn.setBorder(new EmptyBorder(3,0,3,0));
        printBtn.setBorder(new EmptyBorder(3,0,3,0));
        
        verticalToolBar.add(driveBtn);
        verticalToolBar.add(computerBtn);
        verticalToolBar.add(printBtn);
        
        add(verticalToolBar,BorderLayout.WEST);
        
        //Create TextArea (Center)
        add(new TextArea(),BorderLayout.CENTER);
        
        //cretae Status bar (south)
        JLabel statusbar= new JLabel("Status");
        statusbar.setPreferredSize(new Dimension(-1,22));
        statusbar.setBorder(LineBorder.createBlackLineBorder());
        
        add(statusbar, BorderLayout.SOUTH);
        
        setSize(500,500);
        setTitle("Border Layout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
