package com.imooc.dao;

import com.imooc.jdbc.Jdbc;
import com.imooc.model.ImoocGoddessEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: duanxu
 * @Date: 2019/5/7 22:48
 */
public class Excute {
    Jdbc jdbc = new Jdbc();
    Connection connection = jdbc.open();
    Statement statement;

    {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加
     * @param imoocGoddessEntity
     * @throws SQLException
     */
    public void addBeauty(ImoocGoddessEntity imoocGoddessEntity) throws SQLException {
        String sql = ""+"insert into imooc_goddess"+
                "(user_name,age,birthday,email,mobile,create_date)"+
                "values"+
                "(?,?,?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,imoocGoddessEntity.getUserName());
        preparedStatement.setInt(2, imoocGoddessEntity.getAge());
        preparedStatement.setDate(3, imoocGoddessEntity.getBirthday());
        preparedStatement.setString(4,imoocGoddessEntity.getEmail());
        preparedStatement.setString(5, imoocGoddessEntity.getMobile());
        preparedStatement.setDate(6, imoocGoddessEntity.getCreateDate());
        preparedStatement.execute();
    }

    public void add(){
        ImoocGoddessEntity imoocGoddessEntity = new ImoocGoddessEntity();
        Scanner in = new Scanner(System.in);
        System.out.println("输入姓名");
        imoocGoddessEntity.setUserName(in.next());
        System.out.println("输入年龄");
        imoocGoddessEntity.setAge(in.nextInt());
        System.out.println("输入生日");
        imoocGoddessEntity.setBirthday(Date.valueOf(in.next()));
        System.out.println("输入邮箱");
        imoocGoddessEntity.setEmail(in.next());
        System.out.println("输入电话");
        imoocGoddessEntity.setMobile(in.next());
        GetTime getTime = new GetTime();
        imoocGoddessEntity.setCreateDate(getTime.getTimeByDateWithFormat());
        String sql ="insert into imooc_goddess (user_name,age,birthday,email,mobile,create_date) values "+
                "("+imoocGoddessEntity.getUserName()+","+imoocGoddessEntity.getAge()+","+imoocGoddessEntity.getBirthday()+","+imoocGoddessEntity.getEmail()+","+imoocGoddessEntity.getMobile()+","+imoocGoddessEntity.getCreateDate()+")";
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delBeautyByName(String name){

    }
    public void updateBeauty(){

    }
    /**
    *查询数据库里的所有项
     */
    public void query(){
       List<ImoocGoddessEntity> imoocGoddessEntityList = new ArrayList<>();
       ImoocGoddessEntity imoocGoddessEntity =null;
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * from imooc_goddess");
            while (resultSet.next()) {

                imoocGoddessEntity = new ImoocGoddessEntity();
                imoocGoddessEntity.setId(resultSet.getInt("id"));
                imoocGoddessEntity.setUserName(resultSet.getString("user_name"));
                imoocGoddessEntity.setAge(resultSet.getInt("age"));
                imoocGoddessEntityList.add(imoocGoddessEntity);

            }
            for (ImoocGoddessEntity i:imoocGoddessEntityList){
                System.out.println(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
