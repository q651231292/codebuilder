/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rgy.codebuilder;

import com.rgy.codebuilder.tool.DerbyJdbc;
import com.rgy.codebuilder.tool.InitTableJdbc;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Administrator
 */
public class App extends Application {

    public static Stage stage;

    @Override
    public void start(Stage primarStage) throws Exception {

        App.stage = primarStage;
        App.replaceScene("codeBuilder.fxml");
        System.out.println("构建项目表结构-准备");
        initTable();
        System.out.println("构建项目表结构-完毕");

    }

    public static boolean replaceScene(String sceneFxml) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(App.class.getResource("/fxml/"+sceneFxml))));
            stage.getIcons().add(new Image("/img/chuizi.png"));
            stage.setTitle("codebuilder");
            stage.show();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void initTable() {
        boolean isNotExists = false;
        //判断,是否存在模版表
        DerbyJdbc jdbc = new DerbyJdbc();
        isNotExists = jdbc.tableIsNotExists("TEMP");
//        System.out.println(isNotExists);
        //如果不存在,执行构造语句
        if (isNotExists) {
//            System.out.println("数据库表结构-未存在");
//            System.out.println("构造表结构-启动");
            try {
                InitTableJdbc.InitTableJdbc();
            } catch (Exception e) {
//                System.out.println("构造表结构-失败");
            }
//            System.out.println("构造表结构-完成");
        } //如果存在则什么都不执行
        else {
//            System.out.println("数据库表结构-已存在");
        }

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
//        DerbyJdbc jdbc = new DerbyJdbc();
//        jdbc.add("insert into temp values('001','模版1','action模版','service模版','serviceImpl模版','dao模版','daoImpl模版')");
//        jdbc.add("insert into temp values('002','模版2','action模版','service模版','serviceImpl模版','dao模版','daoImpl模版')");
//        jdbc.add("insert into temp values('003','模版3','action模版','service模版','serviceImpl模版','dao模版','daoImpl模版')");
//        jdbc.add("insert into temp values('004','模版4','action模版','service模版','serviceImpl模版','dao模版','daoImpl模版')");
    }

    private static void queryTest() {
        DerbyJdbc jdbc = new DerbyJdbc();
        List query = jdbc.query("select * from temp ");
        System.out.println(query);
    }

    private boolean valiTables() {
        boolean isNotExists = new DerbyJdbc().tableIsNotExists("TEMP");
        System.out.println(isNotExists);
        return false;
    }

}
