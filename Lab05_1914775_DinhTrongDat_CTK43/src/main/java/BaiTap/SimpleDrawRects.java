/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class SimpleDrawRects extends JFrame{
    RainbowPalette colorInput;

    public SimpleDrawRects() {
        setBackground(Color.black);
        Rects canvas =new Rects();
        colorInput=new RainbowPalette();
        getContentPane().add(canvas,BorderLayout.CENTER);
        getContentPane().add(colorInput,BorderLayout.SOUTH);
    }
    public Insets getInsets(){
        return new Insets(2,2,2,2);
    }
    
    public static class ColoredRect{
        int x,y,width,height;
        Color color;
    }
    
    class Rects extends JPanel implements  MouseListener,MouseMotionListener{

        
        private ArrayList rects;
        private boolean dragging;
        private ColoredRect dragRect; 
        private int offsetx, offsety;

        public Rects() {
            setBackground(Color.white);
            addMouseListener(this);
            addMouseMotionListener(this);
            rects = new ArrayList();
        }
        
        ColoredRect findRect(int x,int y){
            for (int i = rects.size() - 1; i >= 0; i--) {
            ColoredRect rect = (ColoredRect)rects.get(i);
            if ( x >= rect.x && x < rect.x + rect.width 
            && y >= rect.y && y < rect.y + rect.height )
            return rect; 
            }
            return null;
        }
        
        void bringToFront(ColoredRect rect){
            if (rect != null) {
            rects.remove(rect); // Remove rect from current position.
            rects.add(rect); // Put rect in the ArrayList in last position.
            repaint();
            }
        }
        
        void deleteRect(ColoredRect rect){
            if(rect!=null){
                rects.remove(rect);
                repaint();
            }
        }
        
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            for (int i = 0; i < rects.size(); i++) {
                ColoredRect rect=(ColoredRect)rects.get(i);
                g.setColor(rect.color);
                g.fillRect(rect.x, rect.y, rect.width, rect.height);
                g.setColor(Color.black);
                g.drawRect(rect.x, rect.y, rect.width - 1, rect.height - 1);
            }
        }
        
        
        
        @Override
        public void mouseClicked(MouseEvent e) {
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if(dragging)
                return;
            
            if(e.isMetaDown()){
                ColoredRect rect = new ColoredRect();
                rect.x = e.getX() - 30;
                rect.y = e.getY() - 15;
                rect.width = 60;
                rect.height = 30;
                rect.color = colorInput.getSelectedColor();
                rects.add(rect);
                repaint();
            }
            else if(e.isShiftDown()){
                bringToFront(findRect(e.getX(), e.getY()));
            }
            else if(e.isAltDown()){
                deleteRect(findRect(e.getX(), e.getY()));
            }
            else {
                dragRect = findRect( e.getX(), e.getY() );
                if (dragRect != null) {
                dragging = true; 
                offsetx = e.getX() - dragRect.x;
                offsety = e.getY() - dragRect.y;
                }
                
            }
        }
        
        

        @Override
        public void mouseReleased(MouseEvent e) {
            if (dragging == false)
            return;
            dragRect = null;
            dragging = false;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if(dragging==false)
                return;
            dragRect.x = e.getX() - offsetx; 
            dragRect.y = e.getY() - offsety;
            
            if (dragRect.x < - dragRect.width / 2)
                dragRect.x = - dragRect.width / 2;
            else if (dragRect.x + dragRect.width/2 > getSize().width)
                dragRect.x = getSize().width - dragRect.width / 2;
            if (dragRect.y < - dragRect.height / 2)
                dragRect.y = - dragRect.height / 2;
            else if (dragRect.y + dragRect.height/2 > getSize().height)
                dragRect.y = getSize().height - dragRect.height / 2;
            
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
           
        }
        
    }
}
