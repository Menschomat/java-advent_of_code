package de.menscho.space.y2022.day7;

import de.menscho.space.utils.InputFileSize;
import de.menscho.space.utils.InputProvider;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static de.menscho.space.y2022.day7.FileUtils.buildFileTree;

public abstract class Day7 {

    private static final int YEAR = 2022;
    private static final int DAY = 7;

    private static final int DISK_SIZE = 70_000_000;
    private static final int NEEDED_SPACE = 30_000_000;
    private static final int MAX_USABLE = DISK_SIZE - NEEDED_SPACE;
    private static final int MAX_DIR_SIZE = 100_000;

    public static long solutionPart1(InputFileSize fileSize) {
        SysFile rootDirectory = buildFileTree(InputProvider.getInputLines(YEAR, DAY, fileSize));
        return rootDirectory.flatten()
                .mapToLong(SysFile::getSize)
                .filter(size -> size <= MAX_DIR_SIZE)
                .sum();
    }

    public static long solutionPart2(InputFileSize fileSize) {
        SysFile rootDirectory = buildFileTree(InputProvider.getInputLines(YEAR, DAY, fileSize));
        List<SysFile> directories = rootDirectory.flatten()
                .filter(SysFile::isDirectory)
                .sorted(Comparator.comparing(SysFile::getSize))
                .toList();

        final long neededSpace = MAX_USABLE - directories.getLast().getSize();

        return directories.stream()
                .filter(dir -> neededSpace + dir.getSize() >= 0) //plus because neededSpace will be negative
                .min(Comparator.comparing(SysFile::getSize))
                .orElseThrow(() -> new IllegalStateException("No suitable directory found"))
                .getSize();
    }
}
