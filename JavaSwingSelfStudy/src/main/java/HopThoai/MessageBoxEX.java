/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HopThoai;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class MessageBoxEX extends JFrame{
    private JPanel panel;

    public MessageBoxEX() {
        initUI();
    }
    
    private void initUI(){
        panel=(JPanel)getContentPane();
        
        JMenuBar menubar=new JMenuBar();
        JMenu file= new JMenu("File");
        
        JMenuItem about= new JMenuItem("about");
        about.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(panel, "This is a modal MessageBox","About",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        file.add(about);
        
        menubar.add(file);
        setJMenuBar(menubar);
        
        setTitle("MessageBox");
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
