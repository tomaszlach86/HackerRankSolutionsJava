package eu.tlach;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FrequencyQuery {

    public static void main(String[] args) throws IOException {

        File tc = new File("src/main/resources/input05.txt");
        File resp = new File("src/main/resources/output05.txt");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(tc));
        BufferedReader outputReader = new BufferedReader(new FileReader(resp));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();
        List<String> responsesStr = Files.readAllLines(Path.of("src/main/resources/output05.txt"));
        List<Integer> responsesIntr = responsesStr
                .stream()
                .map(Integer::parseInt)
                .collect(toList());

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );


            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        System.out.println(ans);

        bufferedReader.close();
        bufferedWriter.close();

    }

    static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        int[] quantities = new int[queries.size() + 1];
        List<Integer> result = new ArrayList<>();

        for (List<Integer> query : queries) {
            int value = query.get(1);
            int order = query.get(0);
            int frequency = frequencies.getOrDefault(value, 0);
            switch (order) {
                case 1:
                    // process fq
                    frequencies.compute(value, (key, val) -> (val == null) ? 1 : val + 1);
                    // process qt
                    quantities[frequency]--;
                    quantities[frequency + 1]++;
                    break;
                case 2:
                    // process fq
                    if (frequency == 0) break;

                    frequencies.computeIfPresent(value, (key, val) ->
                            (val == 1) ? frequencies.remove(key) : val - 1);
                    // process qt
                    quantities[frequency]--;
                    quantities[frequency - 1]++;
                    break;
                case 3:
                    if (value >= quantities.length) result.add(0);
                    else result.add(quantities[value] > 0 ? 1 : 0);
                    break;
            }
        }

        return result;
    }
}
