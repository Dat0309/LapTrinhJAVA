/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6_2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author ADMIN
 */
public class ShapeDrawFrame extends JFrame{
    public static void main(String[] args) {
        new ShapeDrawFrame();
    }
    
    JCheckBoxMenuItem addLargeShapes;
    JCheckBoxMenuItem addBorderedShapes;
    JRadioButtonMenuItem red, green, blue, 
    cyan, magenta, yellow, 
    black, gray, white;
    JPopupMenu popup;

    public ShapeDrawFrame() {
        
        super("Shape Draw");
        ShapeCanvas canvas = new ShapeCanvas();
        setContentPane(canvas);
/* Create the menu bar and the menus */
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        JMenu addShapeMenu = new JMenu("Add");
        addShapeMenu.setMnemonic('A');  
        menubar.add(addShapeMenu);
        JMenu shapeColorMenu = new JMenu("Color");
        shapeColorMenu.setMnemonic('C');
        menubar.add(shapeColorMenu);
        JMenu optionsMenu = new JMenu("Options");
        optionsMenu.setMnemonic('O');   
        menubar.add(optionsMenu);
        JMenuItem rect = new JMenuItem("Rectangle");
        rect.setAccelerator( KeyStroke.getKeyStroke("ctrl R") );
        addShapeMenu.add(rect);
        rect.addActionListener(canvas);
        JMenuItem oval = new JMenuItem("Oval");
        oval.setAccelerator( KeyStroke.getKeyStroke("ctrl O") );
        addShapeMenu.add(oval);
        oval.addActionListener(canvas);
        JMenuItem roundrect = new JMenuItem("Round Rect");
        roundrect.setAccelerator( KeyStroke.getKeyStroke("ctrl D") );
        addShapeMenu.add(roundrect);
        roundrect.addActionListener(canvas);
        ButtonGroup colorGroup = new ButtonGroup();
        red = new JRadioButtonMenuItem("Red");
        shapeColorMenu.add(red);
        colorGroup.add(red);
        red.setSelected(true);
        green = new JRadioButtonMenuItem("Green");
        shapeColorMenu.add(green);
        colorGroup.add(green);
        blue = new JRadioButtonMenuItem("Blue");
        shapeColorMenu.add(blue);
        colorGroup.add(blue);
        cyan = new JRadioButtonMenuItem("Cyan");
        shapeColorMenu.add(cyan);
        colorGroup.add(cyan);   
        magenta = new JRadioButtonMenuItem("Magenta");
        shapeColorMenu.add(magenta);
        colorGroup.add(magenta);
        yellow = new JRadioButtonMenuItem("Yellow");
        shapeColorMenu.add(yellow);
        colorGroup.add(yellow);
        black = new JRadioButtonMenuItem("Black");
        shapeColorMenu.add(black);
        colorGroup.add(black);
        gray = new JRadioButtonMenuItem("Gray");
        shapeColorMenu.add(gray);
        colorGroup.add(gray);
        white = new JRadioButtonMenuItem("White");
        shapeColorMenu.add(white);
        colorGroup.add(white);
        JMenuItem clear = new JMenuItem("Clear");
        clear.setAccelerator( KeyStroke.getKeyStroke("ctrl C") );
        clear.addActionListener(canvas);
        optionsMenu.add(clear);
        optionsMenu.addSeparator();
        addLargeShapes = new JCheckBoxMenuItem("Add Large Shapes");
        addLargeShapes.setSelected(true);
        optionsMenu.add(addLargeShapes);
        addBorderedShapes = new JCheckBoxMenuItem("Add Shapes with Border");
        addBorderedShapes.setSelected(true);
        optionsMenu.add(addBorderedShapes);
        optionsMenu.addSeparator();
        JMenu background = new JMenu("Background Color");
        optionsMenu.add(background);
        background.add("Red").addActionListener(canvas);
        background.add("Green").addActionListener(canvas);
        background.add("Blue").addActionListener(canvas);
        background.add("Cyan").addActionListener(canvas);
        background.add("Magenta").addActionListener(canvas);
        background.add("Yellow").addActionListener(canvas);
        background.add("Black").addActionListener(canvas);
        background.add("Gray").addActionListener(canvas);
        background.add("White").addActionListener(canvas);
        popup = new JPopupMenu();
        popup.add("Delete Shape").addActionListener(canvas);
        popup.add("Bring to Front").addActionListener(canvas);
        popup.addSeparator();
        popup.add("Make Large").addActionListener(canvas);
        popup.add("Make Small").addActionListener(canvas);
        popup.addSeparator();
        popup.add("Add Black Border").addActionListener(canvas);
        popup.add("Remove Black Border").addActionListener(canvas);
        popup.addSeparator();
        popup.add("Set Color to Red").addActionListener(canvas);
        popup.add("Set Color to Green").addActionListener(canvas);
        popup.add("Set Color to Blue").addActionListener(canvas);
        popup.add("Set Color to Cyan").addActionListener(canvas);
        popup.add("Set Color to Magenta").addActionListener(canvas);
        popup.add("Set Color to Yellow").addActionListener(canvas);
        popup.add("Set Color to Black").addActionListener(canvas);
        popup.add("Set Color to Gray").addActionListener(canvas);
        popup.add("Set Color to White").addActionListener(canvas);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(20,50);
        setSize(550,420);
        show();
    }
    
    class ShapeCanvas extends JPanel implements ActionListener, MouseListener,MouseMotionListener{
        
        ArrayList shapes = new ArrayList();

        public ShapeCanvas() {
            setBackground(Color.white);
            addMouseListener(this);
            addMouseMotionListener(this);
        }
        
        public void paintComponent(Graphics g){
            super.paintComponent(g); // First, fill with background color.
            int top = shapes.size();
            for (int i = 0; i < top; i++) {
                Shape s = (Shape)shapes.get(i);
                s.draw(g);
                }
        }
        
        

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("Clear")) {
            shapes.clear(); // Remove all items from the ArrayList
            repaint();
            }
            else if (command.equals("Rectangle"))
                addShape(new RectShape());
            else if (command.equals("Oval"))
                addShape(new OvalShape());
            else if (command.equals("Round Rect"))
                addShape(new RoundRectShape());
            else if (command.equals("Red"))
                setBackground(Color.red);
            else if (command.equals("Green"))
                setBackground(Color.green);
            else if (command.equals("Blue"))
                setBackground(Color.blue);
            else if (command.equals("Cyan"))
                setBackground(Color.cyan);
            else if (command.equals("Magenta"))
                setBackground(Color.magenta);
            else if (command.equals("Yellow"))
                setBackground(Color.yellow);
            else if (command.equals("Black"))
                setBackground(Color.black);
            else if (command.equals("Gray"))
                setBackground(Color.gray);
            else if (command.equals("White"))
                setBackground(Color.white);
            else if (clickedShape != null) {
                    if (command.equals("Delete Shape"))
                        shapes.remove(clickedShape);
                    else if (command.equals("Bring to Front")) {
                        shapes.remove(clickedShape);
                        shapes.add(clickedShape);
                    }
                    else if (command.equals("Make Large"))
                        clickedShape.setSize(100,60);
                    else if (command.equals("Make Small"))
                        clickedShape.setSize(50,30);
                    else if (command.equals("Add Black Border"))
                        clickedShape.setDrawOutline(true);
                    else if (command.equals("Remove Black Border"))
                        clickedShape.setDrawOutline(false);
                    else if (command.equals("Set Color to Red"))
                        clickedShape.setColor(Color.red);
                    else if (command.equals("Set Color to Green"))
                        clickedShape.setColor(Color.green);
                    else if (command.equals("Set Color to Blue"))
                        clickedShape.setColor(Color.blue);
                    else if (command.equals("Set Color to Cyan"))
                        clickedShape.setColor(Color.cyan);
                    else if (command.equals("Set Color to Magenta"))
                        clickedShape.setColor(Color.magenta);
                    else if (command.equals("Set Color to Yellow"))
                        clickedShape.setColor(Color.yellow);
                    else if (command.equals("Set Color to Black"))
                        clickedShape.setColor(Color.black);
                    else if (command.equals("Set Color to Gray"))
                        clickedShape.setColor(Color.gray);
                    else if (command.equals("Set Color to White"))
                        clickedShape.setColor(Color.white);
                    repaint();
            }
        }
        
        void addShape(Shape shape){
            if (red.isSelected())
                shape.setColor(Color.red);
            else if (blue.isSelected())
                shape.setColor(Color.blue);
            else if (green.isSelected())
                shape.setColor(Color.green);
            else if (cyan.isSelected())
                shape.setColor(Color.cyan);
            else if (magenta.isSelected())
                shape.setColor(Color.magenta);
            else if (yellow.isSelected())
                shape.setColor(Color.yellow);
            else if (black.isSelected())
                shape.setColor(Color.black);
            else if (white.isSelected())
                shape.setColor(Color.white);
            else
                shape.setColor(Color.gray);
                shape.setDrawOutline( addBorderedShapes.isSelected() );
            if (addLargeShapes.isSelected())
                shape.reshape(3,3,100,60);
            else
                shape.reshape(3,3,50,30);
                shapes.add(shape);
            repaint();
        }
        
        Shape clickedShape = null;
        Shape draggedShape = null; 
        int prevDragX; 
        int prevDragY;
        

        @Override
        public void mouseClicked(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (draggedShape != null) {
                return;
            }
            int x = e.getX(); 
            int y = e.getY(); 
            clickedShape = null; 
            for ( int i = shapes.size() - 1; i >= 0; i-- ) {
                Shape s = (Shape)shapes.get(i);
                if (s.containsPoint(x,y)) {
                    clickedShape = s;
                    break;
                }
            }
            
            if (clickedShape == null) {
                return;
            }
            else if (e.isPopupTrigger()) {
                popup.show(this,x-10,y-2);
            }
            else if (e.isShiftDown()) {
                shapes.remove(clickedShape);
                shapes.add(clickedShape);
                repaint();
            }
            else {
                draggedShape = clickedShape;
                prevDragX = x;
                prevDragY = y;
            }
        
        }
        
        

        @Override
        public void mouseReleased(MouseEvent e) {
           if (draggedShape == null) {
            return;
            }
            int x = e.getX();int y = e.getY();
            if (e.isPopupTrigger()) {
                popup.show(this,x-10,y-2);
            }
            else {
                draggedShape.moveBy(x - prevDragX, y - prevDragY);
            if ( draggedShape.left >= getSize().width || draggedShape.top >= getSize().height||draggedShape.left + draggedShape.width < 0 ||draggedShape.top + draggedShape.height < 0 ) { 
                shapes.remove(draggedShape); 
            }
            repaint();
            }
            draggedShape = null; // Dragging is finished.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (draggedShape == null) {// User did not click a shape. There is nothing to do.
                return;
            }
            int x = e.getX();
            int y = e.getY();
            draggedShape.moveBy(x - prevDragX, y - prevDragY);
            prevDragX = x;
            prevDragY = y;
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    static abstract class Shape{
        int left, top; 
        int width, height;
        Color color = Color.white; 
        boolean drawOutline; 
        
        void reshape(int left, int top, int width, int height) {
            this.top = top;
            this.width = width;
            this.height = height;
        }
        
        void setSize(int width, int height) {
            this.width = width;
            this.height = height;
        }
        
        void moveBy(int dx, int dy) {
            left += dx;
            top += dy;
        }
        
        void setColor(Color color) {
            this.color = color;
        }
        
        void setDrawOutline(boolean draw) {
            drawOutline = draw;
        }
        
        boolean containsPoint(int x, int y) {
            if (x >= left && x < left+width && y >= top && y < top+height)
                return true;
            else
                return false;
    }
        
        abstract void draw(Graphics g);
    }
    
    static class RectShape extends Shape{
        void draw(Graphics g) {
            g.setColor(color);
            g.fillRect(left,top,width,height);
            if (drawOutline) {
                g.setColor(Color.black);
                g.drawRect(left,top,width,height);
            }
        }
    }
    
    static class OvalShape extends Shape{
        void draw(Graphics g) {
            g.setColor(color);
            g.fillOval(left,top,width,height);
            if (drawOutline) {
                g.setColor(Color.black);g.drawOval(left,top,width,height);
            }
        }
        
        boolean containsPoint(int x, int y) {
            double rx = width/2.0; // horizontal radius of ellipse
            double ry = height/2.0; // vertical radius of ellipse
            double cx = left + rx; // x-coord of center of ellipse
            double cy = top + ry; // y-coord of center of ellipse
            if ( (ry*(x-cx))*(ry*(x-cx)) + (rx*(y-cy))*(rx*(y-cy)) <= rx*rx*ry*ry )
                return true;
            else
                return false;
        }
    }
    
    static class RoundRectShape extends Shape{
        void draw(Graphics g) {
            g.setColor(color);
            g.fillRoundRect(left,top,width,height,width/3,height/3);
            if (drawOutline) {
                g.setColor(Color.black);
                g.drawRoundRect(left,top,width,height,width/3,height/3);
            }
        }
    }
    
}
