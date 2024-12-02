package Day02;

import utils.Input;

import static utils.Input.readInput;


public class Day02 {

    public static void main(String[] args) {
        partOne();
        partTwo();
    }

    private static void partOne() {
        var reports = readInput("Day02");
        var safeCount = 0;
        for (String report : reports) {
            var levels = Input.extractInts(report, " ");
            safeCount += checkSafe(levels);
        }
        System.out.println("Day 2, part 1 answer = " + safeCount);
    }

    private static int checkSafe(int[] levels) {
        if (levels[1] == levels[0] || Math.abs(levels[1] - levels[0]) > 3) {
            return 0;
        }
        var isIncreasing = (levels[1] - levels[0]) > 0;
        for (int i = 1; i < levels.length - 1; i++) {
            var current = levels[i];
            var next = levels[i + 1];
            if ((next - current >= 1 && next - current <= 3 && isIncreasing)
                    || (current - next >= 1 && current - next <= 3 && !isIncreasing)
            ) {
                continue;
            } else {
                return 0;
            }
        }
        return 1;
    }

    private static void partTwo() {
        var reports = readInput("Day02");
        var safeCount = 0;
    }

}
