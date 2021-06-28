package banana.chess.Figures;

import banana.chess.ChessBoard;

public class LongСastlingPositionState extends PositionState {
    public LongСastlingPositionState(ChessBoard board, Figure figure) {
        super(board, figure);
    }

    @Override
    public void doQniqueMotion() {
        if (this.figure.getColor() == FigureColor.BLACK) {
            board.setFigure(3, 0, board.getFigure(0, 0));
            board.setFigure(2, 0, board.getFigure(4, 0));
            board.setFigure(0, 0, new NullFigure(0, 0, null));
            board.setFigure(4, 0, new NullFigure(4, 0, null));
        }
        if (this.figure.getColor() == FigureColor.WHITE) {
            board.setFigure(3, 7, board.getFigure(0, 7));
            board.setFigure(2, 7, board.getFigure(4, 7));
            board.setFigure(0, 7, new NullFigure(0, 7, null));
            board.setFigure(4, 7, new NullFigure(4, 7, null));
        }
    }
}
