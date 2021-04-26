/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class RainbowPalette extends JPanel implements MouseListener{

    private float selectedHue=0;
    private Color selectedColor=Color.getHSBColor(0, 1, 1);

    public RainbowPalette() {
        addMouseListener(this);
        setPreferredSize(new Dimension(256,24));
        setBackground(Color.GRAY);
        
    }
    
    public Color getSelectedColor(){
        return selectedColor;
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int width=getWidth();
        int height=getHeight();
        for (int i = 0; i < width-8; i++) {
            float hue=(float)i/(width-8);
            g.setColor(Color.getHSBColor(hue, 1, 1));
            g.drawLine(i+4, 4, i+4, height-5);
            
        }
        
        int x=4 + (int)(selectedHue*(width-8));
        g.setColor(Color.WHITE);
        g.drawRect(x-2, 3, 2, height-7);
        g.drawRect(x-3, 2, 4, height-5);
        
    }
    

    

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent evt) {
        int x=evt.getX();
        selectedHue=(float)x/(getSize().width-4);
        if(selectedHue<0)
            selectedHue=0;
        else if(selectedHue>1)
            selectedHue=1;
        selectedColor=Color.getHSBColor(selectedHue, 1, 1);
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
