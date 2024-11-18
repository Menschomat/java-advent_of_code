package de.menscho.space.y2022.day1;

import de.menscho.space.utils.InputFileSize;
import de.menscho.space.utils.InputProvider;

import java.util.Arrays;

public class Day1 {
    private static final int YEAR = 2022;
    private static final int DAY = 1;

    public static int solutionPart1(InputFileSize aFileSize) {
        final String inputString = InputProvider.getInputString(YEAR, DAY, aFileSize);
        return Arrays.stream(inputString.split("(\\n|\\r\\n){2}"))
                .mapToInt(aElveStr -> Arrays.stream(aElveStr.split("\\n|\\r\\n"))
                        .mapToInt(Integer::parseInt)
                        .sum())
                .max().orElse(0);
    }

    public static int solutionPart2(InputFileSize aFileSize) {
        final String inputString = InputProvider.getInputString(YEAR, DAY, aFileSize);
        return Arrays.stream(inputString.split("(\\n|\\r\\n){2}"))
                .mapToInt(aElveStr -> -Arrays.stream(aElveStr.split("\\n|\\r\\n"))
                        .mapToInt(Integer::parseInt)
                        .sum())
                .sorted()
                .limit(3)
                .map(i -> -i)
                .sum();
    }
}
