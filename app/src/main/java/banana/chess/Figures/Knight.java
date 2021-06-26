package banana.chess.Figures;

import java.util.ArrayList;
import java.util.Iterator;

import banana.chess.ChessBoard;

public class Knight extends Figure {
    public Knight(int x, int y, FigureColor color) {
        super(x, y, color);
        this.blackUnicode = "\u265E";
        this.whiteUnicode = "\u2658";
    }

    @Override
    public Iterator getAvailablePositions(ChessBoard board) {
        ArrayList availablePositions = new ArrayList<Position>();
        Figure[][] field = board.getBoard();
        if (new Position(positionX -2, positionY +1).isValid()) {
            if (field[positionX -2][positionY +1].getColor() != this.color) {
                availablePositions.add(new Position(positionX -2, positionY +1));
            }
        }
        if (new Position(positionX -2, positionY -1).isValid()) {
            if (field[positionX -2][positionY -1].getColor() != this.color) {
                availablePositions.add(new Position(positionX -2, positionY -1));
            }
        }
        if (new Position(positionX -1, positionY +2).isValid()) {
            if (field[positionX -1][positionY +2].getColor() != this.color) {
                availablePositions.add(new Position(positionX -1, positionY +2));
            }
        }
        if (new Position(positionX +1, positionY +2).isValid()) {
            if (field[positionX +1][positionY +2].getColor() != this.color) {
                availablePositions.add(new Position(positionX +1, positionY +2));
            }
        }
        if (new Position(positionX +2, positionY +1).isValid()) {
            if (field[positionX +2][positionY +1].getColor() != this.color) {
                availablePositions.add(new Position(positionX +2, positionY +1));
            }
        }
        if (new Position(positionX +2, positionY -1).isValid()) {
            if (field[positionX +2][positionY -1].getColor() != this.color) {
                availablePositions.add(new Position(positionX +2, positionY -1));
            }
        }
        if (new Position(positionX +1, positionY -2).isValid()) {
            if (field[positionX +1][positionY -2].getColor() != this.color) {
                availablePositions.add(new Position(positionX +1, positionY -2));
            }
        }
        if (new Position(positionX -1, positionY -2).isValid()) {
            if (field[positionX -1][positionY -2].getColor() != this.color) {
                availablePositions.add(new Position(positionX -1, positionY -2));
            }
        }

        return availablePositions.iterator();
    }
}
