package banana.chess.Figures;

import java.util.ArrayList;
import java.util.Iterator;

import banana.chess.ChessBoard;

public class Rock extends Figure {
    public void setCastlingRight(boolean castlingRight) {
        this.castlingRight = castlingRight;
    }

    public void setCastlingLeft(boolean castlingLeft) {
        this.castlingLeft = castlingLeft;
    }

    private boolean castlingRight = false;
    private boolean castlingLeft = false;

    public Rock(int x, int y, FigureColor color) {
        super(x, y, color);
        this.blackUnicode = "\u265C";
        this.whiteUnicode = "\u2656";
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

        return availablePositions.iterator();
    }
}
