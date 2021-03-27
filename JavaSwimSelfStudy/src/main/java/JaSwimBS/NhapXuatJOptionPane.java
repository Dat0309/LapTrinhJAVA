/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JaSwimBS;

import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class NhapXuatJOptionPane {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input=JOptionPane.showInputDialog("How much money do you need to retire?");
        double goal =Double.parseDouble(input);
        
        input = JOptionPane.showInputDialog("How much money will you contribute every years?");
        double payment = Double.parseDouble(input);
        
        input =JOptionPane.showInputDialog("Insert rate in :");
        double interesRate=Double.parseDouble(input);
        
        double balance=0;
        int years=0;
        while(balance<goal)
        {
            balance +=payment;
            double interest=balance*interesRate/100;
            balance += interest;
            
            years++;
        }
        System.out.println("Your can retire in "+years+" years.");
        System.exit(0); 
    }
    
}
