package Day03;

import utils.Input;

public class Day03 {
    public static void main(String[] args) {
        partOne();
    }

    private static void partOne() {
        var line = Input.readSingleLineInput("Day03");
        long result = 0;
        int i = 0;
        while (i < line.length()) {
            var nextMulIndex = line.indexOf("mul(", i);
            if (nextMulIndex == -1) {
                break;
            }
            i = nextMulIndex + 4;
            var firstNumber = checkForNumber(line, i, ',');
            if (firstNumber.number() == -1) {
                continue;
            }
            i = firstNumber.index();
            var secondNumber = checkForNumber(line, i, ')');
            if (secondNumber.number() == -1) {
                continue;
            }
            i = secondNumber.index();
            result += (long) firstNumber.number() * secondNumber.number();
        }
        System.out.println("Day 3, part 1 answer = " + result);
    }

    private static NumberInLine checkForNumber(String line, int index, char endChar) {
        if (Character.isDigit(line.charAt(index))) {
            if (endChar == line.charAt(index + 1)) {
                return new NumberInLine(Integer.parseInt(line.substring(index, line.indexOf(endChar, index))),
                        index + 2);
            }
            if (Character.isDigit(line.charAt(index + 1))) {
                if (endChar == line.charAt(index + 2)) {
                    return new NumberInLine(Integer.parseInt(line.substring(index, line.indexOf(endChar, index + 1)))
                            , index + 3);
                }
                if (Character.isDigit(line.charAt(index + 2))) {
                    if (endChar == line.charAt(index + 3)) {
                        return new NumberInLine(Integer.parseInt(line.substring(index, line.indexOf(endChar,
                                index + 2))), index + 4);
                    }
                }
            }
        }
        return new NumberInLine(-1, index);
    }

}

record NumberInLine(int number, int index) {
}
