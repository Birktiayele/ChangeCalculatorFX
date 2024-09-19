module com.example.calculatorchange {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.calculatorchange to javafx.fxml;
    exports com.example.calculatorchange;
}