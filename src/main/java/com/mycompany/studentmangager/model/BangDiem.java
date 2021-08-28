/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.studentmangager.model;

/**
 *
 * @author tanki
 */
public class BangDiem {

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getMaSinhVien() {
        return MaSinhVien;
    }

    public void setMaSinhVien(String MaSinhVien) {
        this.MaSinhVien = MaSinhVien;
    }

    public float getTiengNhat() {
        return TiengNhat;
    }

    public void setTiengNhat(float TiengNhat) {
        this.TiengNhat = TiengNhat;
    }

    public float getOOP() {
        return OOP;
    }

    public void setOOP(float OOP) {
        this.OOP = OOP;
    }

    public float getGDTC() {
        return GDTC;
    }

    public void setGDTC(float GDTC) {
        this.GDTC = GDTC;
    }

    private int ma;
    private String MaSinhVien;
    private float TiengNhat, OOP, GDTC;
    
    public BangDiem(){
    }
    
    public BangDiem(int ma, String MaSinhVien, float TiengNhat, float OOP, float GDTC) {
        this.ma = ma;
        this.MaSinhVien = MaSinhVien;
        this.TiengNhat = TiengNhat;
        this.OOP = OOP;
        this.GDTC = GDTC;
    }
    
    
}
