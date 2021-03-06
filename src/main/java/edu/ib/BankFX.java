package edu.ib;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * BankFX as a class responsible for Bank window stage set (as a subwindow to the LoginFX);
 */

public class BankFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("edu.ib/fxml/loginFX.fxml"));
        Scene scene= new Scene(root);
        primaryStage.setTitle("bank interface");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
