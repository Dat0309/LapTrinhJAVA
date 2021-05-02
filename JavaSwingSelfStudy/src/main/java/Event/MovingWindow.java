/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Event;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ADMIN
 */
public class MovingWindow extends JFrame implements  ComponentListener{

    
    private JLabel labelx;
    private JLabel labely;
    public MovingWindow() {
        initUI();
    }
    
    public void initUI(){
        Container pane= getContentPane();
        GroupLayout gl= new GroupLayout(pane);
        pane.setLayout(gl);
        
        addComponentListener(this);
        
        labelx= new JLabel("x: ");
        labelx.setFont(new Font("Serif",Font.BOLD,14));
        labelx.setBounds(20,20,60,25);
        
        labely= new JLabel("y: ");
        labely.setFont(new Font("Serif",Font.BOLD,14));
        labely.setBounds(20,45,60,25);
        
        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);
        
        gl.setHorizontalGroup(gl.createParallelGroup().addComponent(labelx).addComponent(labely).addGap(250));
        
        gl.setVerticalGroup(gl.createSequentialGroup().addComponent(labelx).addComponent(labely).addGap(130));
        
        pack();
        
        setTitle("Event");
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        int x= e.getComponent().getX();
        int y= e.getComponent().getY();
        
        labelx.setText("x: "+x);
        labely.setText("y: "+y);
    }

    @Override
    public void componentShown(ComponentEvent e) {
        
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        
    }
}
