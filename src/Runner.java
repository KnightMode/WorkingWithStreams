import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.max;

public class Runner {
    public static void main(String[] args) {
        List<Integer> collect = getDistinctIntegerStream()
                .flatMap(number1 -> getDistinctIntegerStream()
                        .filter(element -> getIntegerStream().filter(x -> x.equals(element)).count() > 1 || !element.equals(number1))
                        .flatMap(number3 -> Stream.of(number1 + number3))).collect(Collectors.toList());


        System.out.println("The possible Sum values are :" + collect);
        double x = collect.size() != 0 ? (double) collect.stream().filter(element -> element.equals(max(collect))).count() / collect.size() :
                1;
        System.out.println("The probability of choosing the maximum sum from the array is:" + x);
    }

    private static Stream<Integer> getDistinctIntegerStream() {
        return getIntegerStream().distinct();
    }

    private static Stream<Integer> getIntegerStream() {
        return Stream.of(1, 2, 5, 5);
    }
}
