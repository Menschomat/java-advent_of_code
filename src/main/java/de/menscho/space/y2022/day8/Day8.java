package de.menscho.space.y2022.day8;

import de.menscho.space.utils.InputFileSize;
import de.menscho.space.utils.InputProvider;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public abstract class Day8 {

    private static final int YEAR = 2022;
    private static final int DAY = 8;

    public static long solutionPart1(InputFileSize fileSize) {
        List<List<Integer>> grid = InputProvider.getInputLines(YEAR, DAY, fileSize)
                .stream()
                .map(line -> line.chars()
                        .map(c -> c - '0') // Convert character digits to integers
                        .boxed()
                        .toList())
                .toList();

        int rowCount = grid.size();
        int colCount = grid.get(0).size();
        int treeCounter = 0;

        // Iterate through each tree in the grid
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (hasClearLineOfSight(grid, i, j)) {
                    treeCounter++;
                }
            }
        }

        return treeCounter;
    }

    // Helper method to check if there's a clear line of sight in any direction
    private static boolean hasClearLineOfSight(List<List<Integer>> grid, int i, int j) {
        int currentTree = grid.get(i).get(j);
        int rowCount = grid.size();
        int colCount = grid.getFirst().size();

        // Define direction offsets: (rowDelta, colDelta)
        int[][] directions = {
                {0, -1}, // Left
                {0, 1},  // Right
                {-1, 0}, // Up
                {1, 0}   // Down
        };

        // Check visibility in each direction
        for (int[] direction : directions) {
            if (isDirectionClear(grid, i, j, currentTree, direction, rowCount, colCount)) {
                return true; // At least one direction is clear
            }
        }

        return false;
    }

    // Generic method to check if a direction is clear
    private static boolean isDirectionClear(List<List<Integer>> grid, int startRow, int startCol, int currentTree,
                                            int[] direction, int rowCount, int colCount) {
        int rowDelta = direction[0];
        int colDelta = direction[1];
        int row = startRow + rowDelta;
        int col = startCol + colDelta;
        // Traverse in the direction until hitting the edge
        while (row >= 0 && row < rowCount && col >= 0 && col < colCount) {
            if (grid.get(row).get(col) >= currentTree) {
                return false; // Blocked by a taller or equal tree
            }
            row += rowDelta;
            col += colDelta;
        }
        return true; // No taller trees found
    }

    public static long solutionPart2(InputFileSize fileSize) {
        return 0;
    }
}
