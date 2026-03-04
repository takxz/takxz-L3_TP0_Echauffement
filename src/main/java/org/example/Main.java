package org.example;

import org.example.Exercice2.Calculator;
import org.example.Exercice2.Reader;
import org.example.Exercice4.Poke_info;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Reader reader = new Reader();
        List list;
        list = reader.readFile("src/main/java/org/example/Exercice2/texte.txt");
        System.out.println("-------------------- Exercice 2 : --------------------");
        Calculator.numberOfLines(list);
        Calculator.numberOfWord(Collections.singletonList("Bonjour, le monde !"));
        Calculator.top5Words(list);

        System.out.println("-------------------- Exercice 4 : --------------------");
        try {
            Poke_info pokeInfo = new Poke_info();
            pokeInfo.getPokemonInfo("ezrzerez");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        }
    }
