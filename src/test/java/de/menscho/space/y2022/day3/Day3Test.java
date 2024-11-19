package de.menscho.space.y2022.day3;

import de.menscho.space.utils.InputFileSize;
import de.menscho.space.y2022.day2.Day2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day3Test {

    @Test
    void solutionPart1Small() {
        int smallOut = Day3.solutionPart1(InputFileSize.SMALL);
        Assertions.assertEquals(157, smallOut);
    }

    @Test
    void solutionPart1Full() {
        int fullOut = Day3.solutionPart1(InputFileSize.FULL);
        Assertions.assertEquals(8493, fullOut);
    }

    @Test
    void solutionPart2Small() {
        int smallOut = Day3.solutionPart2(InputFileSize.SMALL);
        Assertions.assertEquals(70, smallOut);
    }

    @Test
    void solutionPart2Full() {
        int fullOut = Day3.solutionPart2(InputFileSize.FULL);
        Assertions.assertEquals(2552, fullOut);
    }
}