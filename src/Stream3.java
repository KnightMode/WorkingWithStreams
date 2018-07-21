import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream3 {
    public static void main(String[] args) {
        int product = 1;
        List<Integer> result = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        List<Integer> collect = getIntegerStream().flatMap(number -> getIntegerStream().parallel()
                .filter(number2 -> getIntegerStream().parallel().filter(elem -> elem.equals(number2)).count() > 1 || !number2.equals(number)))
                .collect(Collectors.toList());
        Number modFactor = getIntegerStream().count() - 1;
        for (int i = 0; i < collect.size(); i++) {
            if (i == 0 || (i + 1) % modFactor.intValue() != 0) {
                product *= collect.get(i);
            } else {
                result.add(product * collect.get(i));
                product = 1;
            }
        }
        System.out.println("The total execution time is: " + (System.currentTimeMillis() - startTime) / 1000.0 + " seconds");
        System.out.println(result);
    }

    private static Stream<Integer> getIntegerStream() {
        return Stream.of(1, 2, 3, 4);
    }
}

