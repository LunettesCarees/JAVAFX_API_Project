package com.example.javaassignment2.Controllers;

import com.example.javaassignment2.Models.ApiResponse;
import com.example.javaassignment2.Utilities.ApiUtility;
import com.example.javaassignment2.Utilities.CountryCode;
import com.example.javaassignment2.Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SearchController implements Initializable {

    @FXML
    private ImageView imageView;

    @FXML
    private Button detailsButton;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private WebView webView;

    @FXML
    void detailsButton_onclick(ActionEvent event) throws IOException, InterruptedException {
        SceneChanger.changeScene(event, "Views/details-view.fxml", comboBox.getValue().substring(0, 2));

    }

    @FXML
    void comboBox_OnClick(ActionEvent event) throws IOException, InterruptedException {
        String countryCode = comboBox.getValue().substring(0, 2);
        try {
            ApiResponse apiResponse = ApiUtility.getCountryData(countryCode);
            String flagUrl = apiResponse.getData().getFlagImageUri();

            webView.getEngine().load(flagUrl);

        } catch (Exception e){
            e.printStackTrace();
        }
        detailsButton.setVisible(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        imageView.setImage(new Image("https://www.worldatlas.com/r/w1300-q80/upload/f4/e0/49/shutterstock-1665254809.png"));
        detailsButton.setVisible(false);
        ArrayList<String> countryCodes = CountryCode.getCountryCodes("src/main/resources/com/example/javaassignment2/country_code.json");
        comboBox.getItems().addAll(countryCodes);
    }

}
