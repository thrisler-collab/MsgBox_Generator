module com.example.aufgabe_09 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aufgabe_09 to javafx.fxml;
    exports com.example.aufgabe_09;
}