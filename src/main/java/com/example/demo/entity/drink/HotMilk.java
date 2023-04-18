package com.example.demo.entity.drink;


import com.example.demo.HelloController;
import com.example.demo.entity.enums.Container;
import com.example.demo.exception.ContainerIsEmptyException;
import com.example.demo.exception.ContainerIsFullException;

public class HotMilk extends Drink {
    public HotMilk() {
        super(0, 3, 0);
    }

    @Override
    public void make(HelloController coffeeMachine)
            throws ContainerIsEmptyException, ContainerIsFullException {
        Container.MILK.changeCapacity(this);
    }
}
