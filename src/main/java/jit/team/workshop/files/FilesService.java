package jit.team.workshop.files;

import jit.team.workshop.files.objects.Employee;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FilesService {

    public void practiceMappers() {
        readAndWriteFile();
        parseCsv();
    }

    private void readAndWriteFile() {
        TextFileService fileService = new TextFileService();
        fileService.practiceIO();
    }

    private void parseCsv() {
        byte[] csv = readFile();

        CsvMapper<Employee> mapper = new CsvMapper<>(Employee.class);

        List<Employee> employees = mapper.read(csv);
        employees.add(new Employee("Jason", 35, BigDecimal.valueOf(30000)));

        byte[] csvToSave = mapper.write(employees, List.of("name", "age", "income"));

        writeFile(csvToSave);

        System.out.println(employees);
    }

    public byte[] readFile() {
        InputStream stream = ClassLoader.getSystemResourceAsStream("files/employees.csv");
        Path path = Paths.get("src/main/resources/files/employees.csv");

        try {
            return Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException("Can't read the file");
        }
    }

    public void writeFile(byte[] csv) {
        Path path = Paths.get("src/main/resources/files/processedEmployees.csv");

        try {
            Files.write(path, csv);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException("Can't write to the file");
        }
    }
}
