package com.example.caferouge;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
<<<<<<< Updated upstream
=======
    private class NoticeListItemChangeListener implements ChangeListener<Object> {
        @Override
        public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
            System.out.println(newValue);
        }
    }

    private final Image IMAGE_RUBY = new Image("https://upload.wikimedia.org/wikipedia/commons/f/f1/Ruby_logo_64x64.png");
    private final Image IMAGE_APPLE = new Image("http://findicons.com/files/icons/832/social_and_web/64/apple.png");
    private final Image IMAGE_VISTA = new Image("http://antaki.ca/bloom/img/windows_64x64.png");
    private final Image IMAGE_TWITTER = new Image("http://files.softicons.com/download/social-media-icons/fresh-social-media-icons-by-creative-nerds/png/64x64/twitter-bird.png");
    private Image[] listOfImages = {IMAGE_RUBY, IMAGE_APPLE, IMAGE_VISTA, IMAGE_TWITTER};
    private Stage stage;
>>>>>>> Stashed changes
    @FXML
    private Label welcomeText;

    @FXML

    //TODO login page
    //protected void loginButtonClick() throws IOException{
    //        LoginPage lp = new LoginPage();
    //        lp.showWindow();

    //    }
    protected void onHelloButtonClick() throws IOException{
        welcomeText.setText("Welcome to JavaFX Application!");
        LoginPage lp = new LoginPage();
        lp.showWindow();
    }
}