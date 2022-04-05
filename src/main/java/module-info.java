module com.example.caferouge {
    requires javafx.controls;
    requires javafx.fxml;
    requires fastjson;
    opens com.example.caferouge to javafx.fxml;
    exports com.example.caferouge;
}
