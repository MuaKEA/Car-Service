package com.md.demo.logic;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CarLogic {


    public static String generateCharPlate(){

        StringBuilder numberPlate= new StringBuilder();

        Random random = new Random();


        for (int i = 0; i <2 ; i++) {
            char c = (char)(random.nextInt(26) + 'A');
            numberPlate.append(c);
        }

        numberPlate.append(generateLicenseNumb());

        return numberPlate.toString();
    }


    public static int generateLicenseNumb(){
        Random random = new Random();



        return random.nextInt(99999-10000) + 10000;
    }



    //make numberplate Check, so that we dont get repeating numberplate's..

}
