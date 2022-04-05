package com.example.caferouge;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;

public class DishDetailController {
    private DishDetail dishdetail;
    @FXML
    private ImageView dishimage;
    @FXML
    private TextArea dishdsc;
    @FXML
    private TextField amountTextField;
    @FXML
    private Button addButton;
    @FXML
    public void initialize() {
//        dishimage=new ImageView();
//        Image newImg = new Image(GlobalData.dishesURL.get(this.dishdetail.name));
        System.out.println("Image url: "+this.dishdetail.name);
//        dishimage.setImage(new Image(GlobalData.dishesURL.get(this.dishdetail.name)));
        dishimage.setImage(new Image("http://antaki.ca/bloom/img/windows_64x64.png"));
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
