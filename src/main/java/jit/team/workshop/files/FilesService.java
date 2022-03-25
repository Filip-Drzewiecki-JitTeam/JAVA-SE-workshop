package jit.team.workshop.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilesService {

    private static final String INITIAL_VALUES = "John\nRobert\nShirley\nJessica\nKimberley";

    public void practiceIO() {
        saveExclusionsToFile(INITIAL_VALUES);

        List<String> names = loadExclusionsFromFile();

        System.out.println("Content is=" + String.join(", ", names));
    }

    private List<String> loadExclusionsFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/files/names.txt"));
            List<String> names = reader.lines().collect(Collectors.toList());
            reader.close();
            return names;
        } catch (IOException e) {
            System.out.println("Couldn't load exclusion properties from file");
            return new ArrayList<>();
        }
    }

    private void saveExclusionsToFile(String content) {
        try {
            FileWriter writer = new FileWriter("src/main/resources/files/names.txt");
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            System.out.println("Couldn't write exclusion properties to file");
        }
    }

    private List<String> appendMore(List<String> originalList, List<String> moreNames) {
        originalList.addAll(moreNames);
        return originalList;
    }

    private String mapListToSavableFormat(List<String> list) {
        return String.join("\n", list);
    }
}
