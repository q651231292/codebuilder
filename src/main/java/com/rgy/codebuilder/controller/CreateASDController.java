/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rgy.codebuilder.controller;

import com.rgy.codebuilder.tool.DerbyJdbc;
import com.rgy.codebuilder.App;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class CreateASDController implements Initializable {

    @FXML
    private TextField packageName;
    @FXML
    private TextField classAllName;
    @FXML
    private TextField diskPath;
    @FXML
    private ComboBox  tempList;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //查询模版
        List<Map<String, Object>> list = new DerbyJdbc().query("SELECT * FROM TEMP");
//        System.out.println(list);
        //把模版数据填充到tempList
        list.forEach((Map<String, Object> obj)->{
            String name = obj.get("NAME").toString();
            tempList.getItems().add(name);
        });

    }

    @FXML
    private void createASD(ActionEvent event) throws IOException, InterruptedException {
        App.replaceScene("common/processing.fxml");
        
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        App.replaceScene("codeBuilder.fxml");
    }

    @FXML
    public void addTempListTo(ActionEvent actionEvent) {
        System.out.println("进入模版管理器-准备");
        App.replaceScene("template/tempManager.fxml");
        System.out.println("进入模版管理器-完成");
    }

    @FXML
    private void selectTempList(ActionEvent event) {
        System.out.println("click");
    }



}
