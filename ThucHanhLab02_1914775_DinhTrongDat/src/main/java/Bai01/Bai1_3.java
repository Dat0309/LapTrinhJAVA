/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai01;


public class Bai1_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
        Point p = new Point(1,2);
        Circle c = new Circle(3,4,2);
        System.out.println(p.getName()+p.toString());
        System.out.println(c.getName()+c.toString());  
        } catch (Exception e) {
        }
        
    }
    
}
