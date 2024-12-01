package Day01;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import static utils.Input.extractInts;
import static utils.Input.readInput;
import static utils.Output.println;


public class Day01 {

    public static void main(String[] args) {
        partOne();
        partTwo();
    }

    private static void partOne() {
        var input = readInput("Day01");
        PriorityQueue<Integer> firstCol = new PriorityQueue<>(input.size());
        PriorityQueue<Integer> secCol = new PriorityQueue<>(input.size());
        for (String s : input) {
            int[] numbersPerLine = extractInts(s, " ");
            firstCol.offer(numbersPerLine[0]);
            secCol.offer(numbersPerLine[1]);
        }
        long sum = 0;
        for (int i = 0; i < input.size(); i++) {
            sum += Math.abs(firstCol.poll() - secCol.poll());
        }
        println("Day 1, part 1 answer = " + sum);
    }

    private static void partTwo() {
        var input = readInput("Day01");
        int[] firstCol = new int[input.size()];
        Map<Integer, Integer> secondColCountMap = new HashMap<>(input.size());
        for (int i = 0; i < input.size(); i++) {
            int[] numbersPerLine = extractInts(input.get(i), " ");
            firstCol[i] = numbersPerLine[0];
            secondColCountMap.compute(numbersPerLine[1], (k, v) -> (v == null) ? 1 : v + 1);
        }
        long similarityScore = 0;
        for (int i = 0; i < input.size(); i++) {
            similarityScore += (long) firstCol[i] * secondColCountMap.getOrDefault(firstCol[i], 0);
        }
        println("Day 1, part 2 answer = " + similarityScore);
    }

}
