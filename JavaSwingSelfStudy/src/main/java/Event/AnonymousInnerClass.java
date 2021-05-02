/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Event;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author ADMIN
 */
public class AnonymousInnerClass extends JFrame{

    public AnonymousInnerClass() {
        initUI();
    }
    
    public final void initUI(){
        Container pane=getContentPane();
        GroupLayout gl=new GroupLayout(pane);
        pane.setLayout(gl);

        MyButton close= new MyButton("CLOSE");
        gl.setAutoCreateContainerGaps(true);
        gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(close).addGap(220));
        gl.setVerticalGroup(gl.createSequentialGroup().addComponent(close).addGap(180));
        
        pack();
        
        setTitle("Event");
        setLocationRelativeTo(null);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private class MyButton extends JButton implements ActionListener{

        
        public MyButton(String text) {
            super(text);
            addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
           System.exit(0);
        }
        
    }
}
