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
public class AddTempDaoToController implements Initializable {

    @FXML
    private TextArea daoTemp;
    @FXML
    private TextArea daoImplTemp;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         if(Temp.id != null){
             daoTemp.setText(Temp.dao);
         }
         if(Temp.id != null){
             daoImplTemp.setText(Temp.daoImpl);
         }
    }

    @FXML
    public void toTempDetail(ActionEvent actionEvent) {
        Temp.dao = daoTemp.getText();
        Temp.daoImpl = daoImplTemp.getText();
        App.replaceScene("template/addTempDetailTo.fxml");
    }

    @FXML
    public void back(ActionEvent actionEvent) {
        App.replaceScene("template/addTempServiceTo.fxml");
    }
}
