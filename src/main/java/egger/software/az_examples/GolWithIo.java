package egger.software.az_examples;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GolWithIo {

    public static void main(String[] args) {
        File gameField = new File("src/main/java/egger/software/az_examples/gamefield.txt");

        List<Cell> cells = new ArrayList<>();
        int row = 0;
        try (BufferedReader gameFieldReader = new BufferedReader(new InputStreamReader(new FileInputStream(gameField)))) {
            String line;
            while ((line = gameFieldReader.readLine()) != null) {
                parseLine(line, cells, row);
                row++;
            }
            Game game = new Game(cells);
            printCells(cells);
            for (int idx = 0; idx < 10; idx++) {
                game.calculateNextGeneration();
                printCells(cells);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find: " + gameField.getPath());
        } catch (IOException | InvalidCellRuntimeException e) {
            System.out.println("Error reading: " + gameField.getPath() + " -> " + e.getMessage());
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


    public static void parseLine(String line, List<Cell> cells, int row) {
        String[] cellStrings = line.trim().split(" ");
        for (int column = 0; column < cellStrings.length; column++) {
            boolean alive;

            if (cellStrings[column].equals("0"))
                alive = false;
            else if (cellStrings[column].equals("1"))
                alive = true;
            else
                throw new InvalidCellRuntimeException("Row: " + row + ", column: " + column);

            Cell cell = new Cell(new Position2d(row, column), alive);
            cells.add(cell);
        }
    }


}
