/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.studentmangager.helper;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author tanki
 */

public class DatabaseHelper {
    public static Connection openConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;database = Student manager;";
        String dbusername = "sa";
        String password = "tankinguyen123";
        Connection conn = DriverManager.getConnection(connectionUrl, dbusername, password);
        return conn;
    }
}
