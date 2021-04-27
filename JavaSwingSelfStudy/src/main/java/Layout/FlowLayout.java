/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layout;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTree;

/**
 *
 * @author ADMIN
 */
public class FlowLayout extends JFrame{

    public FlowLayout() {
        initUI();
    }
    
    public final void initUI(){
        JPanel panel=new JPanel();
        
        JTextArea area= new JTextArea("text");
        area.setPreferredSize(new Dimension(200,200));
        
        JButton button=new JButton("button");
        panel.add(button);
        
        JTree tree= new JTree();
        panel.add(tree);
        
        panel.add(area);
        add(panel);
        
        pack();
        
        setTitle("Flow layout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
}
