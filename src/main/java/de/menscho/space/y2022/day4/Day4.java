package de.menscho.space.y2022.day4;

import de.menscho.space.utils.InputFileSize;
import de.menscho.space.utils.InputProvider;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public abstract class Day4 {
    private static final int YEAR = 2022;
    private static final int DAY = 4;

    public static long solutionPart1(InputFileSize aFileSize) {
        return InputProvider.getInputLines(YEAR, DAY, aFileSize).stream()
                .map(aLine -> Arrays.stream(aLine.split(","))
                        .map(aS -> Arrays.stream(aS.split("-"))
                                .mapToInt(Integer::parseInt)
                                .toArray())
                        .sorted((a, b) -> (b[1] - b[0]) - (a[1] - a[0]))
                        .toList())
                .filter(aLine -> aLine.get(0)[0] <= aLine.get(1)[0])
                .filter(aLine -> aLine.get(0)[1] >= aLine.get(1)[1])
                .count();
    }

    public static long solutionPart2(InputFileSize aFileSize) {
        return InputProvider.getInputLines(YEAR, DAY, aFileSize).stream()
                .map(aLine -> Arrays.stream(aLine.split(","))
                        .map(aS -> Arrays.stream(aS.split("-"))
                                .mapToInt(Integer::parseInt)
                                .toArray())
                        .map(al -> IntStream.rangeClosed(al[0], al[1])
                                .boxed()
                                .toList()
                        ).toList()
                ).filter(a -> {
                    Set<Integer> intersection = new HashSet<Integer>(a.get(0)); // use the copy constructor
                    intersection.retainAll(a.get(1));
                    return !intersection.isEmpty();
                })
                .count();
    }
}
