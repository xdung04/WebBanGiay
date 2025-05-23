package com.example.bangiay.Dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBContext {

    public Connection connection;

    public DBContext() {
        try {          
            String username = "sa";
            String password = "xuandung";
            String url = "jdbc:sqlserver://localhost\\XDUNG;databaseName=sqlbangiay;encrypt=false";
            
            //String url = "jdbc:sqlserver:localhost:1433;databaseName=sqlbangiay";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
