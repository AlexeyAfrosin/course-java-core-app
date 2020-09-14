package com.a.afrosin.course.java.core.app;

import java.util.Random;
import java.util.Scanner;

public class Logic {
    static int SIZE = 5;
    static int DOTS_TO_WIN = 4;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static final int GAME_CONTINUES = -1;

    static final int DEAD_HEAT_WIN = 0;
    static final int HUMAN_WIN = 1;
    static final int AI_WIN = 2;
    static final String[] GAME_MASSAGES = {"Ничья!", "Вы победили!", "Компьютер победил!"};
    private static int rowWinX = -1;
    private static int colWinY = -1;
    private static int rowWinX2 = -1;
    private static int colWinY2 = -1;

    static char[][] map;

    static Random random = new Random();

    static boolean isFinishedGame;

    private static int go() {
        isFinishedGame = true;
        printMap();
        if (checkWinLines(DOT_X, DOTS_TO_WIN)) {
            System.out.println("Вы победили! Поздравляем!");
            return HUMAN_WIN;
        }
        if (isFull()) {
            System.out.println("Ничья");
            return DEAD_HEAT_WIN;
        }

        aiTurn();
        printMap();
        if (checkWinLines(DOT_O, DOTS_TO_WIN)) {
            System.out.println("Компьютер победил.");
            return AI_WIN;
        }
        if (isFull()) {
            System.out.println("Ничья");
            return AI_WIN;
        }

        isFinishedGame = false;
        return GAME_CONTINUES;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= map.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < map[i].length; j++) {
                System.out.printf("%c ", map[i][j]);
            }
            System.out.println();
        }
    }

    public static int humanTurn(int x, int y) {
        if (!isCellValid(y, x)) {
            return GAME_CONTINUES;
        }

        map[y][x] = DOT_X;
        return go();
    }

    public static boolean isCellValid(int y, int x) {
        if (y < 0 || x < 0 || y >= SIZE || x >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
//        if (map[y][x] == DOT_EMPTY) {
//            return true;
//        } else {
//            return false;
//        }
    }

    public static void aiTurn() {
        int x;
        int y;

        // Попытка победить самому
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (checkWinLines(DOT_O, DOTS_TO_WIN)) {
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
// Сбить победную линии противника, если осталось 1 ход для победы
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWinLines(DOT_X, DOTS_TO_WIN)) {
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

// Сбить победную линии противника, если осталось 2 хода для победы
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWinLines(DOT_X, DOTS_TO_WIN - 1) &&
                            Math.random() < 0.5) { //  фактор случайности, чтобы сбивал не все время первый попавшийся путь.
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }

// Сходить в произвольную не занятую ячейку

        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(y, x));

        map[y][x] = DOT_O;
    }

    public static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }


    static boolean checkLine(int cy, int cx, int vy, int vx, char dot, int dotsToWin) {
        if (cx + vx * (dotsToWin - 1) > SIZE - 1 || cy + vy * (dotsToWin - 1) > SIZE - 1 ||
                cy + vy * (dotsToWin - 1) < 0) {
            return false;
        }

        for (int i = 0; i < dotsToWin; i++) {
            if (map[cy + i * vy][cx + i * vx] != dot) {
                return false;
            }
        }

        for (int i = 0; i < dotsToWin; i++) {
            if (map[cy + i * vy][cx + i * vx] == dot) {
                rowWinX2 = cx + i * vx;
                colWinY2 = cy + i * vy;
            }
        }
        rowWinX = cx;
        colWinY = cy;

        return true;
    }

    static boolean checkWinLines(char dot, int dotsToWin) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {

                if (checkLine(i, j, 0, 1, dot, dotsToWin) ||
                        checkLine(i, j, 1, 0, dot, dotsToWin) ||
                        checkLine(i, j, 1, 1, dot, dotsToWin) ||
                        checkLine(i, j, -1, 1, dot, dotsToWin)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int getRowWinX() {
        return rowWinX;
    }

    public static int getColWinY() {
        return colWinY;
    }

    public static int getRowWinX2() {
        return rowWinX2;
    }

    public static int getColWinY2() {
        return colWinY2;
    }

}
