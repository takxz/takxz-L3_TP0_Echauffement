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

    public static List cleanList(List list){
        String str = list.toString().replaceAll("([\\p{P}\\p{S}])", "");

        list = str.lines().toList();

        return list;
    }

    public static void printList(List list){
        System.out.println("List: " + list);
    }
}
