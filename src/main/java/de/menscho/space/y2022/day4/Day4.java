package de.menscho.space.y2022.day4;

import de.menscho.space.utils.InputFileSize;
import de.menscho.space.utils.InputProvider;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class Day4 {

    private static final int YEAR = 2022;
    private static final int DAY = 4;

    public static long solutionPart1(InputFileSize fileSize) {
        return InputProvider.getInputLines(YEAR, DAY, fileSize).stream()
                .map(Day4::parseLineToRanges)
                .filter(Day4::isFullyContained)
                .count();
    }

    public static long solutionPart2(InputFileSize fileSize) {
        return InputProvider.getInputLines(YEAR, DAY, fileSize).stream()
                .map(Day4::parseLineToRangeSets)
                .filter(Day4::hasOverlap)
                .count();
    }


    private static List<int[]> parseLineToRanges(String line) {
        return Arrays.stream(line.split(","))
                .map(range -> Arrays.stream(range.split("-"))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .sorted((range1, range2) ->
                        Integer.compare(range2[1] - range2[0], range1[1] - range1[0]))
                .toList();
    }

    private static List<Set<Integer>> parseLineToRangeSets(String line) {
        return parseLineToRanges(line).stream()
                .map(range -> IntStream.rangeClosed(range[0], range[1])
                        .boxed()
                        .collect(Collectors.toSet()))
                .toList();
    }

    private static boolean isFullyContained(List<int[]> ranges) {
        int[] firstRange = ranges.get(0);
        int[] secondRange = ranges.get(1);
        return firstRange[0] <= secondRange[0] && firstRange[1] >= secondRange[1];
    }

    private static boolean hasOverlap(List<Set<Integer>> rangeSets) {
        Set<Integer> intersection = new HashSet<>(rangeSets.get(0));
        intersection.retainAll(rangeSets.get(1));
        return !intersection.isEmpty();
    }
}