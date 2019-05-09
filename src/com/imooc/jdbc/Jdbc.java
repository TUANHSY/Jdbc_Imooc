package com.imooc.jdbc;

import java.sql.*;

/**
 * @Author: duanxu
 * @Date: 2019/5/7 20:48
 */
public class Jdbc {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/imooc?serverTimezone=UTC";
    private static final String NAME = "root";
    private static final String PASSWOED = "4017";

    private static Connection connection = null;
    private static Statement statement = null;
    static {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,NAME,PASSWOED);
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  Connection open(){
        return connection;
    }
    public ResultSet excuteQuery(String sql){
        try {
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void close(){
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
