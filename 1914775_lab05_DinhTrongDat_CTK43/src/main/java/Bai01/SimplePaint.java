/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai01;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

/**
 *
 * @author ADMIN
 */
public class SimplePaint extends JFrame implements  MouseListener,MouseMotionListener{
    private final static int
BLACK = 0,
RED = 1,
GREEN = 2,
BLUE = 3, 
CYAN = 4, 
MAGENTA = 5,
YELLOW = 6;

private int currentColor = BLACK; 
private int prevX, prevY;
private boolean dragging;
private Graphics graphicsForDrawing;
public SimplePaint() {
    addMouseListener(this);
    addMouseMotionListener(this);
    }
public void update(Graphics g) {
paint(g);
}
public void paint(Graphics g) {
    int width = getSize().width;
    int height = getSize().height;
    int colorSpacing = (height - 56) / 7;
    g.setColor(Color.white);
    g.fillRect(3, 3, width - 59, height - 6);
    g.setColor(Color.gray);
    g.drawRect(0, 0, width-1, height-1);
    g.drawRect(1, 1, width-3, height-3);
    g.drawRect(2, 2, width-5, height-5);
    g.fillRect(width - 56, 0, 56, height);
    g.setColor(Color.white);
    g.fillRect(width-53, height-53, 50, 50);
    g.setColor(Color.black);
    g.drawRect(width-53, height-53, 49, 49);
    g.drawString("CLEAR", width-48, height-23);
    g.setColor(Color.black);
    g.fillRect(width-53, 3 + 0*colorSpacing, 50, colorSpacing-3);
    g.setColor(Color.red);
    g.fillRect(width-53, 3 + 1*colorSpacing, 50, colorSpacing-3);
    g.setColor(Color.green);
    g.fillRect(width-53, 3 + 2*colorSpacing, 50, colorSpacing-3);
    g.setColor(Color.blue);
    g.fillRect(width-53, 3 + 3*colorSpacing, 50, colorSpacing-3);
    g.setColor(Color.cyan);
    g.fillRect(width-53, 3 + 4*colorSpacing, 50, colorSpacing-3);
    g.setColor(Color.magenta);
    g.fillRect(width-53, 3 + 5*colorSpacing, 50, colorSpacing-3);
    g.setColor(Color.yellow);
    g.fillRect(width-53, 3 + 6*colorSpacing, 50, colorSpacing-3);
    g.setColor(Color.white);
    g.drawRect(width-55, 1 + currentColor*colorSpacing, 53, colorSpacing);
    g.drawRect(width-54, 2 + currentColor*colorSpacing, 51, colorSpacing-2);
    }
private void changeColor(int y) {
    int width = getSize().width; 
    int height = getSize().height; 
    int colorSpacing = (height - 56) / 7; 
    int newColor = y / colorSpacing; 

    if (newColor < 0 || newColor > 6) 
    return;
    Graphics g = getGraphics();
    g.setColor(Color.gray);
    g.drawRect(width-55, 1 + currentColor*colorSpacing, 53, colorSpacing);
    g.drawRect(width-54, 2 + currentColor*colorSpacing, 51, colorSpacing-2);
    currentColor = newColor;
    g.setColor(Color.white);
    g.drawRect(width-55, 1 + currentColor*colorSpacing, 53, colorSpacing);
    g.drawRect(width-54, 2 + currentColor*colorSpacing, 51, colorSpacing-2);
    g.dispose();
}
private void setUpDrawingGraphics() {
    graphicsForDrawing = getGraphics();
    switch (currentColor) {
    case BLACK:
    graphicsForDrawing.setColor(Color.black);
    break;
    case RED:
    graphicsForDrawing.setColor(Color.red);
    break;
    case GREEN:
    graphicsForDrawing.setColor(Color.green);
    break;
    case BLUE:
    graphicsForDrawing.setColor(Color.blue);
    break;
    case CYAN:
    graphicsForDrawing.setColor(Color.cyan);
    break;
    case MAGENTA:
    graphicsForDrawing.setColor(Color.magenta);
    break;
    case YELLOW:
    graphicsForDrawing.setColor(Color.yellow);
    break;}
}
public void mousePressed(MouseEvent evt) {
    int x = evt.getX(); // x-coordinate where the user clicked.
    int y = evt.getY(); // y-coordinate where the user clicked.

    int width = getSize().width; 
    int height = getSize().height;

    if (dragging == true) 
    return; 


    if (x > width - 53) {
    if (y > height - 53)
    repaint(); 
    else
    changeColor(y); 
    }
    else if (x > 3 && x < width - 56 && y > 3 && y < height - 3) {
    prevX = x;
    prevY = y;
    dragging = true;
    setUpDrawingGraphics();
    }

}
public void mouseReleased(MouseEvent evt) {
    if (dragging == false)
    return; // Nothing to do because the user isn't drawing.
    dragging = false;
    graphicsForDrawing.dispose();
    graphicsForDrawing = null;
}
public void mouseDragged(MouseEvent evt) {
    if (dragging == false)
    return; 

    int x = evt.getX(); 
    int y = evt.getY(); 

    if (x < 3) 
    x = 3; 
    if (x > getSize().width - 57) 
    x = getSize().width - 57;

    if (y < 3) 
        y = 3; 
    if (y > getSize().height - 4) 
    y = getSize().height - 4;

    graphicsForDrawing.drawLine(prevX, prevY, x, y); 

    prevX = x; 
    prevY = y;

}
public void mouseEntered(MouseEvent evt) { } 
public void mouseExited(MouseEvent evt) { } 
public void mouseClicked(MouseEvent evt) { } 
public void mouseMoved(MouseEvent evt) { }
    
public static void main(String[] args) {
        SimplePaint SP = new SimplePaint();
        SP.setSize(400,300);
        SP.setVisible(true);
        SP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
