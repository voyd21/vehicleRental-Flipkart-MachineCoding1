module com.example.mcr1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mcr1 to javafx.fxml;
    exports com.example.mcr1;
}