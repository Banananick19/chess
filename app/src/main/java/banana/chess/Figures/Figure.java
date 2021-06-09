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

    public Figure(int x, int y, FigureColor color) {
        this.positionX = x;
        this.positionY = y;
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

    public String getName() {
        return this.getClass().getName();
    }

    abstract public Iterator getAvailablePositions(ChessBoard board);
}
