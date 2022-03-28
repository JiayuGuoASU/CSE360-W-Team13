package com.example.caferouge;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;

public class HelloController {
    private class NoticeListItemChangeListener implements ChangeListener<Object> {
        @Override
        public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
            System.out.println(newValue);
        }
    }
    private final Image IMAGE_RUBY  = new Image("https://upload.wikimedia.org/wikipedia/commons/f/f1/Ruby_logo_64x64.png");
    private final Image IMAGE_APPLE  = new Image("http://findicons.com/files/icons/832/social_and_web/64/apple.png");
    private final Image IMAGE_VISTA  = new Image("http://antaki.ca/bloom/img/windows_64x64.png");
    private final Image IMAGE_TWITTER = new Image("http://files.softicons.com/download/social-media-icons/fresh-social-media-icons-by-creative-nerds/png/64x64/twitter-bird.png");
    private Image[] listOfImages = {IMAGE_RUBY, IMAGE_APPLE, IMAGE_VISTA, IMAGE_TWITTER};
    @FXML
    private Label welcomeText;
    @FXML
    private ListView<String> MENU = new ListView<String>();
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    public void initialize() {
        ObservableList<String> items = FXCollections.observableArrayList (
                "RUBY", "APPLE", "VISTA", "TWITTER");
        MENU.setItems(items);
        MENU.setCellFactory(param -> new ListCell<String>() {
            private ImageView imageView = new ImageView();
            @Override
            public void updateItem(String name, boolean empty) {
                super.updateItem(name, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    if(name.equals("RUBY"))
                        imageView.setImage(listOfImages[0]);
                    else if(name.equals("APPLE"))
                        imageView.setImage(listOfImages[1]);
                    else if(name.equals("VISTA"))
                        imageView.setImage(listOfImages[2]);
                    else if(name.equals("TWITTER"))
                        imageView.setImage(listOfImages[3]);
                    setText(name);
                    setGraphic(imageView);
                    setOnMouseClicked(mouseClickedEvent -> {
                        if (mouseClickedEvent.getButton().equals(MouseButton.PRIMARY) && mouseClickedEvent.getClickCount() == 2) {
                            System.out.println(name);
                        }
                    });
                }
            }
        });
//        MENU.getSelectionModel().selectedItemProperty().addListener(new NoticeListItemChangeListener());
    }

}
