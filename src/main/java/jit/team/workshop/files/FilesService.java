package jit.team.workshop.files;

import jit.team.workshop.files.objects.Employee;

import java.io.InputStream;
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
        InputStream csv = ClassLoader.getSystemResourceAsStream("files/employees.csv");

        CsvMapper<Employee> mapper = new CsvMapper<>(Employee.class);

        List<Employee> employees2 = mapper.map(csv);

        System.out.println(employees2);
    }
}
