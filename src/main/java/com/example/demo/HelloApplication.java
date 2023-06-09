package com.example.demo;

import com.example.demo.entity.enums.Container;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.stream.Stream;

public class  HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("I CoffeMachine");
        stage.setScene(scene);
        stage.show();
        Stream.of(Container.values()).forEach(Container::reset);
    }

    public static void main(String[] args) {
        launch();
    }
}