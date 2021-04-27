/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Layout;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.TextField;
import java.security.cert.PKIXReason;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class Boxlayour extends JFrame{

    public Boxlayour() {
        initUI();
    }
    
    public final void initUI(){
        JPanel basic=new JPanel();
        basic.setLayout(new BoxLayout(basic,BoxLayout.Y_AXIS));
        add(basic);
        
        basic.add(Box.createVerticalGlue());
                basic.add(new TextField(" Tu hocj javaSwing"));
        
        JPanel bottom=new JPanel();
        bottom.setAlignmentX(Component.RIGHT_ALIGNMENT);
        bottom.setLayout(new BoxLayout(bottom,BoxLayout.X_AXIS));
        
        JButton ok=new JButton("OK");
        JButton close=new JButton("CLOSE");
        
        bottom.add(ok);
        bottom.add(Box.createRigidArea(new Dimension(5,0)));
        bottom.add(close);
        bottom.add(Box.createRigidArea(new Dimension(15,0)));
        
        basic.add(bottom);

        basic.add(Box.createRigidArea(new Dimension(0,15)));
        
        setTitle("Box layout");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
