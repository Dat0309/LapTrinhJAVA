/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QL;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class TruongHoc {

    /**
     * @Dinh Trong Dat
     */
 
    public static void main(String[] args) throws FileNotFoundException  {
            DSStuden DSSV=new DSStuden();
            QLStuden ql=new QLStuden();
            Scanner input=new Scanner(System.in);
            while (true) {   
                System.out.println("");
                System.out.println("=================================");
                System.out.println("0.Thoat");
                System.out.println("1.Nhap du lieu bang tay");
                System.out.println("2.Nhap du lieu tu file");
                System.out.println("3.Xuat DS");
                System.out.println("4.Hien thi sinh vien co DTB min, max");
                System.out.println("5.Tim kiem SV theo MASV");
                System.out.println("6.Sap xep ds SV theo ten");
                System.out.println("7.Tim SV co hoc bong va sap xep tang dan theo diem");
                
                int Nhap=input.nextInt();
                switch (Nhap) {
                    case 0 -> {
                        return;
                    }
                    case 1 -> {
                        DSSV.NhapTuBanPhim();
                        DSSV.Xuat();
}
                    case 2 -> {
                        DSSV.NhapTuFile();
                        System.out.println("Du lieu da duoc nhap vao");
}
                    case 3 -> {
                        DSSV.Xuat();
}
                    case 4 -> {
                        System.out.println("Sinh vien co diem trung binh thap nhat la: ");
                        ql.HSDTBMin(DSSV);
                        System.out.println("Sinh vien co diem trung binh cao nhat la: ");
                        ql.HSDTBMax(DSSV);
}
                    case 5->{
                        ql.TimSV(DSSV);
                        break;
}
                    case 6->{
                        ql.sortName(DSSV);
                        DSSV.Xuat();
                        break;
}
                    case 7->{
                        System.out.println("DSSV dat HOC BONG:"+"\n"+"========================");
                        ql.SortHB(DSSV);
                        break;
}
                    default -> {
                    }
                }

        }
    }
    
}
