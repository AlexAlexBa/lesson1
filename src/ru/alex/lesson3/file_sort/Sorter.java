package ru.alex.lesson3.file_sort;

import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorter {
    private final static int MAX_ROWS = 1_00_000;
    private final static String PATH = "src/resources/temp";
    private final static String FILE_EXTENSION = ".txt";
    private int counterSeparationFiles = 0;
    private List<String> listPaths = new ArrayList<>();

    public File sortFile(File dataFile) {
        separationSourceFile(dataFile);
        while (listPaths.size() != 1) {
            mergeFiles();
        }
        return new File(listPaths.get(0));
    }

    private void separationSourceFile(File dataFile) {
        List<Long> longList = new ArrayList<>(MAX_ROWS);
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(dataFile.getPath()))) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                long l = Long.parseLong(line);
                longList.add(l);

                if (longList.size() == MAX_ROWS) {
                    Collections.sort(longList);
                    listPaths.add(createNewFile(longList));
                    longList = new ArrayList<>(MAX_ROWS);
                }
            }
            if (longList.size() != 0) {
                Collections.sort(longList);
                listPaths.add(createNewFile(longList));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String createNewFile(List<Long> longList) {
        String pathString = PATH + counterSeparationFiles + FILE_EXTENSION;
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathString))) {
            for (Long number : longList) {
                bufferedWriter.write(String.valueOf(number));
                bufferedWriter.write("\n");
            }
            counterSeparationFiles++;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return pathString;
    }

    private void mergeFiles() {
        String pathStringForTempResult = PATH + counterSeparationFiles++ + FILE_EXTENSION;
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathStringForTempResult));
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(listPaths.get(0)));
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(listPaths.get(1)))
        ) {
            String currentString1 = bufferedReader1.readLine();
            String currentString2 = bufferedReader2.readLine();
            while(currentString1 != null || currentString2 != null) {
                if (currentString1 != null) {
                    if (currentString2 == null || Long.parseLong(currentString1) < Long.parseLong(currentString2)) {
                        bufferedWriter.write(currentString1);
                        bufferedWriter.write("\n");
                        currentString1 = bufferedReader1.readLine();
                    }
                }
                if (currentString2 != null) {
                    if (currentString1 == null || Long.parseLong(currentString2) <= Long.parseLong(currentString1)) {
                        bufferedWriter.write(currentString2);
                        bufferedWriter.write("\n");
                        currentString2 = bufferedReader2.readLine();
                    }
                }

            }
            listPaths.add(pathStringForTempResult);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        deleteFiles();
    }

    private void deleteFiles() {
        for (int i = 0; i < 2; i++) {
            File file = new File(listPaths.get(0));
            file.delete();
            listPaths.remove(0);
        }
    }
}

