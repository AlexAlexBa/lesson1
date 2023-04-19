package ru.alex.lesson3.org_structure;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrgStructureParserImpl implements OrgStructureParser {
    @Override
    public Employee parseStructure(File csvFile) {
        List<String> lines = loadLines(csvFile);
        return parseStrings(lines).stream().filter(e -> e.getBoss() == null).findFirst().get();
    }

    private List<String> loadLines(File file) {
        List<String> lines = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(file);
             Scanner scanner = new Scanner(fileInputStream)) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    private List<Employee> parseStrings(List<String> lines) {
        List<Employee> employees = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String[] arrayFields = lines.get(i).split(";");
            Employee employee = new Employee();
            employee.setId(Long.valueOf(arrayFields[0]));
            if (!arrayFields[1].equals("")) {
                employee.setBossId(Long.valueOf(arrayFields[1]));
            }
            employee.setName(arrayFields[2]);
            employee.setPosition(arrayFields[3]);
            employee.setBoss(employees.stream()
                    .filter(e -> e.getId().equals(Long.valueOf(arrayFields[1])))
                    .findFirst()
                    .orElse(null));
            employees.stream()
                    .filter(e -> e.getId().equals(Long.valueOf(arrayFields[1])))
                    .findFirst()
                    .map(e -> e.getSubordinate().add(employee));

            employees.add(employee);
        }
        return employees;
    }
}
