package com.example.caferouge;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
public class DishDetailController {
    @FXML
    public void initialize() {

    }
    @FXML
    public void exitApplication(ActionEvent event) {
        Platform.exit();
    }
}
