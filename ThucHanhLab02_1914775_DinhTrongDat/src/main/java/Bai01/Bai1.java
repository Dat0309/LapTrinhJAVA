/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai01;

import java.awt.BorderLayout;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Bai1 {

    public static void SpilitStr(){
        String str;
        Scanner sc = new  Scanner(System.in);
        System.out.println("Xin moi nhap mot chuoi bat ki: ");
        str=sc.nextLine();
        
        System.out.println("Cac tu co trong chuoi la : ");
        String[] out = str.split(" ");
            for (String n: out) {
                System.out.println(n);
        }
        sc.close();
    }
    
    public static void main(String[] args) {
        SpilitStr();
        System.out.println("=========================================");

    }
    
}
