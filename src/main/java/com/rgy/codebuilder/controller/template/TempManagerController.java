package com.rgy.codebuilder.controller.template;/**
 * created by Administrator on 2017/7/2.
 */

import com.rgy.codebuilder.App;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class TempManagerController implements Initializable {


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void addTempTo(ActionEvent actionEvent) {
        App.replaceScene("template/addTempActionTo.fxml");
    }

    public void delTemp(ActionEvent actionEvent) {
    }

    public void modTempTo(ActionEvent actionEvent) {
    }

    public void back(ActionEvent actionEvent) {
        App.replaceScene("createASD.fxml");
    }
}
