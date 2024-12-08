package Day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import utils.Input;

public class Day05 {
    public static void main(String[] args) {
        partOne();
    }

    private static void partOne() {
        var input = Input.readInput("Day05");
        int i = 0;
        HashMap<Integer, HashSet<Integer>> rules = new HashMap<>();
        while (!Objects.equals(input.get(i), "")) {
            var prev = Integer.parseInt(input.get(i).substring(0, 2));
            var next = Integer.parseInt(input.get(i).substring(3, 5));
            rules.compute(prev, (k, v) -> {
                if (v == null) {
                    var set = new HashSet<Integer>();
                    set.add(next);
                    return set;
                } else {
                    v.add(next);
                    return v;
                }
            });
            i++;
        }
        i++;
        var updates = new ArrayList<List<Integer>>(input.size() - i);
        for (int j = i; j < input.size(); j++) {
            updates.add(Arrays.stream(input.get(j).split(",")).map(Integer::parseInt).toList());
        }
        long result = 0;
        var rightOrder = false;
        for (var update : updates) {
            rightOrder = false;
            for (int j = update.size() - 1; j > 0; j--) {
                var rule = rules.get(update.get(j));
                if (rule == null) {
                    rule = new HashSet<Integer>();
                }
                rightOrder = Collections.disjoint(rule, update.subList(0, j));
                if (!rightOrder) {
                    break;
                }
            }
            if (rightOrder) {
                result += update.get(update.size() / 2);
            }
        }
        System.out.println("Day 05 part 1 answer = " + result);
    }
}
