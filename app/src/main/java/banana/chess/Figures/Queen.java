package banana.chess.Figures;

import java.util.ArrayList;
import java.util.Iterator;

import banana.chess.ChessBoard;

public class Queen extends Figure {
    public Queen(int x, int y, FigureColor color) {
        super(x, y, color);
        this.blackUnicode = "\u265B";
        this.whiteUnicode = "\u2655";
    }

    @Override
    public Iterator getAvailablePositions(ChessBoard board) {
        ArrayList availablePositions = new ArrayList<Position>();
        Figure[][] field = board.getBoard();
        int x = 1;
        int y = 1;
        while (new Position(this.positionX, this.positionY -y).isValid()) {
            if (field[this.positionX][this.positionY -y].isNull()) {
                availablePositions.add(new Position(this.positionX, this.positionY -y));
                y += 1;
                continue;
            }
            if (field[this.positionX][this.positionY -y].getColor() == this.color) {
                y = 1;
                break;
            }
            if (field[this.positionX][this.positionY -y].getColor() != this.color) {
                availablePositions.add(new Position(this.positionX, this.positionY -y));
                y = 1;
                break;
            }
        }

        while (new Position(this.positionX, this.positionY +y).isValid()) {
            if (field[this.positionX][this.positionY +y].isNull()) {
                availablePositions.add(new Position(this.positionX, this.positionY +y));
                y += 1;
                continue;
            }
            if (field[this.positionX][this.positionY +y].getColor() == this.color) {
                y = 1;
                break;
            }
            if (field[this.positionX][this.positionY +y].getColor() != this.color) {
                availablePositions.add(new Position(this.positionX, this.positionY +y));
                y = 1;
                break;
            }
        }

        while (new Position(this.positionX +x, this.positionY).isValid()) {
            if (field[this.positionX +x][this.positionY].isNull()) {
                availablePositions.add(new Position(this.positionX +x, this.positionY));
                x += 1;
                continue;
            }
            if (field[this.positionX +x][this.positionY].getColor() == this.color) {
                x = 1;
                break;
            }
            if (field[this.positionX +x][this.positionY].getColor() != this.color) {
                availablePositions.add(new Position(this.positionX +x, this.positionY));
                x = 1;
                break;
            }
        }

        x = 1;

        while (new Position(this.positionX -x, this.positionY).isValid()) {
            if (field[this.positionX -x][this.positionY].isNull()) {
                availablePositions.add(new Position(this.positionX -x, this.positionY));
                x += 1;
                continue;
            }
            if (field[this.positionX -x][this.positionY].getColor() == this.color) {
                x = 1;
                break;
            }
            if (field[this.positionX -x][this.positionY].getColor() != this.color) {
                availablePositions.add(new Position(this.positionX -x, this.positionY));
                x = 1;
                break;
            }
        }

        x = 1;
        y = 1;
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
