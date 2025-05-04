module com.example.climbingapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.climbingapp to javafx.fxml;
    exports com.example.climbingapp;
}