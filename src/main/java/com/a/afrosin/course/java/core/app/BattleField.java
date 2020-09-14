package com.a.afrosin.course.java.core.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleField extends JPanel {
    private GameWindow gameWindow;

    private int mode;
    private int fieldSize;
    private int winningLength;
    private int gameResult;

    private boolean isInit;

    int cellWidth;
    int cellHeight;


    public BattleField(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        setBackground(Color.ORANGE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int cellX = e.getX() / cellWidth;
                int cellY = e.getY() / cellHeight;
                gameResult = Logic.GAME_CONTINUES;

                if (!Logic.isFinishedGame) {
                    gameResult = Logic.humanTurn(cellX, cellY);
                }
                repaint();

                if(Logic.isFinishedGame && gameResult != Logic.GAME_CONTINUES){
                    JOptionPane.showMessageDialog(gameWindow,
                            String.format("Игра окончена! Результат: \"%s\"", Logic.GAME_MASSAGES[gameResult])
                    );
                }
            }
        });
    }

    public void startNewGame(int mode, int fieldSize, int winningLength) {
        this.mode = mode;
        this.fieldSize = fieldSize;
        this.winningLength = winningLength;

        isInit = true;

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!isInit) {
            return;
        }

        cellWidth = getWidth() / fieldSize;
        cellHeight = getHeight() / fieldSize;

        // рисуем сетку таблицы
        for (int i = 0; i < fieldSize; i++) {
            int y = i * cellHeight;
            int x = i * cellWidth;
            //горизонтальная линия
            g.drawLine(0, y, getWidth(), y);
            //вертикальна линия
            g.drawLine(x, 0, x, getHeight());
        }

//
        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if (Logic.map[i][j] == Logic.DOT_X) {
                    drawX(g, j, i);
                }
                if (Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g, j, i);
                }
            }
        }

        if(Logic.isFinishedGame && gameResult != Logic.DEAD_HEAT_WIN) {
            drawWinLine(g, Logic.getRowWinX(), Logic.getColWinY(), Logic.getRowWinX2(), Logic.getColWinY2());
        }

    }

    private void drawO(Graphics g, int cellX, int cellY) {
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.setColor(Color.RED);
        g.drawOval(cellX * cellWidth, cellY * cellHeight, cellWidth, cellHeight);
    }

    private void drawX(Graphics g, int cellX, int cellY) {

        ((Graphics2D) g).setStroke(new BasicStroke(5));

        g.setColor(Color.BLUE);
        g.drawLine(cellX * cellWidth, cellY * cellHeight,
                (cellX + 1) * cellWidth, (cellY + 1) * cellHeight);

        g.drawLine(cellX * cellWidth, cellY * cellHeight + cellHeight,
                (cellX + 1) * cellWidth, cellY * cellHeight);

    }

    private void drawWinLine(Graphics g, int rowX, int colY, int rowX2, int colY2) {
        int cellX = rowX * cellWidth;
        int cellY = colY * cellHeight;
        int cellX2 = rowX2 * cellWidth;
        int cellY2 = colY2 * cellHeight;

        // победная линия в одном столбце
        if (rowX == rowX2) {
            cellX += cellWidth/2;
            cellX2 += cellWidth/2;
            cellY2 += cellHeight;
        }
        //победная линия в одной строке
        else if (colY == colY2){
            cellY += cellHeight/2;
            cellX2 += cellWidth;
            cellY2 += cellHeight/2;
        }
        //победная линия в главной диагонали
        else if (colY2 - colY > 0) {
            cellX2 += cellWidth;
            cellY2 += cellHeight;
        }
        //победная линия в обратной диагонали
        else {
            cellY += cellHeight;
            cellX2 += cellWidth;
        }

        ((Graphics2D) g).setStroke(new BasicStroke(10));
//доделать рисование линии
        g.setColor(Color.BLACK);

        g.drawLine(cellX, cellY,
                cellX2, cellY2);

    }
}
