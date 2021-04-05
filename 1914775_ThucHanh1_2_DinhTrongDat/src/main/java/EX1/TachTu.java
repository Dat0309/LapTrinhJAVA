/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX1;

import java.util.Scanner;

/**
 *
 * @author PC230
 */
public class TachTu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String line;
       Scanner sc= new Scanner(System.in);
        System.out.println("? ");
        line=sc.nextLine();
        
            String[] str=line.split("\\s");
            for(String item:str)
                System.out.println(item);
        }
    }
    
