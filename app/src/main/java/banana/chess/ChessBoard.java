package banana.chess;

import banana.chess.Figures.Bishop;
import banana.chess.Figures.Figure;
import banana.chess.Figures.FigureColor;
import banana.chess.Figures.King;
import banana.chess.Figures.Knight;
import banana.chess.Figures.NullFigure;
import banana.chess.Figures.Pawn;
import banana.chess.Figures.Queen;
import banana.chess.Figures.Rock;

public class ChessBoard {
    private boolean haveWhiteСastling = true;
    private boolean haveBlackСastling = true;
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
                board[x][y] = new NullFigure(x, y, FigureColor.BLACK); // почему у нулевой фигуры есть цвет? - я не знаю...
            }
        }
        //white[snowBALLS]
        for (int x = 0; x < 8; x ++) {
            for (int y = 6; y<7; y++) {
                board[x][y] = new Pawn(x, y, FigureColor.WHITE);
            }
        }
        for (int x = 1; x < 7; x++) {
            board[x][7] = new NullFigure(x, 7, FigureColor.WHITE);
        }
        board[7][7] = new Rock(7, 7, FigureColor.WHITE);
        board[0][7] = new Rock(7, 7, FigureColor.WHITE);
        board[6][7] = new Knight(6, 7, FigureColor.WHITE);
        board[1][7] = new Knight(6, 7, FigureColor.WHITE);
        board[5][7] = new Bishop(6, 7, FigureColor.WHITE);
        board[2][7] = new Bishop(6, 7, FigureColor.WHITE);
        board[4][7] = new King(6, 7, FigureColor.WHITE);
        board[3][7] = new Queen(6, 7, FigureColor.WHITE);
    }

    public Figure getFigure(int x, int y) {
        return board[x][y];
    }

    public Figure[][] getBoard() {
        return board;
    }
}
