package com.example.demo.entity.drink;


import com.example.demo.HelloController;
import com.example.demo.entity.enums.Container;
import com.example.demo.exception.ContainerIsEmptyException;
import com.example.demo.exception.ContainerIsFullException;

public class Capuchino extends Drink {
    public Capuchino() {
        super(2, 1, 1);
    }

    @Override
    public void make(HelloController coffeeMachine)
            throws ContainerIsEmptyException, ContainerIsFullException {
        for (int i = 0; i < Container.values().length; i++) {
            Container.values()[i].changeCapacity(this);
        }
    }
}
