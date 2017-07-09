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
public class AddTempActionToController implements Initializable {

    @FXML
    private TextArea actionTemp;
    
    boolean isAdd = true ; 
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         if(Temp.id != null){
              isAdd = false;
              actionTemp.setText(Temp.action);
         }
         
    }

    @FXML
    public void toService(ActionEvent actionEvent) {
        Temp.action = actionTemp.getText();
        App.replaceScene("template/addTempServiceTo.fxml");
    }

    public void addTemp(ActionEvent actionEvent) {
    }

    public void toTempDetail(ActionEvent actionEvent) {
    }

    @FXML
    public void back(ActionEvent actionEvent) {
        App.replaceScene("template/tempManager.fxml");
    }
}
