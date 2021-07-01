package banana.chess;


import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Iterator;
import java.util.ArrayList;

import banana.chess.Figures.Bishop;
import banana.chess.Figures.Figure;
import banana.chess.Figures.FigureColor;
import banana.chess.Figures.King;
import banana.chess.Figures.Knight;
import banana.chess.Figures.NullFigure;
import banana.chess.Figures.Pawn;
import banana.chess.Figures.Position;
import banana.chess.Figures.Queen;
import banana.chess.Figures.Rock;

public class ChessBoard {
    private FigureColor colorForMove = FigureColor.WHITE;


    public Position getPositionAisle() {
        return positionAisle;
    }

    public void setPositionAisle(Position positionAisle) {
        this.positionAisle = positionAisle;
    }

    private Position positionAisle;
    private Figure toggledFigure;
    private Figure[][] board;


    public ChessBoard() {
        board = new Figure[8][8];
        // BLACKS[niGgeRS]
        board[7][0] = new Rock(7, 0, FigureColor.BLACK);
        board[0][0] = new Rock(0, 0, FigureColor.BLACK);
        board[6][0] = new Knight(6, 0, FigureColor.BLACK);
        board[1][0] = new Knight(1, 0, FigureColor.BLACK);
        board[5][0] = new Bishop(5, 0, FigureColor.BLACK);
        board[2][0] = new Bishop(2, 0, FigureColor.BLACK);
        board[4][0] = new King(4, 0, FigureColor.BLACK);
        board[3][0] = new Queen(3, 0, FigureColor.BLACK);
        for (int x = 0; x < 8; x ++) {
            for (int y = 1; y<2; y++) {
                board[x][y] = new Pawn(x, y, FigureColor.BLACK);
            }
        }

        for (int x = 0; x < 8; x++) {
            for (int y = 2; y < 6; y++) {
                board[x][y] = new NullFigure(x, y, null);
            }
        }
        //white[snowBALLS]
        for (int x = 0; x < 8; x ++) {
            for (int y = 6; y<7; y++) {
                board[x][y] = new Pawn(x, y, FigureColor.WHITE);
            }
        }
        for (int x = 1; x < 7; x++) {
            board[x][7] = new NullFigure(x, 7, null);
        }
        board[7][7] = new Rock(7, 7, FigureColor.WHITE);
        board[0][7] = new Rock(0, 7, FigureColor.WHITE);
        board[6][7] = new Knight(6, 7, FigureColor.WHITE);
        board[1][7] = new Knight(1, 7, FigureColor.WHITE);
        board[5][7] = new Bishop(5, 7, FigureColor.WHITE);
        board[2][7] = new Bishop(2, 7, FigureColor.WHITE);
        board[4][7] = new King(4, 7, FigureColor.WHITE);
        board[3][7] = new Queen(3, 7, FigureColor.WHITE);
    }

    public Figure getFigure(int x, int y) {
        return board[x][y];
    }

    public Figure setFigure(int x, int y, Figure figure) {
        figure.setPositionY(y);
        figure.setPositionX(x);
        return board[x][y] = figure;
    }

    public FigureColor getColorForMove() {
        return colorForMove;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void attack(int x1, int y1, int x2, int y2) {
        if (board[x1][y1].isNull()) {
            return;
        }
        Figure figureAttack = board[x1][y1];
        if (figureAttack.getColor() != this.colorForMove) {
            return;
        }
        Figure figureVictim = board[x2][y2];
        Iterator<Position> iter = figureAttack.getAvailablePositions(this);
        boolean positionHas = false;
        if (this.positionAisle != null) {
            positionHas = true;
        }
        while (iter.hasNext()) {
                Position nextPosition = iter.next();
                if (nextPosition.getPositionX() == figureVictim.getPositionX() & nextPosition.getPositionY() == figureVictim.getPositionY()) {
                    if (nextPosition.getState() != null) {
                        nextPosition.getState().doQniqueMotion();
                        figureAttack.setHasMotion(true);
                        break;
                    }
                    board[x2][y2] = figureAttack;
                    board[x1][y1] = new NullFigure(x1, y1, null);
                    figureAttack.setPositionX(x2);
                    figureAttack.setPositionY(y2);
                    figureAttack.setHasMotion(true);
                    break;
                }
        }
        if (this.positionAisle!=null & positionHas) {
            this.positionAisle = null;
        }
        reverseColorForMove();
    }

    private void reverseColorForMove() {
        if (this.colorForMove == FigureColor.BLACK) this.colorForMove = FigureColor.WHITE;
        else this.colorForMove = FigureColor.BLACK;
    }

    public String toString() {
        String string = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                string += board[j][i].getUnicode() + " ";
            }
            string += "\n";
        }
        return string;
    }

    public Figure[][] getBoard() {
        return board;
    }

}
