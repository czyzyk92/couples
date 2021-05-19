import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Couples {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();
        input.close();
        final Integer sum = 13;
        List<Integer> list = getListFromString(inputString);

        list.stream().sorted().forEach(integer -> {
                    Integer findNumber = sum - integer;
                    Optional<Integer> any = list.stream().filter(n -> n.equals(findNumber)).findAny();
                    if (any.isPresent() && integer < findNumber) {
                        System.out.println(integer + " " + findNumber);
                    } else {
                        list.remove(integer);
                    }
                }
        );
    }

    static List<Integer> getListFromString(String stringOfNumbers) {
        List<Integer> list = null;
        try {
            list = Stream.of(stringOfNumbers.split(" "))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("The value entered must be a number");
        }
        return list;
    }
}