package jit.team.workshop;

import jit.team.workshop.collections.ArrayService;
import jit.team.workshop.collections.CollectionService;
import jit.team.workshop.inheritance.CarService;
import jit.team.workshop.variables.CalculationsService;
import jit.team.workshop.variables.ConditionsService;
import jit.team.workshop.variables.LoopService;
import jit.team.workshop.variables.StringService;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello world");

        StringService stringService = new StringService();
        CalculationsService calculationsService = new CalculationsService();
        LoopService loopService = new LoopService();
        ArrayService arrayService = new ArrayService();
        ConditionsService conditionsService = new ConditionsService();
        CarService carService = new CarService();
        CollectionService collectionService = new CollectionService();


//        stringService.helloWorld();
//
//        calculationsService.practiceCalculations();
//
//        loopService.practiceLoops();
//
//        arrayService.practiceArrays();
//
//        conditionsService.practiceConditions();
//
//        carService.drivingDemo();
//
//        collectionService.practiceCollections();
    }
}
