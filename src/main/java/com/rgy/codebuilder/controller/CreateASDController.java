/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rgy.codebuilder.controller;

import com.rgy.codebuilder.tool.DerbyJdbc;
import com.rgy.codebuilder.App;
import com.rgy.codebuilder.model.Global;
import com.rgy.codebuilder.model.Templation;
import com.rgy.codebuilder.tool.FileTool;
import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    private ComboBox tempList;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Templation> data = FXCollections.observableArrayList();
        List<Map<String, Object>> list = new DerbyJdbc().query("select * from temp");
        list.forEach((Map<String, Object> map) -> {
            data.add(new Templation(map.get("ID").toString(), map.get("NAME").toString()));
        });
        tempList.setItems(data);
    }

    @FXML
    private boolean createASD(ActionEvent event) throws IOException, InterruptedException {
        boolean isSuccess = true;
        String packName = packageName.getText();
        String modelName = classAllName.getText();
        String modelShortName = getModelShortName(modelName);
        String modelShortNameObj = getModelShortNameObj(modelShortName);
        String outPath = diskPath.getText();
        String tempName = Global.tempName;
        String[] fileTypes = {"Action", "Service", "ServiceImpl", "Dao", "DaoImpl"};
        String[] tempKeys = {"ACTION", "SERVICE", "SERVICEIMPL", "DAO", "DAOIMPL"};
        System.out.println(packName);
        System.out.println(modelName);
        System.out.println(modelShortName);
        System.out.println(modelShortNameObj);
        System.out.println(outPath);
        DerbyJdbc dj = new DerbyJdbc();
        String sql = "select * from temp where name = '" + tempName + "'";
        List<Map<String, Object>> list = dj.query(sql);
        Map<String, Object> temp = list.get(0);
        for (int i = 0; i < fileTypes.length; i++) {
            isSuccess = writeASD(temp, packName, modelName, modelShortName, modelShortNameObj, outPath, fileTypes[i], tempKeys[i]);
        }
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("消息提示框");
        alert.setHeaderText(null);
        if (isSuccess) {

            alert.setContentText("构建成功!");

            alert.showAndWait();
            return true;
        } else {
            alert.setContentText("构建失败!");

            alert.showAndWait();
            return false;

        }

    }

    private boolean writeASD(Map<String, Object> temp, String packName, String modelName, String modelShortName, String modelShortNameObj, String outPath, String fileType, String tempKey) {
        String value = temp.get(tempKey).toString();
        value = value.replace("(packName)", packName);
        value = value.replace("(modelName)", modelName);
        value = value.replace("(modelShortName)", modelShortName);
        value = value.replace("(modelShortNameObj)", modelShortNameObj);
        String realPackName = getRealPackName(value);
        String packPath = realPackName.replace(".", "/") + "/";
        String realPath = outPath + packPath;
        String fileName = modelShortName + fileType + ".java";
        boolean isSuccess = FileTool.write(realPath, fileName, value);
        return isSuccess;
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        App.replaceScene("codeBuilder.fxml");
    }

    @FXML
    public void addTempListTo(ActionEvent actionEvent) {
        App.replaceScene("template/tempManager.fxml");
    }

    @FXML
    private void selectTempList(ActionEvent event) {
        ComboBox cb = (ComboBox) event.getSource();
        System.out.println(cb);
        Object cbvalue = cb.getValue();
        System.out.println(cbvalue);
        String tempName = cbvalue.toString();
        Global.tempName = tempName;

    }

    private String getModelShortName(String modelName) {
        int endPointIndex = modelName.lastIndexOf(".");
        modelName = modelName.substring(endPointIndex + 1);
        return modelName;
    }

    private String getModelShortNameObj(String modelShortName) {
        modelShortName = modelShortName.toLowerCase();
        return modelShortName;
    }

    private String getRealPackName(String value) {
        try {
            System.out.println();
            BufferedReader br = new BufferedReader(new CharArrayReader(value.toCharArray()));
            String line = br.readLine();
            while (line != null) {
                if (line.contains("package")) {
                    int begin = line.indexOf("package");
                    int end = line.indexOf("package") + "package".length();
                    line = line.subSequence(end, line.indexOf(";")).toString().trim();
                    return line;
                }
                line = br.readLine();
            }
            return value;
        } catch (IOException ex) {
            Logger.getLogger(CreateASDController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
