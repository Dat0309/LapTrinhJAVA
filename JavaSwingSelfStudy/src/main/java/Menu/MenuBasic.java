/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import static javax.swing.Action.MNEMONIC_KEY;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

/**
 *
 * @author ADMIN
 */
public class MenuBasic extends JFrame{

    private JLabel statusbar;
    private JPopupMenu popupMenu;
    
    public MenuBasic() {
        initUI();
    }
    
    public final void initUI(){
        statusbar=new JLabel("Ready");
        statusbar.setBorder(BorderFactory.createEtchedBorder());
        statusbar.setBackground(Color.red);
        add(statusbar,BorderLayout.SOUTH);
        
        //Create Popup menu
        popupMenu = new JPopupMenu();
        
        //display full screen
        JMenuItem maxItem= new JMenuItem("Maximize");
        maxItem.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent e){
                  if(getExtendedState()!=JFrame.MAXIMIZED_BOTH)
                      setExtendedState(JFrame.MAXIMIZED_BOTH);
              }
        });
        popupMenu.add(maxItem);
        
        //Quit in popupmenu
       JMenuItem quitItem= new JMenuItem("Quit");
       quitItem.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               System.exit(0);
           }
       });
       
       popupMenu.add(quitItem);
       
        addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent e){
                if(e.getButton()==MouseEvent.BUTTON3)
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        });
        //MenuBar chứa các Jmenu
        JMenuBar menubar = new JMenuBar();
        //Jmenu chứa các menuitem
        JMenu saveMenu = new JMenu("Save");
        saveMenu.setMnemonic(KeyEvent.VK_S);
        
        JMenuItem saveItem= new JMenuItem("Save");
        JMenuItem saveAs=new JMenuItem("Save As ....");
        saveMenu.add(saveItem);
        saveMenu.add(saveAs);
        
        JMenu fileMenu=new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        
        JMenuItem newItem=new JMenuItem("New");
        JMenuItem openItem=new JMenuItem("Open");
        JMenuItem newExit = new JMenuItem("Exit");
        
        newItem.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
        openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
        newExit.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));
        //Tạo Event khi người dùng chọn vô menuitem exit
        newExit.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveMenu);
        fileMenu.addSeparator();
        fileMenu.add(newExit);
        
        JMenu viewMenu=new JMenu("View");
        viewMenu.setMnemonic(KeyEvent.VK_V);
        
        JCheckBoxMenuItem showStatusBar= new JCheckBoxMenuItem("Show status");
        showStatusBar.setMnemonic(KeyEvent.VK_S);
        showStatusBar.setDisplayedMnemonicIndex(5);
        showStatusBar.setSelected(true);
        
        showStatusBar.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                statusbar.setVisible(e.getStateChange()==ItemEvent.SELECTED);
            }
        });
        viewMenu.add(showStatusBar);
        
        //create Toolbar
        JToolBar toolbar= new JToolBar();
        
        ImageIcon exitIcon= new ImageIcon("C:/Users/ADMIN/Documents/NetBeansProjects/JavaSwingSelfStudy/src/main/java/Menu/exit.png");
        ImageIcon newIcon= new ImageIcon("C:/Users/ADMIN/Documents/NetBeansProjects/JavaSwingSelfStudy/src/main/java/Menu/New.png");
        ImageIcon openIcon=new ImageIcon("C:/Users/ADMIN/Documents/NetBeansProjects/JavaSwingSelfStudy/src/main/java/Menu/Open.png");
        
        JButton newBtn= new JButton("New",newIcon);
        JButton openBtn= new JButton("Open", openIcon);
        JButton exitBtn= new JButton("Exit",exitIcon);
        
        toolbar.add(newBtn);
        toolbar.add(openBtn);
        toolbar.add(exitBtn);
        
        exitBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        
        add(toolbar,BorderLayout.NORTH);
        
        //Thêm  filemenu vào menubar
        menubar.add(fileMenu);
        menubar.add(viewMenu);
        
        setJMenuBar(menubar);
        
        setTitle("Menu Example");
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    
}
