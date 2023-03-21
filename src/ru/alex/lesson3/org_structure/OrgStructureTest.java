package ru.alex.lesson3.org_structure;

import java.io.File;
import java.io.IOException;

public class OrgStructureTest {
    public static void main(String[] args) throws IOException {
        File file = new File("src/resources/data1.txt");

        OrgStructureParser orgStructureParser = new OrgStructureParserImpl();
        Employee boss = orgStructureParser.parseStructure(file);
    }
}
