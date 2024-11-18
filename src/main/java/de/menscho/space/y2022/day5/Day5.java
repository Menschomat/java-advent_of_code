package de.menscho.space.y2022.day5;

import de.menscho.space.utils.InputFileSize;
import de.menscho.space.utils.InputProvider;

import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collector;

public class Day5 {
    private static final int YEAR = 2022;
    private static final int DAY = 5;

    private static final Pattern USELESS_LINE_PATTERN = Pattern.compile("^\\s(\\d+\\s*)*");
    private static final Pattern MOVE_LINE_PATTERN = Pattern.compile("\\d+");
    private static final Pattern STACK_LINE_PATTERN = Pattern.compile("\\[\\w\\]|\\s{3,5}");

    public static String solutionPart1(InputFileSize aFileSize) {
        final SolverInput input = getSolverInput(YEAR, DAY, aFileSize);
        input.moves().forEach(aMove -> {
            for (int i = 0; i < aMove.count(); i++) {
                Character toMove = input.idToCharStack()
                        .get(aMove.source())
                        .pop();
                input.idToCharStack()
                        .get(aMove.target())
                        .push(toMove);
            }
        });
        return parseSolutionFromMap(input.idToCharStack());
    }


    public static String solutionPart2(InputFileSize aFileSize) {
        final SolverInput input = getSolverInput(YEAR, DAY, aFileSize);
        input.moves().forEach(aMove -> {
            List<Character> buffer = new ArrayList<>();
            for (int i = 0; i < aMove.count(); i++) {
                Character toMove = input.idToCharStack()
                        .get(aMove.source())
                        .pop();
                buffer.add(toMove);
            }
            Collections.reverse(buffer); //Reverse the list to add it original order to the stack
            input.idToCharStack().get(aMove.target()).addAll(buffer);
        });
        return parseSolutionFromMap(input.idToCharStack());
    }

    private static String parseSolutionFromMap(Map<Integer, Stack<Character>> aIdToCharStack) {
        return aIdToCharStack.values()
                .stream()
                .map(Stack::pop)
                .collect(Collector.of(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append,
                        StringBuilder::toString
                ));
    }

    private static SolverInput getSolverInput(int aYear, int aDay, InputFileSize aSize) {
        return getSolverInput(InputProvider.getInputLines(aYear, aDay, aSize));
    }

    private static SolverInput getSolverInput(List<String> aRawLines) {
        final Queue<Move> moves = new LinkedList<>();
        final Stack<String> stackLines = new Stack<>();
        for (String aRawLine : aRawLines) {
            if (aRawLine.isEmpty() || USELESS_LINE_PATTERN.matcher(aRawLine).matches()) continue;
            if (aRawLine.startsWith("move")) {
                moves.add(lineToMove(aRawLine));
                continue;
            }
            stackLines.push(aRawLine);
        }
        return new SolverInput(moves, stackLinesToMap(stackLines));
    }

    private static Move lineToMove(String aRawLine) {
        int[] rawMove = MOVE_LINE_PATTERN.matcher(aRawLine)
                .results().map(MatchResult::group)
                .mapToInt(Integer::parseInt)
                .toArray();
        return new Move(rawMove[0], rawMove[1], rawMove[2]);
    }

    private static Map<Integer, Stack<Character>> stackLinesToMap(Stack<String> aStackLines) {
        final Map<Integer, Stack<Character>> output = new HashMap<>();
        while (!aStackLines.isEmpty()) {
            final List<Character> stackLine = parseRawStackLine(aStackLines.pop());
            for (int i = 0; i < stackLine.size(); i++) {
                if (stackLine.get(i) == null)
                    continue;
                final Stack<Character> stack = output.getOrDefault(i + 1, new Stack<>());
                stack.push(stackLine.get(i));
                output.put(i + 1, stack);
            }
        }
        return output;
    }

    private static List<Character> parseRawStackLine(String aRawStackLine) {
        return STACK_LINE_PATTERN.matcher(aRawStackLine)
                .results().map(MatchResult::group)
                .map(a -> a.replaceAll("[^a-zA-Z]", ""))
                .map(a -> a.isEmpty() ? null : a.charAt(0))
                .toList();
    }
}
