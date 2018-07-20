import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner2 {
    public static void main(String[] args) {
        int result = 6;
        List<String> collect = getIntegerStream().flatMap(number1 -> getIntegerStream()
                .filter(element -> getIntegerStream().filter(x -> x.equals(element)).count() > 1 || !element.equals(number1))
                .flatMap(number2 -> number2 + number1 == result ? Stream.of("True") : Stream.of("False")))
                .collect(Collectors.toList());
        System.out.println(collect.contains("True") ? "True" : "False");
    }

    private static Stream<Integer> getIntegerStream() {
        return Stream.of(1, 2, 3, 3);
    }
}
