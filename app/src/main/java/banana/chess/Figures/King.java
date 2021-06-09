package banana.chess.Figures;

import java.util.ArrayList;
import java.util.Iterator;

import banana.chess.ChessBoard;

public class King extends Figure {
    public King(int x, int y, FigureColor color) {
        super(x, y, color);
        this.blackUnicode = "\u265A";
        this.whiteUnicode = "\u2654";
    }

    @Override
    public Iterator getAvailablePositions(ChessBoard board) {
        ArrayList availablePositions = new ArrayList<Position>();
        Figure[][] field = board.getBoard();
        // TODO: this shit
        return availablePositions.iterator();
    }
}
