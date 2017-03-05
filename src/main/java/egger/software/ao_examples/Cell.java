package egger.software.ao_examples;

public class Cell {

    private boolean alive;
    private int livingNeighbours;
    private Position position;

    public Cell(Position position, boolean alive) {
        this.position = position;
        this.alive = alive;
    }

    public void setLivingNeighbours(int livingNeighbours) {
        this.livingNeighbours = livingNeighbours;
    }

    public void calculateNextGeneration() {
        if (alive) {
            if (!(livingNeighbours == 2 || livingNeighbours == 3)) {
                alive = false;
            }
        } else {
            if (livingNeighbours == 3) {
                alive = true;
            }
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public Position getPosition() {
        return position;
    }

}
