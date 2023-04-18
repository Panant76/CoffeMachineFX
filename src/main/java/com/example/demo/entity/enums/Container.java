package com.example.demo.entity.enums;


import com.example.demo.entity.drink.Drink;
import com.example.demo.exception.ContainerIsEmptyException;
import com.example.demo.exception.ContainerIsFullException;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;

public enum Container {


    GARBAGE(5, "Контейнер для отходов", 0) {
        @Override
        public void changeCapacity(Drink drink) throws ContainerIsFullException {
            if (this.getCurrentState() == this.getCapacity()) {
                throw new ContainerIsFullException();
            }
            this.setCurrentState(this.getCurrentState() + 1);
        }
        @Override
        public void reset() {
            this.setCurrentState(0);
        }
    },
    COFFEE(10, "Контейнер для кофе", 10) {
        public void changeCapacity(Drink drink) throws ContainerIsEmptyException {
            if (this.getCurrentState() < drink.getCoffee() && this.getCurrentState()==0) {
                throw new ContainerIsEmptyException(this.getName());
            }
            this.setCurrentState(this.getCurrentState() - drink.getCoffee());
        }

        @Override
        public void reset() {
            this.setCurrentState(10);
        }
    },
    MILK(3, "Контейнер для молока", 3) {
        public void changeCapacity(Drink drink) throws ContainerIsEmptyException {
            if (this.getCurrentState()< drink.getMilk()) {
                throw new ContainerIsEmptyException(this.getName());
            }
            this.setCurrentState(this.getCurrentState()- drink.getMilk());

        }

        @Override
        public void reset() {
            this.setCurrentState(3);
        }
    },
    WATER(6, "Контейнер для воды", 6) {
        public void changeCapacity(Drink drink) throws ContainerIsEmptyException {
            if (this.getCurrentState() < drink.getWater() && this.getCurrentState()==0) {
                throw new ContainerIsEmptyException(this.getName());
            }
            this.setCurrentState(this.getCurrentState() - drink.getWater());

        }

        @Override
        public void reset() {
            this.setCurrentState(6);
        }
    };

    private int capacity;
    private String name;
    private int currentState;

    Container(int capacity, String name, int currentState) {
        this.capacity = capacity;
        this.name = name;
        this.currentState = currentState;
    }

    public abstract void changeCapacity(Drink drink)
            throws ContainerIsEmptyException, ContainerIsFullException;

    public abstract void reset();

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    public int getCurrentState() {
        return currentState;
    }

    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


}
