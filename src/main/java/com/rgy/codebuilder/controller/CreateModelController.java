/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rgy.codebuilder.controller;

import com.rgy.codebuilder.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class CreateModelController implements Initializable {

    @FXML
    private TextField outFolder;
    @FXML
    private TextField classAllName;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void addAttr(ActionEvent event) {
    }

    @FXML
    private void delAttr(ActionEvent event) {
    }

    @FXML
    private void createModel(ActionEvent event) {
    }

    @FXML
    private void createDbTable(ActionEvent event) {
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        App.replaceScene("codeBuilder.fxml");
    }
    
}
