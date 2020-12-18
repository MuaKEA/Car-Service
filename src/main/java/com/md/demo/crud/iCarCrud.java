package com.md.demo.crud;


import com.md.demo.cars.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface iCarCrud extends CrudRepository<Car,Long> {

Optional<Car> findById(Long id);

Optional<Car> findByNumerPlate(String numberplate);
}
