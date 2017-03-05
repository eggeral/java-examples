package egger.software.ao_examples;

import java.util.List;

public class Game {
    private List<Cell> cells;

    public Game(List<Cell> cells) {
        this.cells = cells;
    }

    public void calculateNextGeneration() {
        for (Cell cell : cells) {
            int numberOfLivingNeighbours = 0;
            for (Cell potentialNeighbour : cells) {
                double distance = cell.getPosition().distanceFrom(potentialNeighbour.getPosition());
                if (potentialNeighbour.isAlive() && distance > 0 && distance < 2.0)
                    numberOfLivingNeighbours ++;
            }
            cell.setLivingNeighbours(numberOfLivingNeighbours);
        }

        for (Cell cell : cells) {
            cell.calculateNextGeneration();
        }
    }

}
