package banana.chess.Figures;

import banana.chess.ChessBoard;

public class PositionState {
    protected ChessBoard board;
    protected Figure figure;

    public PositionState(ChessBoard board, Figure figure    ) {
        this.board = board;
        this.figure = figure;
    }

    public void doQniqueMotion() {
        //
    }
}
