package com.md.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.md.demo.logic.CarLogic.generateCharPlate;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void testNumberplateGanerate() {

        System.out.println(generateCharPlate());

    }

}
