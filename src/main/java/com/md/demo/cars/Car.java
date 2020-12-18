package com.md.demo.cars;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String manufacturer;
    private String model;
    private String numerPlate;
    private int gears;
    private double motorSize;
    private int modelYear;


    public Car() {
    }

    public Car(String manufacturer, String model,String numerPlate , int gears, double motorSize, int modelYear) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.gears = gears;
        this.motorSize = motorSize;
        this.modelYear = modelYear;
        this.numerPlate =numerPlate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    public double getMotorSize() {
        return motorSize;
    }

    public void setMotorSize(double motorSize) {
        this.motorSize = motorSize;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getNumerPlate() {
        return numerPlate;
    }

    public void setNumerPlate(String numerPlate) {
        this.numerPlate = numerPlate;
    }
}
