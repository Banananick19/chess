package banana.chess.Figures;

import android.os.Build;

import androidx.annotation.RequiresApi;

import banana.chess.ChessBoard;

public class TakingOnTheAislePositionState extends PositionState {
    public TakingOnTheAislePositionState(ChessBoard board, Figure figure) {
        super(board, figure);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void doQniqueMotion() {
        int posX = board.getPositionAisle().getPositionX();
        int posY = board.getPositionAisle().getPositionY();
        board.setFigure(this.figure.getPositionX(), this.figure.getPositionY(), new NullFigure(0, 0, null));
        board.setFigure(posX, posY, this.figure);
        if (this.figure.getColor() == FigureColor.BLACK) {
            board.setFigure(posX, posY-1, new NullFigure(posX, posY+1, null));
        }
        if (this.figure.getColor() == FigureColor.WHITE) {
            board.setFigure(posX, posY+1, new NullFigure(posX, posY+1, null));
        }
    }
}
