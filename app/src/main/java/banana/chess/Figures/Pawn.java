package banana.chess.Figures;

import java.util.ArrayList;
import java.util.Iterator;

import banana.chess.ChessBoard;

public class Pawn extends Figure {
    public Pawn(int x, int y, FigureColor color) {
        super(x, y, color);
        this.blackUnicode = "\u265F";
        this.whiteUnicode = "\u2659";
    }

    @Override
    public Iterator getAvailablePositions(ChessBoard board) {
        ArrayList availablePositions = new ArrayList<Position>();
        Figure[][] field = board.getBoard();
        if (this.color == FigureColor.BLACK) {
            if (field[positionX][positionY+1].isNull()) {
                availablePositions.add(new Position(positionX, positionY+1));
            }
            if (!field[positionX-1][positionY+1].isNull()) {
                availablePositions.add(new Position(positionX-1, positionY+1));
            }
            if (!field[positionX+1][positionY+1].isNull()) {
                availablePositions.add(new Position(positionX+1, positionY+1));
            }
        } else {
            if (field[positionX][positionY-1].isNull()) {
                availablePositions.add(new Position(positionX, positionY-1));
            }
            if (positionX > 0) {
                if (!field[positionX-1][positionY-1].isNull()) {
                    availablePositions.add(new Position(positionX-1, positionY-1));
                }
            }
            if (positionX < 7) {
                if (!field[positionX+1][positionY-1].isNull()) {
                    availablePositions.add(new Position(positionX+1, positionY-1));
                }
            }
        }

        return availablePositions.iterator();
    }
}
