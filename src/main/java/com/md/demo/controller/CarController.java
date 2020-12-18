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

    @PostMapping("/createcars")
    public ResponseEntity<String> CreateCars() {


        ArrayList<Car> carArrayList = new ArrayList<>();
        carArrayList.add(new Car("Audi", "A3",generateCharPlate(), 5, 1.4, 2017));
        carArrayList.add(new Car("vw", "polo",generateCharPlate(), 5, 1.6, 2016));
        carArrayList.add(new Car("Citroen", "C3",generateCharPlate(), 6, 2.0, 2014));
        carArrayList.add(new Car("Mazda", "232",generateCharPlate(), 5, 1.8, 2018));
        carArrayList.add(new Car("BMW", "512",generateCharPlate(), 6, 2.2, 2012));
        carArrayList.add(new Car("Vw", "Golf",generateCharPlate(), 5, 1.6, 2016));

        iCarsCrud.saveAll(carArrayList);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/GetCar")
    public ResponseEntity<Car> getGar(@RequestParam(name = "Carid") Long carId) {

        Optional<Car> optionalCar = iCarsCrud.findById(carId);


        return optionalCar.map(car -> new ResponseEntity<>(car, HttpStatus.ACCEPTED)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }


    @DeleteMapping("/DeleteCar")
    public ResponseEntity<String> deleteCar(@RequestParam(name = "LicencePlate") String licencePlate) {

        Optional<Car> optionalCar = iCarsCrud.findByNumerPlate(licencePlate);


        if (optionalCar.isPresent()) {


            iCarsCrud.delete(optionalCar.get());
        } else {


            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        return new ResponseEntity<>(HttpStatus.OK);

    }



    @GetMapping("/updatCar")
    public ResponseEntity<Car> updatCar(@RequestBody Car car){









    return new ResponseEntity<Car>(HttpStatus.OK);
}
}