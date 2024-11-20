package de.menscho.space.y2022.day6;

import de.menscho.space.utils.InputFileSize;
import de.menscho.space.y2022.day4.Day4;
import de.menscho.space.y2022.day5.Day5;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day6Test {

    @Test
    void solutionPart1Small() {
        long smallOut = Day6.solutionPart1(InputFileSize.SMALL);
        Assertions.assertEquals(5, smallOut);
    }

    @Test
    void solutionPart1Full() {
        long fullOut = Day6.solutionPart1(InputFileSize.FULL);
        Assertions.assertEquals(1480, fullOut);
    }

    @Test
    void solutionPart2Small() {
        long smallOut = Day6.solutionPart2(InputFileSize.SMALL);
        Assertions.assertEquals(23, smallOut);
    }

    @Test
    void solutionPart2Full() {
        long fullOut = Day6.solutionPart2(InputFileSize.FULL);
        Assertions.assertEquals(2746, fullOut);
    }
}