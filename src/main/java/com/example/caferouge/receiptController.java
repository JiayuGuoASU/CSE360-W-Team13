package com.example.caferouge;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class receiptController {
    private Stage stage;
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    @FXML
    public void onBackMainPage(){
        this.stage.close();
        GlobalData.mainpage.mystage.show();
    }
}
