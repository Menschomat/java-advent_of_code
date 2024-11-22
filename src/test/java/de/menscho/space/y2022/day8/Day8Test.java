package de.menscho.space.y2022.day8;

import de.menscho.space.utils.InputFileSize;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class Day8Test {

    @Test
    void solutionPart1Small() {
        long smallOut = Day8.solutionPart1(InputFileSize.SMALL);
        Assertions.assertEquals(21, smallOut);
    }

    @Test
    void solutionPart1Full() {
        long fullOut = Day8.solutionPart1(InputFileSize.FULL);
        Assertions.assertEquals(1679, fullOut);
    }

    @Test
    @Disabled
    void solutionPart2Small() {
        long smallOut = Day8.solutionPart2(InputFileSize.SMALL);
        Assertions.assertEquals(24933642, smallOut);
    }

    @Test
    @Disabled
    void solutionPart2Full() {
        long fullOut = Day8.solutionPart2(InputFileSize.FULL);
        Assertions.assertEquals(272298, fullOut);
    }
}