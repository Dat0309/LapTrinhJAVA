/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX1;

import org.w3c.dom.Text;

/**
 *
 * @author PC230
 */
public class Lab1_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       double numST,NumND,value;
       char operator ;
       
        System.out.println("Enter expressions such as 2 + 2 or 34.2 * 7.81");
        System.out.println("using any of the operators +,-,*,/."+"\n");
        
        while(true){
            System.out.println("? ");
            numST=TextIO.getDouble();
            if(numST==0)
                break;
            operator=TextIO.getChar();
            NumND=TextIO.getlnDouble();
            
            switch(operator){
                case '+':
                    value=numST+NumND;
                    break;
                case '-':
                    value=numST-NumND;
                    break;
                case '*':
                    value=numST*NumND;
                    break;
                case '/':
                    value=numST/NumND;
                    break;
                default:
                    System.out.println("Unknown operator: "+ operator);
                    continue;
            }
            System.out.println("Value is "+value+"\n");
        }
        System.out.println("Good Bye");
    }
    
}
