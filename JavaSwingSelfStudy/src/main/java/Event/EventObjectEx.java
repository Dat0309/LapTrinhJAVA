/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Event;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

/**
 *
 * @author ADMIN
 */
public class EventObjectEx extends JFrame{

    private JList list;
    private DefaultListModel model;
    
    public EventObjectEx() {
        initUI();
    }
    
    public final void initUI(){
        Container pane= getContentPane();
        GroupLayout gl= new GroupLayout(pane);
        pane.setLayout(gl);
        
        model = new DefaultListModel();
        list=new JList(model);
        list.setMinimumSize(new Dimension(250,150));
        list.setBorder(BorderFactory.createEtchedBorder());
        
        JButton ok=new JButton("OK");
        ok.addActionListener(new ClickAction());
        
        gl.setAutoCreateContainerGaps(true);
        
        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(ok)
                .addGap(20)
                .addComponent(list)
        );
        
        gl.setVerticalGroup(gl.createParallelGroup()
                .addComponent(ok)
                .addComponent(list));
        
        pack();
        
        setTitle("Event");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private class ClickAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            Locale locale= Locale.getDefault();
            Date date= new Date(e.getWhen());
            String tm=DateFormat.getTimeInstance(DateFormat.SHORT,locale).format(date);
            
            if(!model.isEmpty()){
                model.clear();
            }
            
            if(e.getID()==ActionEvent.ACTION_PERFORMED){
                model.addElement("Event id: ACTION_PERFORMED");
            }
            
            model.addElement("Time: "+tm);
            
            String source=e.getSource().getClass().getName();
            model.addElement("Source: "+source);
        }

    }
}
