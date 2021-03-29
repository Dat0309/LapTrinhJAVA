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
 *
 * @author ADMIN
 */
public class Bai2_2 {

    public static  void MangSV(){
        LinkedList<String> DSSV=new LinkedList<String>();
        String maSV,tenSV,NS,thongTin=null;
        Scanner sc=new Scanner(System.in);
        do {            
            System.out.println("Nhap MSSV: ");
            maSV=sc.nextLine();
            if(!maSV.isEmpty()) {
                System.out.println("Nhap Ten SV: ");
                tenSV=sc.nextLine();
                if(!tenSV.isEmpty()) {
                    System.out.println("Nhap NS: ");
                    NS=sc.nextLine();
                    thongTin=maSV+"\t"+tenSV+"\t"+NS;
                    DSSV.add(thongTin);
                }
            }
        } while (!maSV.isEmpty());
        sc.close();
        System.out.println("Masv"+"\t"+"Ho ten SV"+"\t"+"Ngay sinh");
        for(String str: DSSV)
            System.out.println(str);
        
        Collections.sort(DSSV);
        System.out.println("Mang Sinh Vien sau khi sap xep la: ");
        for (String string : DSSV) {
            System.out.println(string);
        }
    }
    public static void main(String[] args) {
        MangSV();
    }
    
}
