module com.example.tictactoenew {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tictactoenew to javafx.fxml;
    exports com.example.tictactoenew;
}