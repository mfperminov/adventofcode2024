package ru.mperminov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Input;

class InputTest {

    @Test
    void extractLongs() {
        var input = "9  40  200";
        var result = Input.extractLongs(input);
        Assertions.assertArrayEquals(new long[]{9, 40, 200}, result);
    }

    @Test
    void extractInts() {
        var input = "1,3,1,6";
        var result = Input.extractInts(input);
        Assertions.assertArrayEquals(new int[]{1, 3, 1, 6}, result);
    }
}