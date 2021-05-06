/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimpleClient sc= new SimpleClient();
        SimpleServer ss= new SimpleServer();
        sc.setVisible(true);
        ss.setVisible(true);
        ss.StartSever();
    }
    
}
