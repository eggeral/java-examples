package egger.software.ao_examples;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Cell> cells = Arrays.asList(
//0
                new Cell(new Position2d(0, 0), false),
                new Cell(new Position2d(0, 1), false),
                new Cell(new Position2d(0, 2), false),
                new Cell(new Position2d(0, 3), false),
                new Cell(new Position2d(0, 4), false),
                new Cell(new Position2d(0, 5), false),
                new Cell(new Position2d(0, 6), false),
                new Cell(new Position2d(0, 7), false),
//1
                new Cell(new Position2d(1, 0), false),
                new Cell(new Position2d(1, 1), false),
                new Cell(new Position2d(1, 2), false),
                new Cell(new Position2d(1, 3), true),
                new Cell(new Position2d(1, 4), true),
                new Cell(new Position2d(1, 5), true),
                new Cell(new Position2d(1, 6), false),
                new Cell(new Position2d(1, 7), false),
//2
                new Cell(new Position2d(2, 0), false),
                new Cell(new Position2d(2, 1), false),
                new Cell(new Position2d(2, 2), false),
                new Cell(new Position2d(2, 3), false),
                new Cell(new Position2d(2, 4), true),
                new Cell(new Position2d(2, 5), false),
                new Cell(new Position2d(2, 6), false),
                new Cell(new Position2d(2, 7), false),
//3
                new Cell(new Position2d(3, 0), false),
                new Cell(new Position2d(3, 1), false),
                new Cell(new Position2d(3, 2), false),
                new Cell(new Position2d(3, 3), false),
                new Cell(new Position2d(3, 4), false),
                new Cell(new Position2d(3, 5), false),
                new Cell(new Position2d(3, 6), false),
                new Cell(new Position2d(3, 7), false),
//4
                new Cell(new Position2d(4, 0), false),
                new Cell(new Position2d(4, 1), false),
                new Cell(new Position2d(4, 2), false),
                new Cell(new Position2d(4, 3), false),
                new Cell(new Position2d(4, 4), false),
                new Cell(new Position2d(4, 5), false),
                new Cell(new Position2d(4, 6), false),
                new Cell(new Position2d(4, 7), false),
//5
                new Cell(new Position2d(5, 0), false),
                new Cell(new Position2d(5, 1), false),
                new Cell(new Position2d(5, 2), true),
                new Cell(new Position2d(5, 3), true),
                new Cell(new Position2d(5, 4), true),
                new Cell(new Position2d(5, 5), false),
                new Cell(new Position2d(5, 6), false),
                new Cell(new Position2d(5, 7), false),
//6
                new Cell(new Position2d(6, 0), false),
                new Cell(new Position2d(6, 1), false),
                new Cell(new Position2d(6, 2), false),
                new Cell(new Position2d(6, 3), false),
                new Cell(new Position2d(6, 4), false),
                new Cell(new Position2d(6, 5), false),
                new Cell(new Position2d(6, 6), false),
                new Cell(new Position2d(6, 7), false),
//7
                new Cell(new Position2d(7, 0), false),
                new Cell(new Position2d(7, 1), false),
                new Cell(new Position2d(7, 2), false),
                new Cell(new Position2d(7, 3), false),
                new Cell(new Position2d(7, 4), false),
                new Cell(new Position2d(7, 5), false),
                new Cell(new Position2d(7, 6), false),
                new Cell(new Position2d(7, 7), false)
        );

        Game game = new Game(cells);

        for (int i = 0; i < 20; i++) {
            printCells(cells);
            game.calculateNextGeneration();
        }
    }

    private static void printCells(List<Cell> cells) {
        System.out.println("=======================");
        for (int i = 0; i < cells.size(); i++) {
            System.out.print(cells.get(i).isAlive() ? 1 : 0);
            System.out.print(" ");
            if ((i + 1) % 8 == 0)
                System.out.println();

        }
    }
}
