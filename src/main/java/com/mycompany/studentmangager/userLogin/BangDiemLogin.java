/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.studentmangager.userLogin;

import com.mycompany.studentmangager.helper.DatabaseHelper;
import com.mycompany.studentmangager.model.BangDiem;
import com.mycompany.studentmangager.model.SinhVien;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author tanki
 */
public class BangDiemLogin {
    public boolean insert(BangDiem bd) throws Exception{
    String sql = "INSERT INTO [dbo].[BangDiem]([MaSinhVien],[TiengNhat],[OOP],[GDTC])"
            + "values(?,?,?,?)";
    try(
        Connection conn = DatabaseHelper.openConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ){
       
            pstmt.setString(1, bd.getMaSinhVien());
            pstmt.setFloat(2, bd.getTiengNhat());
            pstmt.setFloat(3, bd.getOOP());
            pstmt.setFloat(4, bd.getGDTC());
        
            // trả về số dòng bị tác động khi thực thi delete, insert, update
            return pstmt.executeUpdate()>0;
        }
    }
    
    public boolean update(BangDiem bd) throws Exception{
    String sql = "UPDATE [dbo].[BangDiem]" +
    " SET [TiengNhat] = ? ,[OOP] = ? ,[GDTC] = ? " +
    " WHERE [MaSinhVien] = ?";
    try(
        Connection conn = DatabaseHelper.openConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ){
       
            pstmt.setString(4, bd.getMaSinhVien());
            pstmt.setFloat(1, bd.getTiengNhat());
            pstmt.setFloat(2, bd.getOOP());
            pstmt.setFloat(3, bd.getGDTC());
        
            // trả về số dòng bị tác động khi thực thi delete, insert, update
            return pstmt.executeUpdate()>0;
        }
    }
    
    public boolean deleteByMaSinhVien(String maSinhVien) throws Exception{
    String sql = "delete from bangdiem " +
    " WHERE [MaSinhVien] = ?";
    try(
        Connection conn = DatabaseHelper.openConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ){
       
            pstmt.setString(1, maSinhVien);
        
            // trả về số dòng bị tác động khi thực thi delete, insert, update
            return pstmt.executeUpdate()>0;
        }
    }
    
    public BangDiem findByMaSinhVien(String maSinhVien) throws Exception{
    String sql = "select * from bangdiem " +
    " WHERE MaSinhVien = ?";
    try(
        Connection conn = DatabaseHelper.openConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ){
       
            pstmt.setString(1, maSinhVien);
            try (ResultSet rs = pstmt.executeQuery();){
                if (rs.next()){
                    BangDiem bd = new BangDiem();
                    bd.setMa(rs.getInt("Ma"));
                    bd.setMaSinhVien(rs.getString("maSinhVien"));
                    bd.setTiengNhat(rs.getFloat("TiengNhat"));
                    bd.setOOP(rs.getFloat("OOP"));
                    bd.setGDTC(rs.getFloat("GDTC"));
                    
                    return bd;
                }
                
            }
            return null; 
        }
    }
    
    public List<BangDiem> findAll() throws Exception{
    String sql = "select * from bangdiem ";
    try(
        Connection conn = DatabaseHelper.openConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ){
       
            try (ResultSet rs = pstmt.executeQuery();){
                List<BangDiem> list = new ArrayList<>();
                while (rs.next()){
                    BangDiem bd = new BangDiem();
                    bd.setMa(rs.getInt("Ma"));
                    bd.setMaSinhVien(rs.getString("maSinhVien"));
                    bd.setTiengNhat(rs.getFloat("TiengNhat"));
                    bd.setOOP(rs.getFloat("OOP"));
                    bd.setGDTC(rs.getFloat("GDTC"));
                    
                    list.add(bd);
                }
                return list;
            }
        }
    }
}
