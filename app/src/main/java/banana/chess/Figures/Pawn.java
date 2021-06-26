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
    public Iterator<Position> getAvailablePositions(ChessBoard board) {
        ArrayList<Position> availablePositions = new ArrayList<>();
        Figure[][] field = board.getBoard();
        if (this.color == FigureColor.BLACK) {
            if (new Position(positionX, positionY +1).isValid()) {
                if (field[positionX][positionY +1].isNull()) {
                    availablePositions.add(new Position(positionX, positionY +1));
                }
            }
            if (new Position(positionX + 1, positionY +1).isValid()) {
                if (!field[positionX + 1][positionY +1].isNull() & field[positionX + 1][positionY +1].getColor() != this.color) {
                    availablePositions.add(new Position(positionX +1, positionY +1));
                }
            }
            if (new Position(positionX - 1, positionY +1).isValid()) {
                if (!field[positionX - 1][positionY +1].isNull() & field[positionX - 1][positionY +1].getColor() != this.color) {
                    availablePositions.add(new Position(positionX -1, positionY +1));
                }
            }
            if (!isHasMotion()) {
                if (new Position(positionX, positionY +2).isValid() & (field[positionX][positionY +1].isNull())) {
                    availablePositions.add(new Position(positionX, positionY +2));
                }
            }
        } else {
            if (new Position(positionX, positionY -1).isValid()) {
                if (field[positionX][positionY -1].isNull()) {
                    availablePositions.add(new Position(positionX, positionY -1));
                }
            }
            if (new Position(positionX + 1, positionY -1).isValid()) {
                if (!field[positionX + 1][positionY -1].isNull() & field[positionX + 1][positionY -1].getColor() != this.color) {
                    availablePositions.add(new Position(positionX +1, positionY -1));
                }
            }
            if (new Position(positionX - 1, positionY -1).isValid()) {
                if (!field[positionX - 1][positionY -1].isNull() & field[positionX - 1][positionY -1].getColor() != this.color) {
                    availablePositions.add(new Position(positionX -1, positionY -1));
                }
            }
            if (!isHasMotion()) {
                if (new Position(positionX, positionY -2).isValid() & field[positionX][positionY -1].isNull()) {
                    availablePositions.add(new Position(positionX, positionY -2));
                }
            }
        }

        return availablePositions.iterator();
    }
}
