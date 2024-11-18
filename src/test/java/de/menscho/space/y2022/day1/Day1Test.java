package de.menscho.space.y2022.day1;

import de.menscho.space.utils.InputFileSize;
import de.menscho.space.y2022.day5.Day5;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day1Test {

    @Test
    void solutionPart1Small() {
        int smallOut = Day1.solutionPart1(InputFileSize.SMALL);
        Assertions.assertEquals(24000, smallOut);
    }

    @Test
    void solutionPart1Full() {
        int fullOut = Day1.solutionPart1(InputFileSize.FULL);
        Assertions.assertEquals(71780, fullOut);
    }

    @Test
    void solutionPart2Small() {
        int smallOut = Day1.solutionPart2(InputFileSize.SMALL);
        Assertions.assertEquals(45000, smallOut);
    }

    @Test
    void solutionPart2Full() {
        int fullOut = Day1.solutionPart2(InputFileSize.FULL);
        Assertions.assertEquals(212489, fullOut);
    }
}