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
        insertTest();
        queryTest();
        }

    private static void createTable() {
        DerbyJdbc jdbc = new DerbyJdbc();
        jdbc.add("create table temp(\n"
                + "    id varchar(32) primary key, \n"
                + "    name varchar(255),\n"
                + "    action varchar(255),\n"
                + "    service varchar(255),\n"
                + "    service_impl varchar(255),\n"
                + "    dao varchar(255),\n"
                + "    dao_impl varchar(255)\n"
                + ")");
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
