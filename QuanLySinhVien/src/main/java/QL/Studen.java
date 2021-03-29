/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QL;

/**
 *
 * @author ADMIN
 */
public class Studen extends Person{
    private  String maSV;
    private float DTB;
    
    public Studen() {
    }

    public Studen(String maSV, float DTB,String t,String gt,String ns,String dt) {
        this.maSV = maSV;
        this.DTB = DTB;
        Ten=t;
        GioiTinh=gt;
        NS=ns;
        DiaChi=dt;
    }
    
    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public float getDTB() {
        return DTB;
    }

    public void setDTB(float DTB) {
        this.DTB = DTB;
    }

    @Override
    public String toString() {
        return maSV+"\t"+DTB+"\t"+Ten+"\t\t"+GioiTinh+"\t\t"+NS+"\t"+DiaChi;
    }

      
}
