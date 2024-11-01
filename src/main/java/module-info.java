module com.example.tictactoenew {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.tictactoenew to javafx.fxml;
    exports com.example.tictactoenew;
    exports com.example.tictactoenew.network;
    opens com.example.tictactoenew.network to javafx.fxml;
}
