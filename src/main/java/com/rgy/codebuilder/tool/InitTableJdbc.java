/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rgy.codebuilder.tool;

import java.util.List;

/**
 *
 * @author Administrator
 */
public class InitTableJdbc {
    
//        public static void main(String[] args) {
//        createTable();
//        insertTest();
//        queryTest();
//    }
        public static void InitTableJdbc(){
            createTable();
//        insertTest();
//        queryTest();
        }

    private static void createTable() {
        DerbyJdbc dj = new DerbyJdbc();
        String sql = "";
        sql += "create table temp("
                + "    id varchar(36) primary key,"
                + "    name varchar(32672),"
                + "    action varchar(32672),"
                + "    service varchar(32672),"
                + "    serviceImpl varchar(32672),"
                + "    dao varchar(32672),"
                + "    daoImpl varchar(32672)"
                + ")";
        dj.dml(sql);
    }

    private static void insertTest() {
        DerbyJdbc jdbc = new DerbyJdbc();
        jdbc.add("insert into temp values('001','模版1','action模版','service模版','serviceImpl模版','dao模版','daoImpl模版')");
        jdbc.add("insert into temp values('002','模版2','action模版','service模版','serviceImpl模版','dao模版','daoImpl模版')");
        jdbc.add("insert into temp values('003','模版3','action模版','service模版','serviceImpl模版','dao模版','daoImpl模版')");
        jdbc.add("insert into temp values('004','模版4','action模版','service模版','serviceImpl模版','dao模版','daoImpl模版')");
    }

    private static void queryTest() {
        DerbyJdbc jdbc = new DerbyJdbc();
        List query = jdbc.query("select * from temp ");
        System.out.println(query);
    }
}
