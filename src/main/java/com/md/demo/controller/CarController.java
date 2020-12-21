package com.md.demo.controller;

import com.md.demo.cars.Car;
import com.md.demo.crud.iCarCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

import static com.md.demo.logic.CarLogic.generateCharPlate;


@Controller
public class CarController {

    @Autowired
    iCarCrud iCarsCrud;

    @PostMapping("/createRandomCars")
    public ResponseEntity<String> CreateCars() {


        ArrayList<Car> carArrayList = new ArrayList<>();
        carArrayList.add(new Car("Audi", "A3", generateCharPlate(), 5, 1.4, 2017));
        carArrayList.add(new Car("vw", "polo", generateCharPlate(), 5, 1.6, 2016));
        carArrayList.add(new Car("Citroen", "C3", generateCharPlate(), 6, 2.0, 2014));
        carArrayList.add(new Car("Mazda", "232", generateCharPlate(), 5, 1.8, 2018));
        carArrayList.add(new Car("BMW", "512", generateCharPlate(), 6, 2.2, 2012));
        carArrayList.add(new Car("Vw", "Golf", generateCharPlate(), 5, 1.6, 2016));

        iCarsCrud.saveAll(carArrayList);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/createCar")
    public ResponseEntity<String> createCar(@RequestParam(name = "manufacturer") String manufacturer,
                                            @RequestParam(name = "model") String model,
                                            @RequestParam(name = "numberplate") String numberplate,
                                            @RequestParam(name = "gears") int gears,
                                            @RequestParam(name = "motorsize") double motorsize,
                                            @RequestParam(name = "modelyear") int modelyear) {


        iCarsCrud.save(new Car(manufacturer, model, numberplate, gears, motorsize, modelyear));

        System.out.println("working");
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/getCar")
    public ResponseEntity<Car> getGar(@RequestParam(name = "Carid") Long carId) {

        Optional<Car> optionalCar = iCarsCrud.findById(carId);


        return optionalCar.map(car -> new ResponseEntity<>(car, HttpStatus.ACCEPTED)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }


    @DeleteMapping("/deleteCar")
    public ResponseEntity<String> deleteCar(@RequestParam(name = "LicencePlate") String licencePlate) {

        Optional<Car> optionalCar = iCarsCrud.findByNumerPlate(licencePlate);


        if (optionalCar.isPresent()) {


            iCarsCrud.delete(optionalCar.get());
            return new ResponseEntity<>(HttpStatus.OK);

        }


        return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }


    @GetMapping("/updateCar")
    public ResponseEntity<Car> updatCar(@RequestParam Car car) {


        if (iCarsCrud.findByNumerPlate(car.getNumerPlate()).isPresent()) {


            iCarsCrud.save(car);

            return new ResponseEntity<Car>(HttpStatus.OK);


        }
        return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);


    }
}