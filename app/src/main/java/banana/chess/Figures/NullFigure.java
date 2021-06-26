package banana.chess.Figures;

import java.util.Iterator;

import banana.chess.ChessBoard;

public class NullFigure extends Figure {
    private boolean AvailableToAisle = false;

    public NullFigure(int x, int y, FigureColor color) {
        super(x, y, color);
        this.isNull = true;
        this.whiteUnicode = "";
        this.blackUnicode = "";
    }

    public void setAvailableToAisle(boolean availableToAisle) {
        this.AvailableToAisle = availableToAisle;
    }

    public boolean isAvailableToAisle() {
        return AvailableToAisle;
    }

    @Override
    public Iterator<Position> getAvailablePositions(ChessBoard board) {
        return null;
    }
}
