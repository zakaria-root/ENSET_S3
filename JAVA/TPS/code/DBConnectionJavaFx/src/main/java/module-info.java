module com.example.dbconnection {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.dbconnection to javafx.fxml;
    exports com.example.dbconnection;
}