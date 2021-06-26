package banana.chess.Figures;

import java.util.ArrayList;
import java.util.Iterator;

import banana.chess.ChessBoard;

public class Bishop extends Figure {
    public Bishop(int x, int y, FigureColor color) {
        super(x, y, color);
        this.blackUnicode = "\u265D";
        this.whiteUnicode = "\u2657";
    }

    @Override
    public Iterator<Position> getAvailablePositions(ChessBoard board) {
        ArrayList<Position> availablePositions = new ArrayList<>();
        Figure[][] field = board.getBoard();
        int x = 1;
        int y = 1;
        while (new Position(this.positionX -x, this.positionY +y).isValid()) {
            if (field[this.positionX -x][this.positionY +y].isNull()) {
                availablePositions.add(new Position(this.positionX -x, this.positionY +y));
                y += 1;
                x += 1;
                continue;
            }
            if (field[this.positionX -x][this.positionY +y].getColor() == this.color) {
                break;
            }
            if (field[this.positionX -x][this.positionY +y].getColor() != this.color) {
                availablePositions.add(new Position(this.positionX -x, this.positionY +y));
                break;
            }
        }

        x = 1;
        y = 1;

        while (new Position(this.positionX +x, this.positionY +y).isValid()) {
            if (field[this.positionX +x][this.positionY +y].isNull()) {
                availablePositions.add(new Position(this.positionX +x, this.positionY +y));
                y += 1;
                x += 1;
                continue;
            }
            if (field[this.positionX +x][this.positionY +y].getColor() == this.color) {
                break;
            }
            if (field[this.positionX +x][this.positionY +y].getColor() != this.color) {
                availablePositions.add(new Position(this.positionX +x, this.positionY +y));
                break;
            }
        }

        y = 1;
        x = 1;

        while (new Position(this.positionX +x, this.positionY -y).isValid()) {
            if (field[this.positionX +x][this.positionY -y].isNull()) {
                availablePositions.add(new Position(this.positionX +x, this.positionY -y));
                x += 1;
                y += 1;
                continue;
            }
            if (field[this.positionX +x][this.positionY -y].getColor() == this.color) {
                break;
            }
            if (field[this.positionX +x][this.positionY -y].getColor() != this.color) {
                availablePositions.add(new Position(this.positionX +x, this.positionY -y));
                break;
            }
        }


        x = 1;
        y = 1;

        while (new Position(this.positionX -x, this.positionY -y).isValid()) {
            if (field[this.positionX -x][this.positionY -y].isNull()) {
                availablePositions.add(new Position(this.positionX -x, this.positionY -y));
                x += 1;
                y += 1;
                continue;
            }
            if (field[this.positionX -x][this.positionY -y].getColor() == this.color) {
                break;
            }
            if (field[this.positionX -x][this.positionY -y].getColor() != this.color) {
                availablePositions.add(new Position(this.positionX -x, this.positionY -y));
                break;
            }
        }
        return availablePositions.iterator();
    }
}
