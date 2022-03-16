module com.example.caferouge {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.caferouge to javafx.fxml;
    exports com.example.caferouge;
}