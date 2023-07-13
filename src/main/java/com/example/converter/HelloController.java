package com.example.converter;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label result;
    @FXML
    private TextField toConvert;
    @FXML
    private ComboBox<String> convertables;
    @FXML
    private ComboBox<String> convertablesResults;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    //application strat
    {
        convertables.getItems().addAll("Celsius", "Fahrenheit", "Pounds", "Kilograms");
        convertablesResults.getItems().addAll("Celsius", "Fahrenheit", "Pounds", "Kilograms");
        convertablesResults.setDisable(true);
    }

    private double gettoConvert(){
        return Double.parseDouble(toConvert.getText());
    }
    private void CelsiusToFahrenheit(){
        String fahrenheit = Double.toString((gettoConvert() * 9/5) + 32);
        result.setText(fahrenheit);
        convertablesResults.getSelectionModel().select("Fahrenheit");
    }


    private void Fahrenheittocelsius(){
        String celsius = Double.toString(((gettoConvert() - 32) * 5 )/ 9);
        result.setText(celsius);
        convertablesResults.getSelectionModel().select("Celsius");
    }

    private void PoundtoKG(){
        String kilograms = Double.toString(gettoConvert()/2.205);
        result.setText(kilograms);
        convertablesResults.getSelectionModel().select("Kilograms");
    }

    private void KGtoPound(){
        String Pound = Double.toString(gettoConvert() * 2.205);
        result.setText(Pound);
        convertablesResults.getSelectionModel().select("Pounds");
    }

    @FXML
    private void Convert(){
        if(convertables.getValue() == "Celsius"){
            CelsiusToFahrenheit();
        }

        else if(convertables.getValue() == "Fahrenheit"){
            Fahrenheittocelsius();
        }

        else if(convertables.getValue() == "Pounds"){
            PoundtoKG();
        }

        else if(convertables.getValue() == "Kilograms"){
            KGtoPound();
        }

    }







}


