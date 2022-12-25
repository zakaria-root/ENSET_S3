module com.example.testtablevew {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.testtablevew to javafx.fxml;
    exports com.example.testtablevew;
    exports com.example.testtablevew.Etities;
    opens com.example.testtablevew.Etities to javafx.fxml;
    exports com.example.testtablevew.Services;
    opens com.example.testtablevew.Services to javafx.fxml;
    exports com.example.testtablevew.Dao;
    opens com.example.testtablevew.Dao to javafx.fxml;


}