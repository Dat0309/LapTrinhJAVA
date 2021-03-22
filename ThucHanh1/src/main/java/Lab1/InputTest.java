package Lab1;


import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC225
 */
public class InputTest {
    public static void main(String[] args)
    {
        String name = JOptionPane.showInputDialog("What is your name?");   
        String input = JOptionPane.showInputDialog("How old are you?");
        int age = Integer.parseInt(input);
        System.out.println("Hello, "+ name + ". Next year, you'll be " +(age+1));
        System.exit(0);
    }
}
