package banana.chess.Figures;

import banana.chess.ChessBoard;

public class ShortСastlingPositionState extends PositionState {
    public ShortСastlingPositionState(ChessBoard board, FigureColor color) {
        super(board, color);
    }

    @Override
    public void doQniqueMotion() {
        if (this.color == FigureColor.BLACK) {
            board.setFigure(5, 0, board.getFigure(7, 0));
            board.setFigure(6, 0, board.getFigure(4, 0));
            board.setFigure(7, 0, new NullFigure(0, 0, null));
            board.setFigure(4, 0, new NullFigure(4, 0, null));
        }
        if (this.color == FigureColor.WHITE) {
            board.setFigure(5, 7, board.getFigure(0, 7));
            board.setFigure(6, 7, board.getFigure(4, 7));
            board.setFigure(7, 7, new NullFigure(0, 7, null));
            board.setFigure(4, 7, new NullFigure(4, 7, null));
        }
    }
}
