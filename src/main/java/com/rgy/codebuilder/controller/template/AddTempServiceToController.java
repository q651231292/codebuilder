package com.rgy.codebuilder.controller.template;

import com.rgy.codebuilder.App;
import com.rgy.codebuilder.model.Temp;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * Created by Administrator on 2017/7/2.
 */
public class AddTempServiceToController implements Initializable {

    @FXML
    private TextArea serviceTemp;
    @FXML
    private TextArea serviceImplTemp;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         if(Temp.id != null){
             serviceTemp.setText(Temp.service);
         }
         if(Temp.id != null){
             serviceImplTemp.setText(Temp.serviceImpl);
         }
    }

    @FXML
    public void toDao(ActionEvent actionEvent) {
        Temp.service = serviceTemp.getText();
       Temp.serviceImpl  =  serviceImplTemp.getText();
        App.replaceScene("template/addTempDaoTo.fxml");
    }

    @FXML
    public void back(ActionEvent actionEvent) {
        App.replaceScene("template/addTempActionTo.fxml");
    }
}
