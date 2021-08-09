package eu.tlach;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputeTest {


    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Key1", 12);
        map.put("Key2", 15);

        // print map details
        System.out.println("Map: " + map);

        // remap the values
        // using compute method
        map.compute("Key1", (key, val)
                -> (val == null)
                ? 1
                : val + 1);
        map.compute("Key3", (key, val)
                -> (val == null)
                ? 1
                : val + 5);

        // print new mapping
        System.out.println("New Map: " + map);

        var edek = FrequencyQuery.freqQuery(List.of(
                List.of(1, 5)
                , List.of(1, 6)
                , List.of(3, 2)
                , List.of(1, 10)
                , List.of(1, 10)
                , List.of(1, 6)
                , List.of(2, 5)
                , List.of(3, 2)
        ));

        System.out.println(edek);

    }
}
