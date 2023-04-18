package com.example.demo;

import com.example.demo.entity.drink.BlackCoffee;
import com.example.demo.entity.drink.Capuchino;
import com.example.demo.entity.drink.Drink;
import com.example.demo.entity.drink.HotMilk;
import com.example.demo.entity.enums.Container;
import com.example.demo.exception.ContainerIsEmptyException;
import com.example.demo.exception.ContainerIsFullException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import static com.example.demo.entity.enums.Container.*;

public class HelloController {
    Container container;
    private static final String DRINK_READY_MESSAGE = "Ваш напиток готов";
    private static final String WELCOME_MESSAGE = "Привет! Выберите напиток";
    @FXML
    ProgressBar pgMilk;
    @FXML
    ProgressBar pgCoffee;
    @FXML
    ProgressBar pgWater;
    @FXML
    ProgressBar pgGarbage;
    void changeProgressBar(){
        pgCoffee.setProgress(COFFEE.getCurrentState()/COFFEE.getCapacity());
        pgMilk.setProgress(MILK.getCurrentState()/MILK.getCapacity());
        pgWater.setProgress(WATER.getCurrentState()/WATER.getCapacity());
        pgGarbage.setProgress(GARBAGE.getCurrentState()/GARBAGE.getCapacity());
    }
    @FXML
    TextField display;

    @FXML
    protected void onHotMilkButtonClick() {
        createHotMilk();

    }


    void createHotMilk() {
        Drink hotMilk = new HotMilk();
        try {
            hotMilk.make(this);
            changeProgressBar();
            display.setText(DRINK_READY_MESSAGE+MILK.getCurrentState());
        } catch (ContainerIsEmptyException | ContainerIsFullException e) {
            display.setText(e.getMessage());
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
        }
    }

    void createCoffee() {
        Drink coffee = new BlackCoffee();
        try {
            coffee.make(this);
            changeProgressBar();
            display.setText((DRINK_READY_MESSAGE) + (WATER.getCapacity()));
        } catch (ContainerIsEmptyException | ContainerIsFullException e) {
            display.setText(e.getMessage());
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
        display.setText(WELCOME_MESSAGE);
    }

    @FXML
    public void pgGarbageCl(MouseEvent mouseEvent) {
        GARBAGE.reset();
        changeProgressBar();
        display.setText(WELCOME_MESSAGE);
    }

    @FXML
    public void pgWaterCl(MouseEvent mouseEvent) {
        WATER.reset();
        changeProgressBar();
        display.setText(WELCOME_MESSAGE);
    }

    @FXML
    public void pgMilkCl(MouseEvent mouseEvent) {
        MILK.reset();
        changeProgressBar();
        display.setText(WELCOME_MESSAGE);
    }
}