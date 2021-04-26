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
public final class PairOfDice {
    private int die1; // Number showing on the first die.
    private int die2; // Number showing on the second die.
/**
* Constructor creates a pair of dice and rolls them so that
* they initially show some random value.
*/
    public PairOfDice() {
        roll(); // Call the roll() method to roll the dice.
    }
/**
* Roll the dice by setting each die to be a random number
between 1 and 6.
*/
    public void roll() {
        die1 = (int)(Math.random()*6) + 1;
        die2 = (int)(Math.random()*6) + 1;
    }
/**
* Return the number showing on the first die.
*/
    public int getDie1() {
        return die1;
    }
/**
* Set the value of the first die. Throws an
IllegalArgumentException
* if the value is not in the range 1 to 6.
*/
    public void setDie1( int value ) {
        if ( value < 1 || value > 6 )
        throw new IllegalArgumentException("Illegal dice value " +value);
        die1 = value;
    }
/**
* Return the number showing on the second die.
*/
    public int getDie2() {
        return die2;
    }
/**
* Set the value of the second die. Throws an
IllegalArgumentException
* if the value is not in the range 1 to 6.
*/
    public void setDie2( int value ) {
        if ( value < 1 || value > 6 )
        throw new IllegalArgumentException("Illegal dice value " +value);
        die2 = value;
    }
/**
* Return the total showing on the two dice.
     * @return 
*/
    public int getTotal() {
        return die1 + die2;
    }
/**
* Return a String representation of a pair of dice, where die1
* and die2 are instance variables containing the numbers that
are
* showing on the two dice.
*/
    public String toString() {
        if (die1 == die2)
        return "double " + die1;
        else
        return die1 + " and " + die2;
    }
}
