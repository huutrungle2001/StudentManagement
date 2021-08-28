/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.studentmangager.userLogin;

import com.mycompany.studentmangager.helper.DatabaseHelper;
import com.mycompany.studentmangager.model.NguoiDung;
import com.mycompany.studentmangager.model.SinhVien;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author tanki
 */
public class SinhVienLogin {
    public boolean insert(SinhVien sv) throws Exception{
    String sql = "INSERT INTO [dbo].[SinhVien]([MaSinhVien],[HoTen],[Email],[SoDT],[GioiTinh],[DiaChi],[Hinh])"
            + "values(?,?,?,?,?,?,?)";
    try(
        Connection conn = DatabaseHelper.openConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ){
        pstmt.setString(1, sv.getMaSinhVien());
        pstmt.setString(2, sv.getHoTen());
        pstmt.setString(3, sv.getEmail());
        pstmt.setString(4, sv.getSoDT());
        pstmt.setInt(5, sv.getGioiTinh());
        pstmt.setString(6,sv.getDiaChi());
//        File input = null;
//        BufferedImage read = ImageIO.read(input);
        if (sv.getHinh()!= null){
            Blob hinh = new SerialBlob(sv.getHinh());
            pstmt.setBlob(7, hinh);
        }else{
            Blob hinh = null;
            pstmt.setBlob(7, hinh);
        }
        // trả về số dòng bị tác động khi thực thi delete, insert, update
        return pstmt.executeUpdate()>0;
        }
    }
    
    public boolean update(SinhVien sv) throws Exception{
    String sql = "UPDATE [dbo].[SinhVien]"
            + "SET [MaSinhVien] = ?,[HoTen] =?,[Email] = ?,[SoDT] = ?,[GioiTinh] = ?,[DiaChi] = ?,[Hinh] = ? "
            + "where MaSinhVien = ?";
    try(
        Connection conn = DatabaseHelper.openConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ){
        pstmt.setString(1, sv.getMaSinhVien());
        pstmt.setString(2, sv.getHoTen());
        pstmt.setString(3, sv.getEmail());
        pstmt.setString(4, sv.getSoDT());
        pstmt.setInt(5, sv.getGioiTinh());
        pstmt.setString(6,sv.getDiaChi());
        pstmt.setString(8,sv.getMaSinhVien());
//        File input = null;
//        BufferedImage read = ImageIO.read(input);
        if (sv.getHinh()!= null){
            Blob hinh = new SerialBlob(sv.getHinh());
            pstmt.setBlob(7, hinh);
        }else{
            Blob hinh = null;
            pstmt.setBlob(7, hinh);
        }
        return pstmt.executeUpdate()>0;
        }
    }
    
    public boolean delete(String maSinhVien) throws Exception{
    String sql = "delete from sinhvien "
            + "where MaSinhVien = ?";
    try(
        Connection conn = DatabaseHelper.openConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ){
        pstmt.setString(1, maSinhVien);
        return pstmt.executeUpdate()>0;
        }
    }
    
    public SinhVien findById(String MaSinhVien) throws Exception{
    String sql = "select * from sinhvien where MaSinhVien = ?";
    try(
        Connection conn = DatabaseHelper.openConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ){
        pstmt.setString(1, MaSinhVien);
        try(ResultSet rs = pstmt.executeQuery()){
            if (rs.next()){
                SinhVien sv = new SinhVien();
                sv.setMaSinhVien(rs.getString("masinhvien"));
                sv.setHoTen(rs.getString("hoten"));
                sv.setEmail(rs.getString("email"));
                sv.setSoDT(rs.getString("soDT"));
                sv.setDiaChi(rs.getString("diachi"));
                sv.setGioiTinh(rs.getInt("gioitinh"));
                Blob blob = rs.getBlob("hinh");
                if (blob != null)
                    sv.setHinh(blob.getBytes(1,(int)blob.length()));
                return sv;
            }
        }
        return null;
        }
    }
    
    public List < SinhVien > findAll() throws Exception{
    String sql = "select * from sinhvien";
    try(
        Connection conn = DatabaseHelper.openConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ){
        try(ResultSet rs = pstmt.executeQuery()){
            List<SinhVien> list = new ArrayList<>();
            while (rs.next()){
                SinhVien sv = new SinhVien();
                sv.setMaSinhVien(rs.getString("masinhvien"));
                sv.setHoTen(rs.getString("hoten"));
                sv.setEmail(rs.getString("email"));
                sv.setSoDT(rs.getString("soDT"));
                sv.setDiaChi(rs.getString("diachi"));
                sv.setGioiTinh(rs.getInt("gioitinh"));
                Blob blob = rs.getBlob("hinh");
                if (blob != null)
                    sv.setHinh(blob.getBytes(1,(int)blob.length()));
                list.add(sv);
         
            }
             return list;
        }
       
        }
    }
    
}
