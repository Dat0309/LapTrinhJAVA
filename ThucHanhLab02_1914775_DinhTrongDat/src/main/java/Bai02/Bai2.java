/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai02;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *Ơ
 * @author ADMIN
 */
public class Bai2 {

    //Nhap mang so nguyen
    public static void IntArr(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Xin moi nhap kich thuoc mang: ");
        int len=sc.nextInt();
        int[] MangNguyen=new int[len];
        for (int i = 0; i < MangNguyen.length; i++) {
            System.out.println("Xin moi nhap phan tu : ");
            MangNguyen[i]=sc.nextInt();
        }
        System.out.println("Mang so nguyen vua nhap la: ");
        Xuat(MangNguyen);
        System.out.println("");
        System.out.println("Mang so nguyen sau khi sap xep la: ");
        sortArr(MangNguyen);
        Xuat(MangNguyen);
        sc.close();
    }
    public static void sortArr(int a[]){
        int tam=a[0];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i]<a[j]){
                    tam=a[j];
                    a[j]=a[i];
                    a[i]=tam;
                }
            }
        }
    }
    public static void Xuat(int a[]){
        for (int i : a) {
            System.out.print(i+"\t");
        }
    }
    
    //Nhap Mang SV
    
    public static void main(String[] args) {
        IntArr();
        System.out.println("==============================");

    }
    
}
