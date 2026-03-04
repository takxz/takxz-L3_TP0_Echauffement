package org.example.Exercice2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {

    public static List<String> readFile(String filename) {
        File myObj = new File(filename);
        List<String> lines = new ArrayList<>();

        //Ici, chaque ligne est un élément de la liste
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return lines;
    }
}
