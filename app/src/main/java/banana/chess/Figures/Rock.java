package banana.chess.Figures;

import java.util.ArrayList;
import java.util.Iterator;

import banana.chess.ChessBoard;

public class Rock extends Figure {
    public Rock(int x, int y, FigureColor color) {
        super(x, y, color);
        this.blackUnicode = "\u265C";
        this.whiteUnicode = "\u2656";
    }

    @Override
    public Iterator getAvailablePositions(ChessBoard board) {
        ArrayList availablePositions = new ArrayList<Position>();
        Figure[][] field = board.getBoard();
        // TODO: this shit
        return availablePositions.iterator();
    }
}
