/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikasimanajemen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
class DBConnection {
  private static final String URL = "jdbc:postgresql://localhost:5432/DB_MO9_TUGAS2_09010624017";
    private static final String USER = "postgres";
    private static final String PASSWORD = "BISMILLAH";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
//        
    }
  
}
