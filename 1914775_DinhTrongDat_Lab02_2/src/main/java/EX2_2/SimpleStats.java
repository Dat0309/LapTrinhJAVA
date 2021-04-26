/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX2_2;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class SimpleStats {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StatCalc cals=new StatCalc();
        double item = 0;
        
        System.out.println("Enter your numbers. Enter 0 to end.");
        System.out.println();
        
        do {            
            System.out.println("? ");
            item=in.nextDouble();
            if(item!=0)
                cals.enter(item);
        } while (item!=0);
        
        System.out.println("\nStatistics about your calc:\n");
        System.out.println("    Count:                  " + cals.getCount());
        System.out.println("    Sum:                     " +cals.getSum());
        System.out.println("    Minimum:            "+cals.getMin());
        System.out.println("    Maximum:           "+cals.getMax());
        System.out.println("    Average:               "+cals.getMean());
        System.out.println("    Standard Deviation:"+cals.getStandardDeviation());
    }
    
}
