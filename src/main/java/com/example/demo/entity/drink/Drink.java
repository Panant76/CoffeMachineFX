package com.example.demo.entity.drink;


import com.example.demo.HelloController;
import com.example.demo.exception.ContainerIsEmptyException;
import com.example.demo.exception.ContainerIsFullException;

public abstract class Drink {
    private int coffee;
    private int milk;
    private int water;


    public Drink(int coffee, int milk, int water) {
        this.coffee = coffee;
        this.milk = milk;
        this.water = water;
    }

    public int getCoffee() {
        return coffee;
    }

    public int getMilk() {
        return milk;
    }

    public int getWater() {
        return water;
    }

    public abstract void make(HelloController coffeeMachine) throws ContainerIsEmptyException, ContainerIsFullException;
}
