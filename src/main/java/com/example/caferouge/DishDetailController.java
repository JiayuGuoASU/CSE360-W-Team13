package com.example.caferouge;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class DishDetailController {
    private DishDetail dishdetail;
    @FXML
    public void initialize() {

    }
    @FXML
    public void exitApplication(ActionEvent event) {
        Platform.exit();
    }
    @FXML
    public void BUTTONExit(){
        this.dishdetail.parentStage.show();
        this.dishdetail.stage.close();
    }
    public void setStage(DishDetail dishdetail) {
        this.dishdetail = dishdetail;
    }
}
