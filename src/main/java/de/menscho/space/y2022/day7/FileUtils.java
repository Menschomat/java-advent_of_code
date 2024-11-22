package de.menscho.space.y2022.day7;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUtils {
    private static final Pattern FILE_PATTERN = Pattern.compile("^(\\d+)\\s(.+)$");

    public static SysFile buildFileTree(List<String> rawInputLines) {
        if (rawInputLines == null || rawInputLines.isEmpty()) {
            throw new IllegalArgumentException("Input lines cannot be null or empty.");
        }
        SysFile rootDirectory = null;
        SysFile currentDirectory = null;
        for (String line : rawInputLines) {
            if (line.equals("$ cd /")) {
                rootDirectory = new SysFile("/", true);
                currentDirectory = rootDirectory;
                continue;
            }
            if (rootDirectory == null || currentDirectory == null) {
                throw new IllegalStateException("Root directory or current directory is not initialized.");
            }
            if (line.startsWith("$ cd")) {
                currentDirectory = processDirectoryCommand(line, currentDirectory);
            } else {
                processFileEntry(line, currentDirectory);
            }
        }
        return rootDirectory;
    }

    private static SysFile processDirectoryCommand(String command, SysFile currentDirectory) {
        if (command.equals("$ cd ..")) {
            return currentDirectory.getParent();
        }
        String directoryName = command.replace("$ cd", "").trim();
        SysFile newDirectory = new SysFile(directoryName, true);
        currentDirectory.add(newDirectory);
        return newDirectory;
    }

    private static void processFileEntry(String entry, SysFile currentDirectory) {
        Matcher matcher = FILE_PATTERN.matcher(entry);
        if (matcher.find()) {
            int fileSize = Integer.parseInt(matcher.group(1));
            String fileName = matcher.group(2);
            currentDirectory.add(new SysFile(fileName, false, fileSize));
        }
    }
}
