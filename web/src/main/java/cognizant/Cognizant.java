package cognizant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Cognizant {
    public static void main(String[] args) {
        int arr[] ={1,4,2,2,4,54,12,32,4,21,54,12,2,1,1,32};

        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(arr).forEach(e -> map.put(e, e));

        // Get distinct elements from the HashMap
        Integer[] distinctArray = map.values().toArray(new Integer[0]);

        // Print the distinct elements
        Arrays.stream(distinctArray).forEach(System.out::println);

    }
}