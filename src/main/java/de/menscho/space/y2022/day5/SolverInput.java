package de.menscho.space.y2022.day5;

import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public record SolverInput(Queue<Move> moves, Map<Integer, Stack<Character>> idToCharStack) {

}
