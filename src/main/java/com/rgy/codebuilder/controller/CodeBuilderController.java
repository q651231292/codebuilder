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

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class CodeBuilderController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void createModel(ActionEvent event) throws IOException {
        App.replaceScene("createModel.fxml");
    }

    @FXML
    private void createASD(ActionEvent event) throws IOException {
            App.replaceScene("createASD.fxml");
    }

    @FXML
    private void createJsp(ActionEvent event) throws IOException {
        App.replaceScene("createJsp.fxml");
    }

    
}
