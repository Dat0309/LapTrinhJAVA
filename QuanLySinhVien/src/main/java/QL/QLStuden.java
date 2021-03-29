/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QL;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;



/**
 *
 * @author ADMIN
 */
public class QLStuden {
    DSStuden dssv= new DSStuden();
    
    public void HSDTBMin(DSStuden a){
        for (Studen d : a.ds) {
            if(d.getDTB()==a.DTBMin())
                System.out.println(d);
        }
    }
    
    public void HSDTBMax(DSStuden a){
        for (Studen d : a.ds) {
            if(d.getDTB()==a.DTBMax())
                System.out.println(d);
        }
    }
    
    public void TimSV(DSStuden a){
        Scanner sc=new Scanner(System.in);
        System.out.println("Xin moi nhap MSSV: ");
        String nhap=sc.nextLine();
        for (Studen d : a.ds) {
            if(nhap.compareTo(d.getMaSV())==0){
                System.out.printf("Thong tin SV co ma: %s",nhap+"\n");
                System.out.println(d);
                break;
            }else{
                System.out.printf("Khong tim thay SV co ma: %s",nhap);
                break;
            }
        }
    }
    
    public void sortName(DSStuden a){
        Collections.sort(a.ds, new Comparator<Studen>() {
            @Override
            public int compare(Studen o1, Studen o2) {
                int cmp=o2.getTen().compareTo(o1.getTen());
                if(cmp>=0)
                    return -1;
                return 1;
            }
        });
    }
    
    private DSStuden DSHB(DSStuden a){
        DSStuden kq = new DSStuden();
        for (Studen d : a.ds) {
            if(d.getDTB()>=8)
                kq.Them(d);
        }
        return kq;
    }
    public void SortHB(DSStuden a){
        DSStuden dshb=new DSStuden();
        dshb=DSHB(a);
        Collections.sort(dshb.ds, new Comparator<Studen>() {
            @Override
            public int compare(Studen o1, Studen o2) {
                   return o1.getDTB()>=o2.getDTB()?-1:1;
            }
        });
        for (Studen d : dshb.ds) {
            System.out.println(d);
        }
    }
}
