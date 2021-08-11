package eu.tlach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MakeAnagram {

    public static int makeAnagram(String a, String b) {
        int lena = a.length();
        int lenb = b.length();
        Map<Character, Integer> mapA = convertToMap(a);
        Map<Character, Integer> mapB = convertToMap(b);

        //1 find common map
        Map<Character, Integer> commonMap = mapA.entrySet().stream()
                .filter(x -> mapB.containsKey(x.getKey()))
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));

        for (Character letter : commonMap.keySet()) {
            commonMap.compute(letter, (k, v) -> mapA.get(k) < mapB.get(k) ? mapA.get(k) : mapB.get(k));
        }

        Integer sum =   commonMap.values().stream()
                .reduce(0, Integer::sum);

        return (lena-sum)+(lenb-sum);
    }

    private static Map<Character, Integer> convertToMap(String word) {
        Map<Character, Integer> wordMap = new HashMap<>();

        for (Character letter : word.toCharArray()) {
            wordMap.compute(letter, (k, v) -> (v == null) ? 1 : v + 1);
            // map.compute("Key1", (key, val)-> (val == null)? 1: val + 1);
        }

        return wordMap;
    }

    public static void main(String[] args) {
        System.out.println(makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke")); //ma być 30
    }
}
