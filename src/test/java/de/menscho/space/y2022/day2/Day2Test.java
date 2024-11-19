package de.menscho.space.y2022.day2;

import de.menscho.space.utils.InputFileSize;
import de.menscho.space.y2022.day1.Day1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day2Test {

    @Test
    void solutionPart1Small() {
        int smallOut = Day2.solutionPart1(InputFileSize.SMALL);
        Assertions.assertEquals(15, smallOut);
    }

    @Test
    void solutionPart1Full() {
        int fullOut = Day2.solutionPart1(InputFileSize.FULL);
        Assertions.assertEquals(10718, fullOut);
    }

    @Test
    @Disabled("NOT IMPLEMENTED")
    void solutionPart2Small() {
        int smallOut = Day2.solutionPart2(InputFileSize.SMALL);
        Assertions.assertEquals(-1, smallOut);
    }

    @Test
    @Disabled("NOT IMPLEMENTED")
    void solutionPart2Full() {
        int fullOut = Day2.solutionPart2(InputFileSize.FULL);
        Assertions.assertEquals(-1, fullOut);
    }
}