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
public class Lab1_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int n;
       int maxDivisors=1;
       int numWithMax=1;
       for(n=2;n<=10000;n++){
           int d;
           int divisorCount=0;
           for (d=1;d<=n;d++){
               if(n%d==0)
                   divisorCount++;
           }
               if(divisorCount>maxDivisors);{
                    maxDivisors=divisorCount;
                    numWithMax=n;
                }    
       }
        System.out.println("Among integer between 1 and 10000,");
        System.out.println("The maximun number of divisors is " +maxDivisors);
        System.out.println("A number with "+maxDivisors+" divisors is "+numWithMax);
    }
    
}
