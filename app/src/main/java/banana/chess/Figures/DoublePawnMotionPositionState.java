package banana.chess.Figures;

import banana.chess.ChessBoard;

public class DoublePawnMotionPositionState extends PositionState {
    public DoublePawnMotionPositionState(ChessBoard board, Figure figure) {
        super(board, figure);
    }

    @Override
    public void doQniqueMotion() {
        int startX = this.figure.positionX;
        int startY = this.figure.positionY;
        int newY = 0;

        if (this.figure.getColor() == FigureColor.BLACK) {
            newY = startY+2;
            board.setPositionAisle(new Position(startX, newY-1));
        }
        if (this.figure.getColor() == FigureColor.WHITE) {
            newY = startY-2;
            board.setPositionAisle(new Position(startX, newY+1));
        }
        board.setFigure(startX, startY, new NullFigure(startX, startY, null));
        board.setFigure(startX, newY, this.figure);
    }
}
