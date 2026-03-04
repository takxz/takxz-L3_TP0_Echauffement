package org.example.Exercice2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Calculator {

    public static int numberOfLines(List<String> list) {
        //Comme on a mis chaque ligne du texte dans une liste, le nombre de ligne correspond à la taille de la liste
        System.out.println("Number of lines: " + list.size());
        return list.size();
    }

    public static int numberOfWord(List<String> list){
        //On parcourt chaque ligne de la liste, on supprime les caractères spéciaux et on split les mots pour les compter
        int numberOfWord = 0;
        for (Object o : list) {
            String str = o.toString().replaceAll("[^a-zA-ZÀ-ÿ\\s]", "");
            String[] words = str.split("\\s+");
            numberOfWord += words.length;
        }
        System.out.println("Nombre de mots : " + numberOfWord);
        return numberOfWord;
    }

    public static Map<String, Long> top5Words(List<String> list) {
        //On utilise un stream pour parcourir chaque ligne, split les mots, les mettre en minuscules et les compter
        Map<String, Long> wordCount = list.stream()
                .flatMap(line -> List.of(line.split("\\s+")).stream())
                .filter(word -> !word.isEmpty())
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        System.out.println("Les 5 mots les plus utilisés :");
        //On trie le map par valeur (le nombre d'occurrence) et on affiche les 5 premiers
        wordCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .forEach(entry -> System.out.println("  " + entry.getKey() + " : " + entry.getValue()));
        return wordCount;
    }

}
