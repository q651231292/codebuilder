package com.rgy.codebuilder.controller.template;

import com.rgy.codebuilder.App;
import com.rgy.codebuilder.model.Temp;
import com.rgy.codebuilder.tool.DerbyJdbc;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Created by Administrator on 2017/7/2.
 */
public class AddTempDetailToController implements Initializable {

    @FXML
    private TextField tempName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (Temp.id != null) {
            tempName.setText(Temp.name);
        }
    }

    @FXML
    public void addTemp(ActionEvent actionEvent) {
        if (Temp.id != null) {
            Temp.name = tempName.getText();
            DerbyJdbc dj = new DerbyJdbc();
            String sql = "update temp set name = '" + Temp.name + "',action='" + Temp.action + "',service='" + Temp.service + "',serviceImpl = '" + Temp.serviceImpl + "',dao='" + Temp.dao + "',daoImpl='" + Temp.daoImpl + "' where id = '" + Temp.id + "'";
            int flg = dj.dml(sql);
            if (true) {
                Temp.clear();
                App.replaceScene("template/tempManager.fxml");
            } 
        } else {
            insertTemp();
        }

    }

    private void insertTemp() {
        DerbyJdbc dj = new DerbyJdbc();
        String sql = "";
        String id = UUID.randomUUID().toString();
        sql += "insert into temp values('" + id + "','" + tempName.getText() + "','"+Temp.action+"','"+Temp.service+"','"+Temp.serviceImpl+"','"+Temp.dao+"','"+Temp.daoImpl+"')";
        int flg = dj.dml(sql);
        if (true) {
            Temp.clear();
            App.replaceScene("template/tempManager.fxml");
        } else {
        }
    }

    @FXML
    public void back(ActionEvent actionEvent) {
        App.replaceScene("template/addTempDaoTo.fxml");
    }
}
