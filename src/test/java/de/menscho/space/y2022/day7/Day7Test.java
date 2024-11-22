package de.menscho.space.y2022.day7;

import de.menscho.space.utils.InputFileSize;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day7Test {

    @Test
    void solutionPart1Small() {
        long smallOut = Day7.solutionPart1(InputFileSize.SMALL);
        Assertions.assertEquals(95437, smallOut);
    }

    @Test
    void solutionPart1Full() {
        long fullOut = Day7.solutionPart1(InputFileSize.FULL);
        Assertions.assertEquals(1432936, fullOut);
    }

    @Test
    void solutionPart2Small() {
        long smallOut = Day7.solutionPart2(InputFileSize.SMALL);
        Assertions.assertEquals(24933642, smallOut);
    }

    @Test
    void solutionPart2Full() {
        long fullOut = Day7.solutionPart2(InputFileSize.FULL);
        Assertions.assertEquals(272298, fullOut);
    }
}