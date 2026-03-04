package org.example.Exercice2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Calculator {

    public static int numberOfLines(List<String> list) {
        System.out.println("Number of lines: " + list.size());
        return list.size();
    }

    public static int numberOfWord(List<String> list){
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
        Map<String, Long> wordCount = list.stream()
                .flatMap(line -> List.of(line.split("\\s+")).stream())
                .filter(word -> !word.isEmpty())
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        System.out.println("Les 5 mots les plus utilisés :");
        wordCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .forEach(entry -> System.out.println("  " + entry.getKey() + " : " + entry.getValue()));
        return wordCount;
    }

}
