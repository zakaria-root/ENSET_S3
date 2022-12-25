package com.example.dbconnection.DBI;


import java.sql.*;

public class DBInteraction {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/gestionCommande";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "user";
    private static Connection conn = null;

    public static boolean connect() {
        //Setting Oracle JDBC Driver
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your mysql JDBC Driver?");
            e.printStackTrace();
            return false;
        }

        try {
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console" + e);
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static Boolean update(String query) {
        Boolean result = false;
        if (conn != null) {
            try {
                PreparedStatement st=  conn.prepareStatement(query);
                st.execute();
                result = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static ResultSet select(String query) {
        ResultSet rs = null;
        if (conn != null) {
            try {
                rs=  conn.prepareStatement(query).executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }

    public static void disconnect() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}