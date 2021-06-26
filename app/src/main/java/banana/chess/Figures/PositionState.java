package banana.chess.Figures;

import banana.chess.ChessBoard;

public class PositionState {
    protected ChessBoard board;
    protected FigureColor color;

    public PositionState(ChessBoard board, FigureColor color) {
        this.board = board;
        this.color = color;
    }

    public void doQniqueMotion() {
        //
    }
}
