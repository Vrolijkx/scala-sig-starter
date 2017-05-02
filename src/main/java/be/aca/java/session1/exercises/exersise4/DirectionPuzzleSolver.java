package be.aca.java.session1.exercises.exersise4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class DirectionPuzzleSolver {

    public static void main(String[] args) {
        DirectionPuzzleSolver solver = new DirectionPuzzleSolver();
        System.out.println(solver.solve(new ExamplePuzzleInput()));
    }

    private Direction getNewDirection(Direction current, Rotation r) {
        if(r == Rotation.LEFT) {
            switch (current) {
                case NORTH:
                    return Direction.WEST;
                case SOUTH:
                    return Direction.EAST;
                case WEST:
                    return Direction.SOUTH;
                case EAST:
                    return Direction.NORTH;
            }
        } else {
            switch (current) {
                case NORTH:
                    return Direction.EAST;
                case SOUTH:
                    return Direction.WEST;
                case WEST:
                    return Direction.NORTH;
                case EAST:
                    return Direction.SOUTH;
            }
        }
        System.out.println("No change");
        return current;
    }

    public String solve(PuzzleInput puzzleInput) {
        List<Step> steps = parseToSteps(puzzleInput);

        Position pos = new Position(0,0);
        Direction dir = Direction.NORTH;

        List<Position> history = new LinkedList<>();
        history.add(pos);
        Position revisitedFirst = null;

        for(Step s : steps) {
            dir = getNewDirection(dir, s.getRotation());
            for(int i = 0; i < s.getAmount(); i++){
                pos = new Position(pos.getX() + dir.getX(), pos.getY() + dir.getY());
                if(revisitedFirst == null && history.contains(pos)) {
                    revisitedFirst = pos;
                }
                history.add(pos);

            }
        }

        return "End pos: " + pos + " distance " + getTaxiDistance(pos) + " first revisit " + revisitedFirst + " distance " + getTaxiDistance(revisitedFirst);
    }

    private List<Step> parseToSteps(PuzzleInput puzzleInput) {
        List<Step> steps = new ArrayList<Step>();

        for (String direction : puzzleInput.getDirections()) {
            Rotation rotation = direction.charAt(0) == 'L' ? Rotation.LEFT : Rotation.RIGHT;
            Integer distance = Integer.parseInt(direction.substring(1));

            steps.add(new Step(rotation, distance));
        }

        return steps;
    }

    private int getTaxiDistance(Position pos) {
        return Math.abs(pos.getX()) + Math.abs(pos.getY());
    }
}
