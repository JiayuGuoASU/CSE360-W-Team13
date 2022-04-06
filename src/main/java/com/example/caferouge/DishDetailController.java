package com.example.caferouge;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.io.File;

public class DishDetailController {
    private DishDetail dishdetail;
    private Dish dish;
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
//        System.out.println("Dish Detail Controller Image url: "+this.dishdetail.name);
//        dishimage.setImage(new Image(GlobalData.dishesURL.get(this.dishdetail.name)));
//        dishimage.setImage(new Image("http://antaki.ca/bloom/img/windows_64x64.png"));
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
        dishimage.setImage(new Image(GlobalData.dishesURL.get(this.dishdetail.name)));
        for (int i=0;i<GlobalData.dishes.size();i++){
            if (GlobalData.dishes.get(i).dishName.equals(this.dishdetail.name)){
                dishdsc.setText(GlobalData.dishes.get(i).dishdes);
                dish=GlobalData.dishes.get(i);
                break;
            }
        }
    }
    @FXML
    public void onAddDish(){
        try {
            Integer intValue = Integer.parseInt(amountTextField.getText());
            Order currentOrder = GlobalData.getCurrentOrder();
            currentOrder.dishes.add(this.dish);
            currentOrder.quantityOfDish.add(intValue);
            Dialog<String> dialog = new Dialog<String>();
            dialog.setTitle("Dialog");
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("Add Dish Successfully!");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
            this.dishdetail.parentStage.show();
            this.dishdetail.stage.close();
        } catch (NumberFormatException e) {
            Dialog<String> dialog = new Dialog<String>();
            dialog.setTitle("Dialog");
            ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("Input String cannot be parsed to Integer");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
            System.out.println("Input String cannot be parsed to Integer.");
        }
    }

}
