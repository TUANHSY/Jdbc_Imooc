package com.imooc.action;

import com.imooc.dao.Excute;
import com.imooc.model.ImoocGoddessEntity;

import java.sql.SQLException;

/**
 * @Author: duanxu
 * @Date: 2019/5/8 9:31
 */
public class Test {
    public static void main(String[] args) {
        Excute excute = new Excute();
        excute.query();
        try {
            excute.addBeauty(new ImoocGoddessEntity());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        excute.query();
    }

}
