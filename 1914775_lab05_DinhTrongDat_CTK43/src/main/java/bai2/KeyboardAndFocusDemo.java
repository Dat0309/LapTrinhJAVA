package bai2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyboardAndFocusDemo extends JFrame
implements KeyListener, FocusListener, MouseListener {
static final int SQUARE_SIZE = 40;
Color squareColor; 
int squareTop, squareLeft; 
boolean focussed = false; 
DisplayPanel canvas;

public KeyboardAndFocusDemo () {
  squareTop = getSize().height / 2 - SQUARE_SIZE / 2;
squareLeft = getSize().width / 2 - SQUARE_SIZE / 2;
squareColor = Color.red;
canvas = new DisplayPanel(); 
setContentPane(canvas); 
canvas.setBackground(Color.white);
canvas.addFocusListener(this); 
canvas.addKeyListener(this); 
canvas.addMouseListener(this);
} 

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
class DisplayPanel extends JPanel {
    public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (focussed)
    g.setColor(Color.cyan);
    else
    g.setColor(Color.lightGray); 
    int width = getSize().width; 
    int height = getSize().height;
    g.drawRect(0,0,width-1,height-1);
    g.drawRect(1,1,width-3,height-3);
    g.drawRect(2,2,width-5,height-5);
    g.setColor(squareColor);
    g.fillRect(squareLeft, squareTop, SQUARE_SIZE, SQUARE_SIZE);
    if (!focussed) {
    g.setColor(Color.magenta);
    g.drawString("Click to activate",7,20);
        }
    } 
}
public void focusGained(FocusEvent evt) {
    focussed = true;
    canvas.repaint(); 
}
public void focusLost(FocusEvent evt) {
focussed = false;
canvas.repaint(); 
}
public void keyTyped(KeyEvent evt) {
    int key = evt.getKeyCode(); 
    if (key == KeyEvent.VK_LEFT) {
    squareLeft -= 8;
    if (squareLeft < 3)
    squareLeft = 3;
    canvas.repaint();
                }
        else if (key == KeyEvent.VK_RIGHT) {
            squareLeft += 8;
            if (squareLeft > getSize().width - 3 - SQUARE_SIZE)
            squareLeft = getSize().width - 3 - SQUARE_SIZE;
            canvas.repaint();
            }
        else if (key == KeyEvent.VK_UP) {
        squareTop -= 8;
        if (squareTop < 3)
        squareTop = 3;
        canvas.repaint();
        }
    else if (key == KeyEvent.VK_DOWN) {
    squareTop += 8;
    if (squareTop > getSize().height - 3 - SQUARE_SIZE)
    squareTop = getSize().height - 3 - SQUARE_SIZE;
    canvas.repaint();
    }
}
public void keyReleased(KeyEvent evt) {}
public void mousePressed(MouseEvent evt) {canvas.requestFocus();}
public void mouseEntered(MouseEvent evt) { } 
public void mouseExited(MouseEvent evt) { } 
public void mouseReleased(MouseEvent evt) { } 
public void mouseClicked(MouseEvent evt) { }
    public static void main(String[] args) {
        KeyboardAndFocusDemo KAFD = new KeyboardAndFocusDemo();
        KAFD.setSize(400,400);
        KAFD.setVisible(true);
        KAFD.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
