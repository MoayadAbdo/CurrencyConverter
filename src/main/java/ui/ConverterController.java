package ui;

import com.sun.javafx.scene.control.GlobalMenuAdapter;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logic.CurrencyConverter;

public class ConverterController {
    @FXML
    private TextField amountField;
    @FXML
    private ComboBox fromCurrencyBox;
    @FXML
    private ComboBox<String> toCurrencyBox;
    @FXML
    private Label resultLabel;

    //logic layer
    private CurrencyConverter converter;

    //Initialization
    @FXML
    public void initialize(){
        converter = new CurrencyConverter();
        //load
        loadCurrencyList();

        fromCurrencyBox.getSelectionModel().select("USD");
        toCurrencyBox.getSelectionModel().select("JOD");

        resultLabel.setText("Enter amount and click Convert");
    }

    private void loadCurrencyList(){
        //Will get list from converter later
        String[] currencies = converter.getCurrencies();
        fromCurrencyBox.getItems().addAll(currencies);
        toCurrencyBox.getItems().addAll(currencies);
    }
    //button click
    @FXML
    private void onConvertButtonClick(){
        try {
            double amount = Double.parseDouble(amountField.getText());
            String from = fromCurrencyBox.getValue().toString();
            String to = toCurrencyBox.getValue();

            double result = converter.convert(from, to, amount);

            resultLabel.setText(String.format("%.4f %s", result, to));

        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter a valid number!");
        } catch (Exception e) {
            resultLabel.setText("Error fetching live rates!");
            e.printStackTrace();
        }

    }
    //helper
    private void showError(String message){
        resultLabel.setStyle("-fx-text-fill:red;");
        resultLabel.setText(message);
    }
    private void displayResult(String result){
        resultLabel.setStyle("-fx-text-fill: black;");
        resultLabel.setText(result);
    }
}
