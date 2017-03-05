package egger.software.ao_examples;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Cell cell;

        System.out.println("== Cell ==");
        System.out.println("1. Any live cell with fewer than two live neighbours dies, as if caused by under-population.");
        //given
        cell = new Cell(new Position2d(0, 1), true);
        cell.setLivingNeighbours(1);

        //when
        cell.calculateNextGeneration();

        //then
        System.out.println("Cell is alive: " + cell.isAlive());

        System.out.println("2. Any live cell with two or three live neighbours lives on to the next generation.");
        //given
        cell = new Cell(new Position2d(0, 1), true);
        cell.setLivingNeighbours(2);

        //when
        cell.calculateNextGeneration();

        //then
        System.out.println("Cell is alive: " + cell.isAlive());

        //given
        cell = new Cell(new Position2d(0, 1), true);
        cell.setLivingNeighbours(3);

        //when
        cell.calculateNextGeneration();

        //then
        System.out.println("Cell is alive: " + cell.isAlive());

        System.out.println("3. Any live cell with more than three live neighbours dies, as if by over-population.");

        //given
        cell = new Cell(new Position2d(0, 1), true);
        cell.setLivingNeighbours(4);

        //when
        cell.calculateNextGeneration();

        //then
        System.out.println("Cell is alive: " + cell.isAlive());

        System.out.println("4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.");
        //given
        cell = new Cell(new Position2d(0, 1), false);
        cell.setLivingNeighbours(3);

        //when
        cell.calculateNextGeneration();

        //then
        System.out.println("Cell is alive: " + cell.isAlive());

        System.out.println("5. Any dead cell with less than three live neighbours stays dead.");

        //given
        cell = new Cell(new Position2d(0, 1), false);
        cell.setLivingNeighbours(2);

        //when
        cell.calculateNextGeneration();

        //then
        System.out.println("Cell is alive: " + cell.isAlive());


        System.out.println("== Position ==");
        System.out.println(new Position2d(1, 1) + " distance from " + new Position2d(1, 1) + " is: " +
                new Position2d(1, 1).distanceFrom(new Position2d(1, 1)));
        System.out.println(new Position2d(1, 1) + " distance from " + new Position2d(2, 1) + " is: " +
                new Position2d(1, 1).distanceFrom(new Position2d(2, 1)));


        System.out.println("== Game ==");


        //given
        // 1 1 1
        // 0 0 0
        List<Cell> cells = new ArrayList<Cell>();

        cells.add(new Cell(new Position2d(0, 0), true));
        cells.add(new Cell(new Position2d(0, 1), true));
        cells.add(new Cell(new Position2d(0, 2), true));
        cells.add(new Cell(new Position2d(1, 0), false));
        cells.add(new Cell(new Position2d(1, 1), false));
        cells.add(new Cell(new Position2d(1, 2), false));


        Game game = new Game(cells);

        //when
        game.calculateNextGeneration();

        //then
        // 0 1 0
        // 0 1 0
        System.out.println("Cell 0 0 is: " + cells.get(0).isAlive());
        System.out.println("Cell 0 1 is: " + cells.get(1).isAlive());
        System.out.println("Cell 0 2 is: " + cells.get(2).isAlive());
        System.out.println("Cell 1 0 is: " + cells.get(3).isAlive());
        System.out.println("Cell 1 1 is: " + cells.get(4).isAlive());
        System.out.println("Cell 1 2 is: " + cells.get(5).isAlive());


        System.out.println("== Cell 3d ==");
        //given
        cell = new Cell(new Position3d(0, 0, 0), false);
        cell.setLivingNeighbours(3);

        //when
        cell.calculateNextGeneration();

        //then
        System.out.println("Cell is alive: " + cell.isAlive());


        System.out.println("== Game 3d ==");

        //given
        // 1 1 1 | 0 0 0
        // 0 0 0 | 0 0 0
        cells = new ArrayList<>();

        cells.add(new Cell(new Position3d(0, 0, 0), true));
        cells.add(new Cell(new Position3d(0, 1, 0), true));
        cells.add(new Cell(new Position3d(0, 2, 0), true));
        cells.add(new Cell(new Position3d(1, 0, 0), false));
        cells.add(new Cell(new Position3d(1, 1, 0), false));
        cells.add(new Cell(new Position3d(1, 2, 0), false));

        cells.add(new Cell(new Position3d(0, 0, 1), false));
        cells.add(new Cell(new Position3d(0, 1, 1), false));
        cells.add(new Cell(new Position3d(0, 2, 1), false));
        cells.add(new Cell(new Position3d(1, 0, 1), false));
        cells.add(new Cell(new Position3d(1, 1, 1), false));
        cells.add(new Cell(new Position3d(1, 2, 1), false));

        game = new Game(cells);

        //when
        game.calculateNextGeneration();

        //then
        // 0 1 0 | 0 1 0
        // 0 1 0 | 0 1 0
        System.out.println("Cell 0 0 0 is: " + cells.get(0).isAlive());
        System.out.println("Cell 0 1 0 is: " + cells.get(1).isAlive());
        System.out.println("Cell 0 2 0 is: " + cells.get(2).isAlive());
        System.out.println("Cell 1 0 0 is: " + cells.get(3).isAlive());
        System.out.println("Cell 1 1 0 is: " + cells.get(4).isAlive());
        System.out.println("Cell 1 2 0 is: " + cells.get(5).isAlive());

        System.out.println("Cell 0 0 1 is: " + cells.get(6).isAlive());
        System.out.println("Cell 0 1 1 is: " + cells.get(7).isAlive());
        System.out.println("Cell 0 2 1 is: " + cells.get(8).isAlive());
        System.out.println("Cell 1 0 1 is: " + cells.get(9).isAlive());
        System.out.println("Cell 1 1 1 is: " + cells.get(10).isAlive());
        System.out.println("Cell 1 2 1 is: " + cells.get(11).isAlive());

    }
}
