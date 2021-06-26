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
    public Iterator<Position> getAvailablePositions(ChessBoard board) {
        ArrayList<Position> availablePositions = new ArrayList<Position>();
        Figure[][] field = board.getBoard();
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                Position position = new Position(this.positionX + x, this.positionY + y);
                if (position.isValid()) {
                    if ((board.getFigure(position.getPositionX(), position.getPositionY()).isNull()) | (board.getFigure(position.getPositionX(), position.getPositionY()).getColor() != this.color)) {
                        availablePositions.add(position);
                    }
                }
            }
        }
        if (this.color == FigureColor.BLACK) {
            boolean leftClear = true;
            for (int x = 0; x<4; x++) {
                leftClear = board.getFigure(x, 0).isNull();
            }
            if (!board.getFigure(0, 0).isHasMotion() & leftClear) {
                availablePositions.add(new Position(2, 0, new LongСastlingPositionState(board, this.color)));
            }
            boolean rightClear = true;
            for (int x = 5; x<=6; x++) {
                rightClear = board.getFigure(x, 0).isNull();
            }
            if (!board.getFigure(7, 0).isHasMotion() & rightClear) {
                availablePositions.add(new Position(6, 0, new ShortСastlingPositionState(board, this.color)));
            }
        }
        if (this.color == FigureColor.WHITE) {
            boolean leftClear = true;
            for (int x = 0; x<4; x++) {
                leftClear = board.getFigure(x, 7).isNull();
            }
            if (!board.getFigure(0, 7).isHasMotion() & leftClear) {
                availablePositions.add(new Position(2, 7, new LongСastlingPositionState(board, this.color)));
            }
            boolean rightClear = true;
            for (int x = 5; x<=6; x++) {
                rightClear = board.getFigure(x, 7).isNull();
            }
            if (!board.getFigure(7, 7).isHasMotion() & rightClear) {
                availablePositions.add(new Position(6, 7, new ShortСastlingPositionState(board, this.color)));
            }
        }
        return availablePositions.iterator();
    }
}
