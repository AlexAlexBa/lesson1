package ru.alex.lesson3.org_structure;

import java.io.File;
import java.io.IOException;

public interface OrgStructureParser {

    Employee parseStructure(File csvFile) throws IOException;

}
