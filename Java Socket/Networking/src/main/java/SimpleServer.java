
import java.awt.FlowLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class SimpleServer extends JFrame{
    private JTextArea display;

    public SimpleServer() {
        initUI();
    }
    
    private void initUI(){
        setTitle("Simple Sever");
        setLayout(new FlowLayout());
        display= new JTextArea(10,30);
        add(display);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private int [] getHeso(String mes){
        int[] heso= new int[3];
        StringTokenizer st= new StringTokenizer(mes,",",false);
        int i=0;
        while (st.hasMoreTokens()) {            
            String s=st.nextToken();
            if(s.compareTo(",")!=0){
                heso[i]=Integer.parseInt(s);
                i++;
            }
        }
        return heso;
    }
    
    private String GiaiPTBac2(int a, int b, int c){
        int delta= b*b-4*a*c;
        String s;
        if(delta<0){
            s=" Vo Nghiem";
        }
        else{
            double x1=(-b+Math.sqrt(delta))/(2*a);
            double x2=(-b-Math.sqrt(delta))/(2*a);
            s=" pt co 2 nghiem: "+x1+" va "+x2;
        }
        return s;
    }
    
    public void StartSever(){
        ServerSocket server = null;
        Socket conn= null;
        String message;
        DataInputStream input;
        DataOutputStream ouput;
        
        try {
            server= new ServerSocket(8000);
            while (true) {                
                conn= server.accept();
                input=new DataInputStream(conn.getInputStream());
                message= input.readUTF();
                int[] heso=getHeso(message);
                display.append("Message : yeu cau giai pt ba 2: "+message+"\n");
                String kq=GiaiPTBac2(heso[0],heso[1], heso[2]);
                ouput= new DataOutputStream(conn.getOutputStream());
                ouput.writeUTF(kq);
            }
        } catch (Exception e) {
        }
    }
}
