/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX1;

/**
 *
 * @author PC230
 */
public class Lab1_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String line;
        int i;
        char ch;
        boolean didCR;
        
        System.out.println("Enter a line of text");
        System.out.println("? ");
        line = TextIO.getln();
        
        System.out.println();
        didCR=true;
        
        for(i=0;i<line.length();i++){
            ch=line.charAt(i);
            if(Character.isLetter(ch)){
                System.out.println(ch);
                didCR=false;
            }
            else {if (didCR==false){
                System.out.println();
                didCR=true;
                }
            }
        }
        System.out.println();
        
    }
    
}
