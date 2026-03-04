package Exercice2;

import org.example.Exercice2.Calculator;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class test {

    @Test
    public void testerSiLeNombreDeLigneEstCorrect(){
        List<String> str = List.of("Ligne 1", "Ligne 2", "Ligne 3");
        int result = Calculator.numberOfLines(str);
        assertEquals(3, result, 0);
    }

    @Test
    public void testSiLeComptageDesMotsEstCorrect(){
        List<String> str = Collections.singletonList("Bonjour, le monde !");
        int result = Calculator.numberOfWord(str);
        assertEquals(3,result,0);
    }

    @Test
    public void testerSiLeComptageDeLOccurenceDesMotsFonctionne(){
        List<String> str = Collections.singletonList("pomme poire pomme banane pomme poire");
        Map<String, Long> result = Calculator.top5Words(str);
        assertEquals(3, (long) result.get("pomme"));
        assertEquals(2, (long) result.get("poire"));
        assertEquals(1, (long) result.get("banane"));
    }

}
