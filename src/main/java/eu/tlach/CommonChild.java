package eu.tlach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommonChild {

    public static int commonChild(String s1, String s2) {
        char[] word1 = s1.toCharArray();
        char[] word2 = s2.toCharArray();
        List<Character> child = new ArrayList<>();

        //HARRY
        //SALLY

        int index = 0;
        for(int i = 0; i< s1.length(); i++){


            for(int j = index;j<s1.length(); j++)
            {
                if(word1[i] == word2[j]){
                    child.add(word1[i]);
                    index++;
                    break;
                }

            }
        }

        return 0;
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

    }
}
