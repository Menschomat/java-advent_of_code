package de.menscho.space.y2022.day4;

import de.menscho.space.utils.InputFileSize;
import de.menscho.space.y2022.day3.Day3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day4Test {

    @Test
    void solutionPart1Small() {
        long smallOut = Day4.solutionPart1(InputFileSize.SMALL);
        Assertions.assertEquals(2, smallOut);
    }

    @Test
    void solutionPart1Full() {
        long fullOut = Day4.solutionPart1(InputFileSize.FULL);
        Assertions.assertEquals(567, fullOut);
    }

    @Test
    void solutionPart2Small() {
        long smallOut = Day4.solutionPart2(InputFileSize.SMALL);
        Assertions.assertEquals(4, smallOut);
    }

    @Test
    void solutionPart2Full() {
        long fullOut = Day4.solutionPart2(InputFileSize.FULL);
        Assertions.assertEquals(907, fullOut);
    }
}