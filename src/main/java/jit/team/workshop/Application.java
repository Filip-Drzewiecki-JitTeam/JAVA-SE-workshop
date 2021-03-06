package jit.team.workshop;

import jit.team.workshop.collections.ArrayService;
import jit.team.workshop.collections.CollectionService;
import jit.team.workshop.files.FilesService;
import jit.team.workshop.functions.FunctionService;
import jit.team.workshop.generics.service.GenericsService;
import jit.team.workshop.inheritance.service.ObjectsService;
import jit.team.workshop.variables.CalculationsService;
import jit.team.workshop.variables.ConditionsService;
import jit.team.workshop.variables.LoopService;
import jit.team.workshop.variables.StringService;

public class Application {

    private static final StringService stringService = new StringService();
    private static final CalculationsService calculationsService = new CalculationsService();
    private static final LoopService loopService = new LoopService();
    private static final ArrayService arrayService = new ArrayService();
    private static final ConditionsService conditionsService = new ConditionsService();
    private static final ObjectsService objectsService = new ObjectsService();
    private static final CollectionService collectionService = new CollectionService();
    private static final GenericsService generics = new GenericsService();
    private static final FilesService files = new FilesService();
    private static final FunctionService functions = new FunctionService();

    public static void main(String[] args) {
        System.out.println("Welcome to Java SE workshop");
    }
}
