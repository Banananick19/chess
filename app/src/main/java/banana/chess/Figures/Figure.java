package banana.chess.Figures;

import java.util.Iterator;

import banana.chess.ChessBoard;

abstract public class Figure {
    protected int positionX;
    protected int positionY;
    protected FigureColor color;
    protected String blackUnicode;
    protected String whiteUnicode;
    protected boolean isNull = false;
    protected boolean hasMotion = false;

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public FigureColor getColor() {
        return color;
    }


    public boolean isHasMotion() {
        return hasMotion;
    }


    public void setHasMotion(boolean hasMotion) {
        this.hasMotion = hasMotion;
    }

    public Figure(int positionX, int positionY, FigureColor color) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.color = color;
    }

    final public boolean isNull() {
        return isNull;
    }

    final public String getUnicode() {
        if (this.color == FigureColor.BLACK) {
            return blackUnicode;
        } else {
            return whiteUnicode;
        }
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    abstract public Iterator<Position> getAvailablePositions(ChessBoard board);
}
