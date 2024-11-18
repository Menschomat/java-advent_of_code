package de.menscho.space.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputProvider {
    public static List<String> getInputLines(String aPath) {
        List<String> output = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(aPath))) {
            output = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    public static List<String> getInputLines(int aYear, int aDay, InputFileSize aSize) {
        return getInputLines(String.format("etc/input/y%d/day%d/%s", aYear, aDay, aSize.filename));
    }

    public static String getInputString(String aPath) {
        try {
            return Files.readString(Path.of(aPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getInputString(int aYear, int aDay, InputFileSize aSize) {
        return getInputString(String.format("etc/input/y%d/day%d/%s", aYear, aDay, aSize.filename));
    }


}
