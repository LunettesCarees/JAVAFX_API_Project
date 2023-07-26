package com.example.javaassignment2.Controllers;

import com.example.javaassignment2.Utilities.CountryCode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SearchController implements Initializable {

    @FXML
    private Button detailsButton;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private ImageView imageView;

    @FXML
    void detailsButton_onclick(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        imageView.setImage(new Image("https://www.worldatlas.com/r/w1300-q80/upload/f4/e0/49/shutterstock-1665254809.png"));
        detailsButton.setVisible(false);
        ArrayList<String> countryCodes = CountryCode.getCountryCodes("src/main/resources/com/example/javaassignment2/country_code.json");
        comboBox.getItems().addAll(countryCodes);
    }
}
