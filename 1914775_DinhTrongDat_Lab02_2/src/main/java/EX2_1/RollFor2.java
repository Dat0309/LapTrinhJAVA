/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX2_1;

/**
 *
 * @author ADMIN
 */
public class RollFor2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            PairOfDice dice=new PairOfDice();
            int rollCount=0;
            do {            
                dice.roll();
                System.out.println("The dice come up "+dice);
                rollCount++;
        } while (dice.getTotal()!=2);
            System.out.println("\nIt took "+rollCount+" rolls to get a 2.");
            System.out.println();
            System.out.println(dice.toString());
    }
}
