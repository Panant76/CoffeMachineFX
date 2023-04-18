package com.example.demo.entity.drink;

import com.example.demo.HelloController;
import com.example.demo.entity.enums.Container;
import com.example.demo.exception.ContainerIsEmptyException;
import com.example.demo.exception.ContainerIsFullException;

public class BlackCoffee extends Drink {
    public BlackCoffee() {
        super(2, 0, 1);
    }

    @Override
    public void make(HelloController coffeeMachine) throws ContainerIsFullException, ContainerIsEmptyException {
        for (int i = 0; i < Container.values().length; i++) {
            if (Container.values()[i] != Container.MILK) {
                Container.values()[i].changeCapacity(this);
            }
        }
    }
}
