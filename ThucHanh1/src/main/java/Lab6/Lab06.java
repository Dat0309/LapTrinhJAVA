/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab6;

/**
 *
 * @author PC225
 */
public class Lab06 {
    public static void main(String[] args) {
        Employee harry=new Employee("Harry Hacker", 50000, 1989, 10, 1);
        harry.raiseSalary(5);
        System.out.println("Name= " +harry.getName()+"Salary= "+harry.getSalary());
    }
  
    
}
