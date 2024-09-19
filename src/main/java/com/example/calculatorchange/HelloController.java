package com.example.calculatorchange;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class HelloController {
    @FXML
    private TextArea areaChanges;

    @FXML
    private TextField txtPurchase, txtPayment, txtChange;

    @FXML
    protected void onCalculate(){
        try{
            double purchase = Double.parseDouble(txtPurchase.getText());
            double  payment = Double.parseDouble(txtPayment.getText());
            double changes = payment - purchase;
            final String s = String.format("%.2f", changes);
            txtChange.setText(s);
            int twenties = (int) (changes / 20);
            changes %= 20;
            int tens = (int) (changes / 10);
            changes %= 10;
            int fives = (int) (changes / 5);
            changes %= 5;
            int ones = (int) (changes / 1);
            changes %= 1;
            int quarters = (int) (changes / 0.25);
            changes %= 0.25;
            int dimes = (int) (changes / 0.1);
            changes %= 0.1;
            int nickels = (int) (changes / 0.05);
            changes %= 0.05;
            int pennies = (int) Math.round(changes / 0.01);

            // Display the changes in the areaChanges TextArea
            StringBuilder sb = new StringBuilder();
            sb.append("Purchase amount: $ ").append(purchase).append("\n");
            sb.append("Cash paid: $").append(payment).append("\n");
            sb.append("Total changes: $").append(s).append("\n");
            sb.append("Chages--> # of $20 bills: ").append(twenties).append("\n");
            sb.append("Chages--> # of $10 bills: ").append(tens).append("\n");
            sb.append("Chages--> # of $ 5 bills: ").append(fives).append("\n");
            sb.append("Chages--> # of $ 1 bills: ").append(ones).append("\n");
            sb.append("Chages--> # of quaters: ").append(quarters).append("\n");
            sb.append("Chages--> # of dimes: ").append(dimes).append("\n");
            sb.append("Chages--> # of nikels: ").append(nickels).append("\n");
            sb.append("Chages--> # of pennies: ").append(pennies).append("\n");
            areaChanges.setText(sb.toString());
        }
        catch(NumberFormatException e){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Warning!");
            alert.setHeaderText("Caught Exception: wrong number format!");
            alert.setContentText( e.getMessage());
            alert.showAndWait();
        }
    }
    @FXML
    protected void onResetButton(){
       txtPurchase.setText("");
       txtPayment.setText("");
       txtChange.setText("");
       areaChanges.setText("");
    }


}