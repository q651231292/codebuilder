package com.rgy.codebuilder.controller.template;

import com.rgy.codebuilder.App;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2017/7/2.
 */
public class AddTempDetailToController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void addTemp(ActionEvent actionEvent) {
        System.out.println("保存模板-准备");
        System.out.println("保存模板-完毕");
    }

    public void back(ActionEvent actionEvent) {
        App.replaceScene("template/addTempDaoTo.fxml");
    }
}
