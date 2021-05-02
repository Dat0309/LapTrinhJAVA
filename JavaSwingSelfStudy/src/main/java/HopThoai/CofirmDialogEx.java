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
public class CofirmDialogEx extends JFrame{
    private JPanel panel;

    public CofirmDialogEx() {
        initUI();
    }
    
    private void initUI(){
        panel=(JPanel)getContentPane();
        
        JMenuBar menubar= new JMenuBar();
        JMenu file= new JMenu("File");
        
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int n= JOptionPane.showConfirmDialog(panel,"Ban co muon thoat khong?","Exit",JOptionPane.YES_OPTION);
                if(n==JOptionPane.YES_OPTION)
                    System.exit(0);
                else 
                    JOptionPane.showMessageDialog(panel, "Ban da khong thoat chuong trinh","Dat",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        file.add(exit);
        menubar.add(file);
        setJMenuBar(menubar);
        
        setTitle("Cofirm Dialog");
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
