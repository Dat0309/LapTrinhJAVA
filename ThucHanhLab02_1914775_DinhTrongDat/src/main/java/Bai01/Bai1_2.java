/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai01;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Bai1_2 {

public static void DoanSo(int n){
        Random rd=new Random();
        int ranNumber=rd.nextInt(101)+1;
        Scanner sc=new Scanner(System.in);
        while (n>0) {
            int soDoan = 0;
            try {
                System.out.println("Xin moi doan so ");
                 soDoan=sc.nextInt();
            } catch (Exception e) {
                System.out.println("Nhap sai, xin moi nhap lai! ");
            }
            if(soDoan==ranNumber){
                System.out.println("Ban da doan dung! ");
                break;
            }
            else if(soDoan > ranNumber){
                System.out.println("Lon hon");
                n--;
            }
            else if(soDoan<ranNumber) {
                System.out.println("Nho hon");
                n--;
            }
            if(n==0)
                System.out.println("Ban da het luot choi!!! THUA");
        }
        sc.close();
    }
    public static void main(String[] args) {
        DoanSo(5);
    }
    
}
