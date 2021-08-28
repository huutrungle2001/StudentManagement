/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.studentmangager.userLogin;

import com.mycompany.studentmangager.helper.DatabaseHelper;
import com.mycompany.studentmangager.model.NguoiDung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author tanki
 */
public class nguoiDungLogin {
    public NguoiDung checkLogin(String tenDangNhap, String matKhau)throws Exception{
    String sql = "select tendangnhap, matkhau, vaitro from nguoidung"
            + " where tendangnhap=? and matkhau = ?";
    try(
        Connection conn = DatabaseHelper.openConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ){
        pstmt.setString(1, tenDangNhap);
        pstmt.setString(2, matKhau);
        try(ResultSet rs = pstmt.executeQuery();){
            if (rs.next()){
                NguoiDung nd = new NguoiDung();
                nd.setTenDangNhap(tenDangNhap);
                nd.setVaiTro(rs.getString("vaitro"));
                return nd;
            }
        }
        
    }
    return null;
    }
}
