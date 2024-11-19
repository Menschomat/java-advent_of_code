package de.menscho.space.y2022.day3;

import de.menscho.space.utils.InputFileSize;
import de.menscho.space.utils.InputProvider;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public abstract class Day3 {
    private static final int YEAR = 2022;
    private static final int DAY = 3;

    public static int solutionPart1(InputFileSize aFileSize) {
        return InputProvider.getInputLines(YEAR, DAY, aFileSize)
                .stream()
                .map(Day3::buildBackpack)
                .map(Day3::getIntersection)
                .flatMap(Collection::stream)
                .mapToInt(Day3::getCharPrio)
                .sum();
    }

    public static int solutionPart2(InputFileSize aFileSize) {
        return prepareChunks(InputProvider.getInputLines(YEAR, DAY, aFileSize), 3)
                .stream()
                .map(aChunk -> aChunk.stream()
                        .map(Day3::getCharSet).toList())
                .map(Day3::getIntersection)
                .flatMap(Collection::stream)
                .mapToInt(Day3::getCharPrio)
                .sum();
    }

    public static <T> Set<T> getIntersection(List<Set<T>> sets) {
        return sets.stream()
                .reduce((set1, set2) -> {
                    set1.retainAll(set2);
                    return set1;
                })
                .orElse(Collections.emptySet()); // Return an empty set if no sets provided
    }

    public static List<Set<Character>> buildBackpack(String aInStr) {
        final int midpoint = aInStr.length() / 2;
        return List.of(getCharSet(aInStr.substring(0, midpoint)), getCharSet(aInStr.substring(midpoint)));
    }

    public static Set<Character> getCharSet(String input) {
        return input.chars()
                .mapToObj(c -> (char) c) // Convert int to char
                .collect(Collectors.toSet());
    }

    public static int getCharPrio(char aChar) {
        if (aChar >= 'a' && aChar <= 'z') {
            // Convert 'a' to 'z' into 1 to 26
            return aChar - 'a' + 1;
        } else if (aChar >= 'A' && aChar <= 'Z') {
            // Convert 'A' to 'Z' into 27 to 52
            return aChar - 'A' + 27;
        } else {
            throw new IllegalArgumentException("Character must be a-z or A-Z");
        }
    }

    public static <T> Collection<List<T>> prepareChunks(List<T> inputList, int chunkSize) {
        AtomicInteger counter = new AtomicInteger();
        return inputList.stream().collect(Collectors.groupingBy(it -> counter.getAndIncrement() / chunkSize)).values();
    }

}
