public class Square {
    private boolean isAlive = false;
    private Square[] squareNeighbours = new Square[8]; // A list of Squares that neighbour this Square.

    public boolean getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void setSquareNeighbours(Square[] squareNeighbours) {
        this.squareNeighbours = squareNeighbours;
    }
}