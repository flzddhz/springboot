package com.example.springboot.uitl;

import java.sql.*;

public class BaseDao {

    static final String USER = "root";
    static final String PASSWORD = "123456";

//    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";          //oracle
//    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";                  //mariadb
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";                   ////mysql
//    static final String DB_URL = "jdbc:oracle:thin:@10.1.100.46:1521:rptdb";      //oracle
    static final String DB_URL = "jdbc:mysql://111.229.178.45:3306/mysql";          //mysql
//    static final String DB_URL = "jdbc:mariadb://111.229.178.45:3306/mysql";      //mariadb

    public static Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            System.out.println("获取数据库链接成功！");
        }catch (Exception e){
            System.out.println("获取数据库链接失败！" + e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        PreparedStatement pt = null;
        ResultSet rs = null;
        try{
            conn = getConnection();
            String sql = "select * from test limit 2";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
//                System.out.println(rs.getString(3));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("执行完成");
        }
    }
}

