/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5;
import java.util.*;
/**
 *
 * @author PC225
 */
public class Lab05 {
    public static void main(String[] args) {
        Employee[] staff=new Employee[3];
        staff[0]=new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1]=new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2]=new Employee("Tony Tester", 40000, 1990, 3, 15);
        
        for (int i=0;i<staff.length;i++)
            staff[i].raiseSalary(5);
        
        for(int i=0;i<staff.length;i++){
            Employee e=staff[i];
            System.out.println("Name= " + e.getName() +",Salary= "+e.getSalary()+",HireDay= "+e.getSalary());
        }
        
    }
}
