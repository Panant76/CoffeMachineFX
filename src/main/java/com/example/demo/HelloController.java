package com.example.demo;

import com.example.demo.entity.drink.BlackCoffee;
import com.example.demo.entity.drink.Capuchino;
import com.example.demo.entity.drink.Drink;
import com.example.demo.entity.drink.HotMilk;
import com.example.demo.exception.ContainerIsEmptyException;
import com.example.demo.exception.ContainerIsFullException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.stream.Stream;

import static com.example.demo.entity.enums.Container.*;

public class HelloController {

    private static final String DRINK_READY_MESSAGE = "Ваш напиток готов";
    private static final String WELCOME_MESSAGE = "Привет! Выберите напиток";
    @FXML
    Button mk;
    @FXML
    Button cf;
    @FXML
    Button cp;
    @FXML
    ProgressBar pgMilk;
    @FXML
    ProgressBar pgCoffee;
    @FXML
    ProgressBar pgWater;
    @FXML
    ProgressBar pgGarbage;

    @FXML
    TextField display;

    void changeProgressBar() {
        pgCoffee.setProgress((double) COFFEE.getCurrentState() / (double) COFFEE.getCapacity());
        pgMilk.setProgress((double) MILK.getCurrentState() / (double) MILK.getCapacity());
        pgWater.setProgress((double) WATER.getCurrentState() / (double) WATER.getCapacity());
        pgGarbage.setProgress((double) GARBAGE.getCurrentState() / (double) GARBAGE.getCapacity());
    }

    @FXML
    protected void onHotMilkButtonClick() {
        createHotMilk();
    }


    void createHotMilk() {
        Drink hotMilk = new HotMilk();
        try {
            hotMilk.make(this);
            changeProgressBar();
            display.setText(DRINK_READY_MESSAGE);
        } catch (ContainerIsEmptyException | ContainerIsFullException e) {
            display.setText(e.getMessage());
            cp.setDisable(true);
            mk.setDisable(true);

        }
    }

    void createCapuchino() {
        Drink capuchino = new Capuchino();
        try {
            capuchino.make(this);
            changeProgressBar();
            display.setText(DRINK_READY_MESSAGE);
        } catch (ContainerIsEmptyException | ContainerIsFullException e) {
            display.setText(e.getMessage());
            cf.setDisable(true);
            cp.setDisable(true);
        }
    }

    void createCoffee() {
        Drink coffee = new BlackCoffee();
        try {
            coffee.make(this);
            changeProgressBar();
            display.setText(DRINK_READY_MESSAGE);
        } catch (ContainerIsEmptyException | ContainerIsFullException e) {
            display.setText(e.getMessage());
            cf.setDisable(true);
            cp.setDisable(true);
        }
    }

    @FXML
    protected void onBlackCoffeeButtonClick(ActionEvent actionEvent) {
        createCoffee();
    }

    @FXML
    protected void onCapuchinoButtonClick(ActionEvent actionEvent) {
        createCapuchino();
    }


    @FXML
    public void pgCoffeeCl(MouseEvent mouseEvent) {
        COFFEE.reset();
        changeProgressBar();
        cf.setDisable(false);
        cp.setDisable(false);
        // display.setText(WELCOME_MESSAGE);
    }

    @FXML
    public void pgGarbageCl(MouseEvent mouseEvent) {
        GARBAGE.reset();
        changeProgressBar();
        //display.setText(WELCOME_MESSAGE);
    }

    @FXML
    public void pgWaterCl(MouseEvent mouseEvent) {
        WATER.reset();
        changeProgressBar();
        // display.setText(WELCOME_MESSAGE);
    }

    @FXML
    public void pgMilkCl(MouseEvent mouseEvent) {
        MILK.reset();
        changeProgressBar();
        // display.setText(WELCOME_MESSAGE);
    }
}