package banana.chess;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.Iterator;

import banana.chess.Figures.Figure;
import banana.chess.Figures.Position;

public class BoardActivity extends AppCompatActivity {
    private ChessBoard board;
    private TextView[][] graphicsBoard;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        GridLayout field = (GridLayout) findViewById(R.id.field);
        this.board = new ChessBoard();
        createBoard(field);
    }

    public void showAvailablePositions(int x, int y) {
        Figure figure = board.getFigure(x, y);
        if (figure.isNull()) {
            return;
        }
        Iterator positions = figure.getAvailablePositions(board);
        while (positions.hasNext()) {
            Position position = (Position) positions.next();
            graphicsBoard[position.getX()][position.getY()].setBackground(getResources().getDrawable(R.drawable.position_available));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void createBoard(final GridLayout field) {
        field.post(new Runnable() {
            @Override
            public void run() {
                ViewGroup.LayoutParams fieldParams = field.getLayoutParams(); // берем параметры поля (лаяута)
                int fieldgameField = Math.min(field.getWidth(), field.getHeight()); // определяем меньшую сторону
                fieldParams.width = fieldgameField; // делаем стороны одинаковыми, квадрат
                fieldParams.height = fieldgameField;
                field.setLayoutParams(fieldParams);
                graphicsBoard = new TextView[8][8];
                // цикл в котором создаются кнопки
                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        TextView textView = new TextView(field.getContext());
                        graphicsBoard[x][y] = textView;
                        textView.setText(String.valueOf(board.getFigure(x, y).getUnicode()));
                        textView.setTextSize(22);
                        textView.setGravity(Gravity.CENTER);
                        textView.setBackground(ContextCompat.getDrawable(field.getContext(), R.drawable.back));
                        GridLayout.LayoutParams lp = new GridLayout.LayoutParams(); // создаем параметры лаяута для кнопки
                        lp.width = 0; // так надо потому что ниже мы указываем вес кнопок = 1, они будут сами высчитывать размеры
                        lp.height = 0;
                        lp.columnSpec = GridLayout.spec(x, 1f); // вес и позиция кнопки по горизонтали
                        lp.rowSpec = GridLayout.spec(y, 1f); // и по вертикали
                        field.addView(textView, lp); // добавляем кнопку на поле
                    }
                }
                field.invalidate();
            }
        });
    }
}