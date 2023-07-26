package com.example.javaassignment2.Utilities;

import com.example.javaassignment2.Controllers.DetailsController;
import com.example.javaassignment2.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {
    public static void changeScene(ActionEvent event, String fxmlFile, String countryCode) throws IOException, InterruptedException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());

        if(!countryCode.equals("-1")){
            DetailsController controller = fxmlLoader.getController();
            controller.showCountryDetails(countryCode);
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
