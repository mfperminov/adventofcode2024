package Day04;

import utils.Input;

public class Day04 {
    public static void main(String[] args) {
        partOne();
    }

    private static void partOne() {
        char[][] input = Input.readInputToCharArr("Day04");
        long result = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] == 'X') {
                    result += checkRight(input, i, j);
                    result += checkLeft(input, i, j);
                    result += checkTop(input, i, j);
                    result += checkDown(input, i, j);
                    result += checkDiagRightTop(input, i, j);
                    result += checkDiagLeftTop(input, i, j);
                    result += checkDiagRightDown(input, i, j);
                    result += checkDiagLeftDown(input, i, j);
                }
            }
        }
        System.out.println("Day 04 part 1 answer = " + result);
    }

    private static boolean exist(char[][] input, int i, int j, char ch) {
        return i >= 0 && i < input.length && j >= 0 && j < input[i].length && input[i][j] == ch;
    }

    private static long checkRight(char[][] input, int i, int j) {
        if (exist(input, i, j + 1, 'M') && exist(input, i, j + 2, 'A') && exist(input, i, j + 3, 'S')) {
            return 1L;
        } else {
            return 0L;
        }
    }

    private static long checkLeft(char[][] input, int i, int j) {
        if (exist(input, i, j - 1, 'M') && exist(input, i, j - 2, 'A') && exist(input, i, j - 3, 'S')) {
            return 1L;
        } else {
            return 0L;
        }
    }

    private static long checkTop(char[][] input, int i, int j) {
        if (exist(input, i - 1, j, 'M') && exist(input, i - 2, j, 'A') && exist(input, i - 3, j, 'S')) {
            return 1L;
        } else {
            return 0L;
        }
    }

    private static long checkDown(char[][] input, int i, int j) {
        if (exist(input, i + 1, j, 'M') && exist(input, i + 2, j, 'A') && exist(input, i + 3, j, 'S')) {
            return 1L;
        } else {
            return 0L;
        }
    }

    private static long checkDiagRightTop(char[][] input, int i, int j) {
        if (exist(input, i - 1, j + 1, 'M') && exist(input, i - 2, j + 2, 'A') && exist(input, i - 3, j + 3, 'S')) {
            return 1L;
        } else {
            return 0L;
        }
    }

    private static long checkDiagLeftTop(char[][] input, int i, int j) {
        if (exist(input, i - 1, j - 1, 'M') && exist(input, i - 2, j - 2, 'A') && exist(input, i - 3, j - 3, 'S')) {
            return 1L;
        } else {
            return 0L;
        }
    }

    private static long checkDiagRightDown(char[][] input, int i, int j) {
        if (exist(input, i + 1, j + 1, 'M') && exist(input, i + 2, j + 2, 'A') && exist(input, i + 3, j + 3, 'S')) {
            return 1L;
        } else {
            return 0L;
        }
    }

    private static long checkDiagLeftDown(char[][] input, int i, int j) {
        if (exist(input, i + 1, j - 1, 'M') && exist(input, i + 2, j - 2, 'A') && exist(input, i + 3, j - 3, 'S')) {
            return 1L;
        } else {
            return 0L;
        }
    }
}
