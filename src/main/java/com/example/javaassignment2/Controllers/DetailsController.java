package com.example.javaassignment2.Controllers;

import com.example.javaassignment2.Models.ApiResponse;
import com.example.javaassignment2.Utilities.ApiUtility;
import com.example.javaassignment2.Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;

public class DetailsController {

    @FXML
    private Label callingCodeLabel;

    @FXML
    private Label capitalLabel;

    @FXML
    private ListView<String> currencyListView;

    @FXML
    private Label nameLabel;

    @FXML
    void goBack_onClick(ActionEvent event) throws IOException, InterruptedException {
        SceneChanger.changeScene(event, "Views/search-view.fxml", "-1");

    }

    // This method displays the details of the country
    public void showCountryDetails(String countryCode) throws IOException, InterruptedException {
        ApiResponse apiResponse = ApiUtility.getCountryData(countryCode);
        String countryName = apiResponse.getData().getName();
        String capital = apiResponse.getData().getCapital();
        String[] currency = apiResponse.getData().getCurrencyCodes();
        String callingCodes = apiResponse.getData().getCallingCode();

        nameLabel.setText(countryName);
        capitalLabel.setText(capital);
        callingCodeLabel.setText(callingCodes);
        currencyListView.getItems().addAll(currency);

    }



}
