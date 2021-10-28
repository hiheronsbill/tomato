package com.mk.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/9/24 17:36
 * @Version V1.0
 **/
public class TestJdbc {


    public static void main(String[] args) {


        Connection conn;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc://mysql://localhost:3306/security";
        String username = "root";
        String password = "12345678";

        try {
            // 加载驱动
            Class.forName(driver);
            // 获取连接
            conn = DriverManager.getConnection(url, username, password);
            // 创建statement对象，用于执行sql
            Statement statement = conn.createStatement();
            // 要执行的sql
            String sql = "select * from authority";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()){

            }



        } catch (Exception e){

        }


    }

}
