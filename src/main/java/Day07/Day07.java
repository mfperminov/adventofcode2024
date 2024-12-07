package Day07;

import java.util.Arrays;
import java.util.List;

import utils.Input;

public class Day07 {
    public static void main(String[] args) {
        partOne();
    }

    private static void partOne() {
        var input = Input.readInput("Day07");
        var sum = input.stream().mapToLong(value -> handleSingleEquation(value)).sum();
        System.out.println("Day 7, part 1 answer = " + sum);
    }

    private static long handleSingleEquation(String s) {
        var result = Long.parseLong(s.split(":")[0]);
        List<Long> operands = Arrays.stream(s.split(": ")[1].split(" "))
                .mapToLong(Long::parseLong)
                .boxed()
                .toList();
        return reduce(result, operands.getFirst(), operands.subList(1, operands.size()));
    }

    private static long reduce(long required, long current, List<Long> sublist) {
        if (sublist.size() > 1) {
            var res1 = reduce(required, current + sublist.getFirst(), sublist.subList(1, sublist.size()));
            var res2 = reduce(required, current * sublist.getFirst(), sublist.subList(1, sublist.size()));
            if (res1 == required || res2 == required) {
                return required;
            } else {
                return 0L;
            }
        } else {
            if (sublist.size() == 1) {
                if (current + sublist.getFirst() == required || current * sublist.getFirst() == required) {
                    return required;
                } else {
                    return 0L;
                }
            } else {
                if (current == required) {
                    return required;
                } else {
                    return 0L;
                }
            }
        }
    }

}