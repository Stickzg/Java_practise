package com.flowacademy.wehicle;

import com.flowacademy.exceptions.IsBrokenException;
import com.flowacademy.exceptions.NoFuelException;

import java.io.Serializable;

public final class Car extends Wehicle implements IMotorized, Serializable{

    protected int fuelLevel;

    public Car(int weight, int maxSpeed) {
        super(weight, maxSpeed);
        this.fuelLevel = 50;
    }

    @Override
    public void startEngine() throws IsBrokenException {

        if (this.isBroken()){
            throw new IsBrokenException("Elromlott a dudú, nem indul sehova! :(");

        } else if (this.fuelLevel <= 0) {
            throw new NoFuelException("Nincs nafta a dudúban, nem megyünk sehova! :(");

        } else {
            System.out.println("Beröffent a dudú motorja, irány a végtelen! :)");
            this.fuelLevel -= 10;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Car car = (Car) o;

        return fuelLevel == car.fuelLevel;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + fuelLevel;
        return result;
    }

    @Override
    public void loadFuel(int i) {
        this.fuelLevel += i;
    }

    @Override
    public int getFuel() {
        return this.fuelLevel;
    }

    @Override
    public String toString() {
        return super.toString() + " mellesleg ez egy autó, " +
                fuelLevel + " egység üzemanyaggal a gyomrában.";
    }
}
