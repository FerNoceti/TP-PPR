package com.ppr.db;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ConexionDB {

    Connection connection = null;
    String url = "jdbc:mysql://localhost:3306/escuela";
    String user = "root";
    String password = "root";



    public ResultSet runQuery(){

    }

    public ResultSet runQueryWithParams() {

    }
}
