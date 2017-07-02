package com.rgy.codebuilder.controller.template;

import com.rgy.codebuilder.App;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2017/7/2.
 */
public class AddTempServiceToController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void toDao(ActionEvent actionEvent) {
        App.replaceScene("template/addTempDaoTo.fxml");
    }

    public void back(ActionEvent actionEvent) {
        App.replaceScene("template/addTempActionTo.fxml");
    }
}
