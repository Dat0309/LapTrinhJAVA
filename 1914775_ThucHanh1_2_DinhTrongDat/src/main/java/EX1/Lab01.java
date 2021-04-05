/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX1;
import java.lang.Math;
/**
 *
 * @author PC230
 */
public class Lab01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int die1,die2;
        int countRolls=0;
        do{
            die1=(int)(Math.random()*6)+1;
            die2=(int)(Math.random()*6)+1;
            countRolls++;
        }while(!(die1==1&&die2==1));
        System.out.println("It took "+ countRolls+" rolls to get snake eyes.");
    }
    
}
