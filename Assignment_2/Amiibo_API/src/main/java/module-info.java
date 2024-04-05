module org.example.amiibo_api {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;


    opens org.example.amiibo_api to javafx.fxml;
    exports org.example.amiibo_api;
}