package de.menscho.space.y2022.day6;

import de.menscho.space.utils.InputFileSize;
import de.menscho.space.utils.InputProvider;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Day6 {

    private static final int YEAR = 2022;
    private static final int DAY = 6;

    public static long solutionPart1(InputFileSize fileSize) {
        return findIndexWithUniqueBuffer(fileSize, 4);
    }

    public static long solutionPart2(InputFileSize fileSize) {
        return findIndexWithUniqueBuffer(fileSize, 14);
    }

    private static long findIndexWithUniqueBuffer(InputFileSize fileSize, int bufferSize) {
        char[] chars = InputProvider.getInputString(YEAR, DAY, fileSize).toCharArray();
        Queue<Character> buffer = new LinkedList<>();

        for (int i = 0; i < chars.length; i++) {
            buffer.add(chars[i]);
            if (buffer.size() > bufferSize) {
                buffer.poll();
            }
            if (buffer.size() == bufferSize && buffer.size() == buffer.stream().distinct().count()) {
                return i + 1; // Return the position as 1-based index
            }
        }
        return -1;
    }
}
