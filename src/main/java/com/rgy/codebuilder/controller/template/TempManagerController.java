package com.rgy.codebuilder.controller.template;

import com.rgy.codebuilder.App;
import com.rgy.codebuilder.model.Temp;
import com.rgy.codebuilder.tool.DerbyJdbc;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TempManagerController implements Initializable {

    @FXML
    private TableView<Templation> tempList;
    @FXML
    private TableColumn<?, ?> tempName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Templation> data = FXCollections.observableArrayList();
        List<Map<String, Object>> list = new DerbyJdbc().query("select * from temp");
        list.forEach((Map<String, Object> map) -> {
            data.add(new Templation(map.get("ID").toString(), map.get("NAME").toString()));
        });
        tempName.setText("模板名");
        tempName.setCellValueFactory(new PropertyValueFactory("name"));

        tempList.setItems(data);

    }

    @FXML
    public void addTempTo(ActionEvent actionEvent) {
        App.replaceScene("template/addTempActionTo.fxml");
    }

    @FXML
    public void delTemp(ActionEvent actionEvent) {
        System.out.println("删除模版-准备");

        Templation selectedItem = tempList.getSelectionModel().getSelectedItem();
        System.out.println(selectedItem);
        String tempId = selectedItem.getId();
        int isSuccess = new DerbyJdbc().del("delete from temp where id = '" + tempId + "'");
        if (isSuccess == 1) {
            System.out.println("删除模版-完成");
            System.out.println("进入模版管理器-准备");
            App.replaceScene("template/tempManager.fxml");
            System.out.println("进入模版管理器-完成");
        } else {
            System.out.println("删除模版-失败");

        }
    }

    @FXML
    public void modTempTo(ActionEvent actionEvent) {
        Templation t = tempList.getSelectionModel().getSelectedItem();
        String tempId = t.getId();
        DerbyJdbc jdbc = new DerbyJdbc();
        List<Map<String, Object>> list = jdbc.query("select  * from temp where id = '" + tempId + "' ");
        Map<String, Object> map = list.get(0);
        Temp.id = map.get("ID").toString();
        Temp.name = map.get("NAME").toString();
        Temp.action = map.get("ACTION").toString();
        Temp.service = map.get("SERVICE").toString();
        Temp.serviceImpl = map.get("SERVICEIMPL").toString();
        Temp.dao = map.get("DAO").toString();
        Temp.daoImpl = map.get("DAOIMPL").toString();
        
        App.replaceScene("template/addTempActionTo.fxml");
    }

    @FXML
    public void back(ActionEvent actionEvent) {
        App.replaceScene("createASD.fxml");
    }

    public static class Templation {

        private StringProperty id;
        private StringProperty name;

        private Templation(String id, String name) {
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
            return "Templation{" + "id=" + id + ", name=" + name + '}';
        }

    }
}
