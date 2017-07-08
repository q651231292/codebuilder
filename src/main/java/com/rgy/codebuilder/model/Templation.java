/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rgy.codebuilder.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Templation {

    private StringProperty id;
    private StringProperty name;

    public Templation(String id, String name) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
    }

    public void setId(String id) {
        this.id = new SimpleStringProperty(id);
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public String getId() {
        return id.getValue();
    }

    public String getName() {
        return name.getValue();
    }

    @Override
    public String toString() {
        return name.getValue();
    }

}
