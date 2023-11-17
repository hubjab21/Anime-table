package com.example.jfx;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class HelloController {
    private final DataService dataService;

    public HelloController(DataService dataService) {
        this.dataService = dataService;
    }

    public void show(Stage stage) {
        TableView<DataObject> tableView = new TableView<>();
        TableColumn<DataObject, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("value1"));

        TableColumn<DataObject, String> studioColumn = new TableColumn<>("Studio");
        studioColumn.setCellValueFactory(new PropertyValueFactory<>("value2"));

        TableColumn<DataObject, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("value3"));

        TableColumn<DataObject, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("value4"));

        TableColumn<DataObject, String> episodeColumn = new TableColumn<>("Episode");
        episodeColumn.setCellValueFactory(new PropertyValueFactory<>("value5"));

        TableColumn<DataObject, String> timeColumn = new TableColumn<>("Time");
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("value6"));

        TableColumn<DataObject, String> whereColumn = new TableColumn<>("Forma");
        whereColumn.setCellValueFactory(new PropertyValueFactory<>("value7"));

        TableColumn<DataObject, String> infoColumn = new TableColumn<>("Info");
        infoColumn.setCellValueFactory(new PropertyValueFactory<>("value8"));

        tableView.getColumns().addAll(titleColumn, studioColumn, typeColumn, dateColumn, episodeColumn, timeColumn, whereColumn, infoColumn);

        ObservableList<DataObject> data;
        try {
            data = dataService.fetchData();
            tableView.setItems(data);
        } catch (Exception e) {
            showErrorMessage("Error", e.getMessage());
            return;
        }

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        tableView.setPrefWidth(screenBounds.getWidth());
        tableView.setPrefHeight(screenBounds.getHeight());

        TextField searchField = new TextField();
        searchField.setPromptText("Search...");
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            tableView.setItems(dataService.searchData(newValue));
        });

        VBox vbox = new VBox(searchField, tableView);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();
    }

    private void showErrorMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}