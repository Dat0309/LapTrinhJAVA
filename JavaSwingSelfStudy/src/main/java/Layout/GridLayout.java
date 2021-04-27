/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class GridLayout extends  JFrame{

    public GridLayout() {
        initUX();
    }
    
    public final void initUX(){
        JPanel panel=new JPanel();
        
        panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        panel.setLayout(new java.awt.GridLayout(5,4,5,5));
        
        String[] button={
            "CLS","BCK","","CLOSE",
            "7","8","9","/",
            "4","5","6","*",
            "1","2","3","-",
            "0",".","=","+"
        };
        
        for (int i = 0; i < button.length; i++) {
            if(i==2)
                panel.add(new JLabel(button[i]));
            else
                panel.add(new JButton(button[i]));    
        }
        add(panel);
        
        setTitle("Grid layout");
        setSize(350,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
