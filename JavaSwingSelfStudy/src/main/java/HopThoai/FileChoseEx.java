/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HopThoai;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ADMIN
 */
public class FileChoseEx extends JFrame{
    private JPanel panel;
    private JLabel path;

    public FileChoseEx() {
        initUI();
    }
    
    private void initUI(){
        panel= new JPanel();
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        
        JButton openfileBtn= new JButton("Open File");
        openfileBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFileChooser fc= new JFileChooser();
                fc.addChoosableFileFilter(new FileNameExtensionFilter("Image (jpg,jpeg,png,bmp,gif)","jpg","jpeg","png","bmp","gif"));
                int n= fc.showOpenDialog(panel);
                
                if(n==JFileChooser.APPROVE_OPTION)
                    path.setText(fc.getSelectedFile().getAbsolutePath());
            }
        });
        
        JButton openFolderBtn= new JButton("Open Folder");
        openFolderBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFileChooser fc= new JFileChooser();
                
                int n= fc.showOpenDialog(panel);
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if(n==JFileChooser.APPROVE_OPTION)
                    path.setText(fc.getSelectedFile().getAbsolutePath());
            }
        });
        
        panel.add(Box.createRigidArea(new Dimension(5,5)));
        panel.add(openfileBtn);
        panel.add(Box.createRigidArea( new Dimension(5,5)));
        panel.add(openFolderBtn);
        
        add(panel);
        
        path= new JLabel("Path: ");
        path.setPreferredSize(new Dimension(-1,22));
        path.setBorder(LineBorder.createBlackLineBorder());
        add(path,BorderLayout.SOUTH);
        
        setTitle("File Chose");
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
