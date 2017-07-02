package com.rgy.codebuilder.controller.template;

import com.rgy.codebuilder.App;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2017/7/2.
 */
public class AddTempActionToController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void toService(ActionEvent actionEvent) {
        System.out.println("跳转到service模板页-准备");
        App.replaceScene("template/addTempServiceTo.fxml");
        System.out.println("跳转到service模板页-完毕");
    }

    public void addTemp(ActionEvent actionEvent) {
    }

    public void toTempDetail(ActionEvent actionEvent) {
    }

    public void back(ActionEvent actionEvent) {
        App.replaceScene("template/tempManager.fxml");
    }
}
