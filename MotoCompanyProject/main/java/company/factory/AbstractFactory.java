package company.factory;

import company.model.vehicles.Car;
import company.model.vehicles.Motorbike;
import company.model.vehicles.Truck;

import java.awt.*;
import java.util.Dictionary;

public abstract class AbstractFactory {
    public abstract Truck getTruck();
    public abstract Motorbike getMotorbike();
    public abstract Car getCar();
    public abstract void Display();
}
