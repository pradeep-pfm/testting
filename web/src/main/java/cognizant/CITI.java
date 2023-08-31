package cognizant;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class CITI {
    public static void main(String[] args) {
//        String s = "As98a7*5^@4s#*";
//        Map<Character,Long> charCount=s.chars()
//                .mapToObj(c->(char)c)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        //System.out.println(charCount);
//
//        charCount.forEach((character, count)->
//        System.out.println("Characters "+ character+ "count "+count));
        List<Integer> list = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);
        Map<Integer,Long>  newList=list.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        List<Integer> duplicates=newList.entrySet().stream()
                .filter(value->value.getValue()>1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(duplicates);


    }
}