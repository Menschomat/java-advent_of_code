package de.menscho.space.y2022.day5;

import de.menscho.space.utils.InputFileSize;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day5Test {

    @Test
    void solutionPart1Small() {
        String smallOut = Day5.solutionPart1(InputFileSize.SMALL);
        Assertions.assertEquals("CMZ", smallOut);
    }

    @Test
    void solutionPart1Full() {
        String fullOut = Day5.solutionPart1(InputFileSize.FULL);
        Assertions.assertEquals("TLFGBZHCN", fullOut);
    }

    @Test
    void solutionPart2Small() {
        String smallOut = Day5.solutionPart2(InputFileSize.SMALL);
        Assertions.assertEquals("MCD", smallOut);
    }

    @Test
    void solutionPart2Full() {
        String fullOut = Day5.solutionPart2(InputFileSize.FULL);
        Assertions.assertEquals("QRQFHFWCL", fullOut);
    }
}