package banana.chess.Figures;

public class Position {
    private int positionX;
    private int positionY;
    private final int maxX = 7;
    private final int maxY = 7;
    private final int minX = 0;
    private final int minY = 0;
    private boolean isValid = true;

    public PositionState getState() {
        return state;
    }

    public void setState(PositionState state) {
        this.state = state;
    }

    private PositionState state = null;

    public boolean isValid() {
        return isValid;
    }

    public Position(int positionX, int positionY) {
        if ((positionX >= minX & positionY >= minY) & (positionX <= maxX & positionY <= maxY)) {
            this.positionX = positionX;
            this.positionY = positionY;
        } else {
            this.isValid = false;
        }
    }

    public Position(int positionX, int positionY, PositionState state) {
        if ((positionX >= minX & positionY >= minY) & (positionX <= maxX & positionY <= maxY)) {
            this.positionX = positionX;
            this.positionY = positionY;
        } else {
            this.isValid = false;
        }
        this.state = state;
    }

    public void setPositionX(int positionX) {
        if (positionX >= minX & positionX <= maxX) {
            this.positionX = positionX;
        } else {
            this.isValid = false;
        }
    }

    public void setPositionY(int positionY) {
        if (positionY >= minY & positionY <= maxY) {
            this.positionY = positionY;
        } else {
            this.isValid = false;
        }
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
}
