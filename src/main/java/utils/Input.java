package utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Input {

    public static List<String> readInput(String name) {
        try {
            return Files.readAllLines(Paths.get("src/main/resources/" + name), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return Collections.emptyList();
    }

    public static long[] extractLongs(String line) {
        return Arrays.stream(line.split(" "))
                .filter(s -> !s.isBlank())
                .mapToLong(Long::valueOf)
                .toArray();
    }

    public static int[] extractInts(String line) {
        return extractInts(line, ",");
    }

    public static int[] extractInts(String line, String sep) {
        return Arrays.stream(line.split(sep))
                .filter(s -> !s.isBlank())
                .mapToInt(Integer::valueOf)
                .toArray();
    }
}
