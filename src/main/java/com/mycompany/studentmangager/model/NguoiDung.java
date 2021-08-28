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
public class NguoiDung {
    private String tenDangNhap, matkhau, vaiTro;
    
    public NguoiDung(){
    }

    public NguoiDung(String tenDangNhap, String matkhau, String vaiTro) {
        this.tenDangNhap = tenDangNhap;
        this.matkhau = matkhau;
        this.vaiTro = vaiTro;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }
    
    
}
