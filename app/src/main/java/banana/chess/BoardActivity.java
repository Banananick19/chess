package banana.chess;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.Iterator;

import banana.chess.Figures.Figure;
import banana.chess.Figures.Position;

public class BoardActivity extends AppCompatActivity {
    private ChessBoard board;
    private TextView[][] graphicsBoard;
    private Position toggledPosition;
    private GridLayout gridLayoutField;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        GridLayout field = (GridLayout) findViewById(R.id.field);
        this.gridLayoutField = field;
        this.board = new ChessBoard();
        createBoard(field);
    }

    public void showAvailablePositions() {
        Figure figure = board.getFigure(toggledPosition.getPositionX(), toggledPosition.getPositionY());
        if (figure.isNull()) {
            return;
        }
        Iterator positions = figure.getAvailablePositions(board);
        while (positions.hasNext()) {
            Position position = (Position) positions.next();
            graphicsBoard[position.getPositionX()][position.getPositionY()].setBackground(getResources().getDrawable(R.drawable.position_available));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void attack(int x1, int y1, int x2, int y2) {
        board.attack(x1, y1, x2, y2);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void onToggle(int x, int y) {
        if (toggledPosition == null) {
            if (board.getFigure(x, y).isNull()) {
                return;
            }
            if (board.getFigure(x, y).getColor() != board.getColorForMove()) {
                return;
            }
            toggledPosition = new Position(x, y);
            updateBoard();
            return;
        }
        if (toggledPosition.getPositionY() == y & toggledPosition.getPositionX() == x) {
            toggledPosition = null;
            updateBoard();
            return;
        }
        if (board.getBoard()[toggledPosition.getPositionX()][toggledPosition.getPositionY()].getColor() == board.getBoard()[x][y].getColor()) {
            toggledPosition = new Position(x, y);
            updateBoard();
            return;
        }
        else {
            attack(toggledPosition.getPositionX(), toggledPosition.getPositionY(), x, y);
            toggledPosition = null;
            updateBoard();
        }
    }

    protected void updateBoard() {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Figure figure = board.getFigure(x, y);
                graphicsBoard[x][y].setText(figure.getUnicode());
                int finalX = x;
                int finalY = y;
                graphicsBoard[x][y].setBackground(ContextCompat.getDrawable(gridLayoutField.getContext(), R.drawable.back));
                graphicsBoard[x][y].setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    public void onClick(View v) {
                        onToggle(finalX, finalY);
                    }
                });
            }
        }
        if (toggledPosition != null) {
            graphicsBoard[toggledPosition.getPositionX()][toggledPosition.getPositionY()].setBackground(ContextCompat.getDrawable(gridLayoutField.getContext(), R.drawable.position_toggled));
            showAvailablePositions();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void createBoard(final GridLayout field) {
        field.post(new Runnable() {
            @Override
            public void run() {
                ViewGroup.LayoutParams fieldParams = field.getLayoutParams(); // ?????????? ?????????????????? ???????? (????????????)
                int fieldgameField = Math.min(field.getWidth(), field.getHeight()); // ???????????????????? ?????????????? ??????????????
                fieldParams.width = fieldgameField; // ???????????? ?????????????? ??????????????????????, ??????????????
                fieldParams.height = fieldgameField;
                field.setLayoutParams(fieldParams);
                graphicsBoard = new TextView[8][8];
                // ???????? ?? ?????????????? ?????????????????? ????????????
                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        TextView textView = new TextView(field.getContext());
                        graphicsBoard[x][y] = textView;
                        textView.setText(String.valueOf(board.getFigure(x, y).getUnicode()));
                        textView.setTextSize(22);
                        textView.setGravity(Gravity.CENTER);
                        textView.setBackground(ContextCompat.getDrawable(field.getContext(), R.drawable.back));
                        int finalX = x;
                        int finalY = y;
                        textView.setOnClickListener(new View.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.N)
                            public void onClick(View v) {
                                onToggle(finalX, finalY);
                            }
                        });
                        GridLayout.LayoutParams lp = new GridLayout.LayoutParams(); // ?????????????? ?????????????????? ???????????? ?????? ????????????
                        lp.width = 0; // ?????? ???????? ???????????? ?????? ???????? ???? ?????????????????? ?????? ???????????? = 1, ?????? ?????????? ???????? ?????????????????????? ??????????????
                        lp.height = 0;
                        lp.columnSpec = GridLayout.spec(x, 1f); // ?????? ?? ?????????????? ???????????? ???? ??????????????????????
                        lp.rowSpec = GridLayout.spec(y, 1f); // ?? ???? ??????????????????
                        field.addView(textView, lp); // ?????????????????? ???????????? ???? ????????
                    }
                }
                field.invalidate();
            }
        });
    }
}