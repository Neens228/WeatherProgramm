package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {



    public static void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("WeatherFX.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 613);
        String stylesheet = getClass().getResource("Style/styles.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);
        stage.setTitle("Weather");
        stage.getIcons().add(new Image("https://cdn-icons-png.flaticon.com/512/2480/2480641.png"));
        stage.setScene(scene);
        stage.show();
        PleaseProvideControllerClassName pleaseProvideControllerClassName = new PleaseProvideControllerClassName();
        pleaseProvideControllerClassName.initialize();

    }
}
