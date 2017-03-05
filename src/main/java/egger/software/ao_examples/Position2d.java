package egger.software.ao_examples;

public class Position2d implements Position {

    private int x;
    private int y;

    public Position2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    public double distanceFrom(Position other) {
        if (!(other instanceof Position2d))
            throw new IllegalArgumentException("Can only compare Position2d");

        Position2d otherPosition2d = (Position2d) other;

        double deltaX = x - otherPosition2d.x;
        double deltaY = y - otherPosition2d.y;

        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Position2d other = (Position2d) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

}
