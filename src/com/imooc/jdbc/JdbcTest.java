package com.imooc.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: duanxu
 * @Date: 2019/5/7 21:28
 * 测试jdbc数据库连接
 * 测试结果：成功
 */
public class JdbcTest {
    public static void main(String[] args) {
        Jdbc jdbc = new Jdbc();
        ResultSet resultSet = jdbc.excuteQuery("select * from imooc_goddess");
        try {
            while (resultSet.next()){
                System.out.println("id: "+resultSet.getString("id")+"\tname:"+resultSet.getString("user_name"));
              }
        }catch (SQLException e){
            e.printStackTrace();
        }
        jdbc.close();
    }
}
