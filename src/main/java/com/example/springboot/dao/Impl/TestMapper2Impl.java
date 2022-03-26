package com.example.springboot.dao.Impl;

import com.example.springboot.dao.TestMapper2;
import com.example.springboot.entity.Test;
import com.example.springboot.uitl.BaseDao;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Component          //只能用在类的上面
public class TestMapper2Impl implements TestMapper2 {
    @Override
    public Test login(String username, String password) {
        Test t1 = null;
        Connection conn = null;
        PreparedStatement ps = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = BaseDao.getConnection();
            String sql = "select * from test where loginname = '" + username + "' and pwd = '" + password + "'";
            st = conn.createStatement();       //PreparedStatement对象带人参数可以防止sql注入
            /**
             * 比较推荐一种写法   把该用户的密码查出来，然后再Controller层与密码进行比较
             */
            rs = st.executeQuery(sql);
            while (rs.next()){
                t1 = new Test();
                t1.setId(rs.getInt("id"));
                t1.setName(rs.getString("name"));
                t1.setLoginname(rs.getString("loginname"));
                t1.setPwd(rs.getString("pwd"));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return t1;
    }
}
