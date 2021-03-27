/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JaSwimBS;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class jlabel {
    
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public jlabel(){
      prepareGUI();
   }

   public static void main(String[] args){
      jlabel  swingControlDemo = new jlabel();      
      swingControlDemo.showLabelDemo();
   }

   private void prepareGUI(){
      mainFrame = new JFrame("Vi du Java Swing");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new JLabel("", JLabel.CENTER);        
      statusLabel = new JLabel("",JLabel.CENTER);    

      statusLabel.setSize(350,100);

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }

   private void showLabelDemo(){
      headerLabel.setText("Control in action: JLabel");      

      JLabel label  = new JLabel("", JLabel.CENTER);        
      label.setText("Chao mung ban den voi bai huong dan Java Swing.");
      label.setOpaque(true);
      label.setBackground(Color.GRAY);
      label.setForeground(Color.WHITE);
      controlPanel.add(label);

      mainFrame.setVisible(true);  
   }
}