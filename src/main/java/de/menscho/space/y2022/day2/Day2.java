package de.menscho.space.y2022.day2;

import de.menscho.space.utils.InputFileSize;
import de.menscho.space.utils.InputProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Day2 {
    private static final int YEAR = 2022;
    private static final int DAY = 2;

    static final List<Character> opponent = List.of('A', 'B', 'C');
    static final List<Character> player = List.of('X', 'Y', 'Z');

    public static int solutionPart1(InputFileSize aFileSize) {
        final List<char[]> input = InputProvider.getInputLines(YEAR, DAY, aFileSize)
                .stream()
                .map(aLine -> aLine.replace(" ", ""))
                .map(String::toCharArray)
                .toList();
        int score = 0;
        for (char[] round : input) {
            final int opponentVal = opponent.indexOf(round[0]);
            final int playerVal = player.indexOf(round[1]);
            /*
            Calculate match result using modulo:
                The modulo operation captures this cyclic nature of the relationship:
                - Subtracting two indices (e.g., playerVal - opponentVal) gives a raw difference.
                - Adding 3 ensures the difference is non-negative, even for cases like playerVal = 0 and opponentVal = 2 (to handle wrap-around cases).
                - Taking the result modulo 3 reduces it to one of three possible values (0, 1, or 2) that represent draw, win, or loss, respectively.
             */
            final int matchVal = (playerVal - opponentVal + 3) % 3; // Normalize to [0, 1, 2]
            score += playerVal + new int[]{4, 7, 1}[matchVal];
        }
        return score;
    }

    public static int solutionPart2(InputFileSize aFileSize) {
        final List<char[]> input = InputProvider.getInputLines(YEAR, DAY, aFileSize)
                .stream()
                .map(aLine -> aLine.replace(" ", ""))
                .map(String::toCharArray)
                .toList();
        int score = 0;
        for (char[] round : input) {
            final int opponentVal = opponent.indexOf(round[0]);
            final int matchVal = player.indexOf(round[1]);
            final int playerVal = (opponentVal + matchVal - 1 + 3) % 3;
            score += playerVal + new int[]{1, 4, 7}[matchVal];
        }
        return score;
    }
}
