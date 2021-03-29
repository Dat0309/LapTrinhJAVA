/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QL;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class DSStuden {
    Scanner sc = new Scanner(System.in);
    public LinkedList<Studen> ds = new LinkedList<Studen>(); 
    public void Them(Studen x){
        ds.add(x);
    }

    @Override
    public String toString() {
        String str="";
        for (Studen studen : ds) {
            str+=studen+"\n";
        }
        return str;
    }
    
    public void Xuat(){
        System.out.println("maSV"+'\t'+"DTB"+"\t"+"Ten"+"\t\t\t"+"Gioi tinh"+"\t"+"Ngay sinh"+"\t"+"Dia chi");
        System.out.println(this);
    }
    public void NhapTuBanPhim(){
        String line="";
        do {            
            System.out.println("Nhap:  masv, dtb, ten, gioitinh, ngaysinh, diachi");
            line=sc.nextLine();
            String[] str=line.split(",");
            Them(new Studen(str[0],Float.parseFloat(str[1]),str[2],str[3],str[4],str[5]));
        } while (!line.isEmpty());
    }
    public void NhapTuFile() throws FileNotFoundException{
        File file=new File("DSSV.txt");
        Scanner sc= new Scanner(file);
        while (sc.hasNext()) {            
            String line=sc.nextLine();
            String[] str=line.split(",");
             Them(new Studen(str[0],Float.parseFloat(str[1]),str[2],str[3],str[4],str[5]));
        }
    }
    public float DTBMin(){
        float min=Float.MAX_VALUE;
        for (Studen d : ds) {
            if(d.getDTB()<min)
                min=d.getDTB();
        }
        return min;
    }
    public float DTBMax(){
        float max=Float.MIN_VALUE;
        for (Studen d : ds) {
            if(d.getDTB()>max)
                max=d.getDTB();
        }
        return max;
    }
    
}
