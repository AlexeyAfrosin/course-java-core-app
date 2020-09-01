package com.a.afrosin.course.java.core.app;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();


    public static void main(String[] args) {
        task1();
    }

    public static void task1() {
        printDelimiter();
        System.out.println("Задание 1");
        playGame(3, 3);
    }


    public static void playGame(int mapSize, int countCharForWin){

        char[][] map = initMap(mapSize);
        printMap(map);

        while (true) {
            humanTurn(map);
            printMap(map);
            if(checkWin(DOT_X, map, countCharForWin)){
                System.out.println("Вы победили! Поздравляем!");
                break;
            }
            if (isFull(map)) {
                System.out.println("Ничья");
                break;
            }

            aiTurn(map);
            printMap(map);
            if(checkWin(DOT_O, map, countCharForWin)){
                System.out.println("Компьютер победил.");
                break;
            }
            if (isFull(map)) {
                System.out.println("Ничья");
                break;
            }
        }
    }

    public static char [][] initMap(int mapSize) {
        char [][] map = new char[mapSize][mapSize];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
        return map.clone();
    }

    public static void printDelimiter() {
        System.out.println("=========================================");
    }

    public static void printMap(char [][]map) {
        printDelimiter();
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

    public static void humanTurn(char [][]map) {
        int x;
        int y;

        do {
            System.out.println("Ваш ход");
            System.out.println("Введите номер столбца и номер строки. Например, 1 1");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y, x, map));

        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int y, int x, char [][] map) {
        if (y < 0 || x < 0 || y >= map[0].length || x >= map.length) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static void aiTurn(char [][]map) {
        int x;
        int y;
        System.out.println("Ход соперника");
        do {
            x = random.nextInt(map.length);
            y = random.nextInt(map[0].length);
        } while (!isCellValid(y, x, map));

        map[y][x] = DOT_O;

    }

    public static boolean isFull(char [][]map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkWin(char c, char[][] arrForCheck, int countCharForWin) {

        int charCountInDiagonal = 0;
        int charCountInRow;
        int charCountInCol;
        int charCountInReverseDiagonal = 0;

        int col = 0;

        for (int i = 0; i < arrForCheck.length; i++){

            charCountInRow = 0;

            //проверка по строкам
            for (int j = 0; j < arrForCheck[i].length; j++){
                if ( c == arrForCheck[i][j]){
                    charCountInRow += 1;
                }
            }
            if (charCountInRow == countCharForWin) {
                return true;
            }

            charCountInCol = 0;

            for (int j = 0; j < arrForCheck.length; j++) {
                //считаем совпадения в столбце
                if ( c == arrForCheck[j][col]){
                    charCountInCol += 1;
                }
                //считаем совпадения в главной диагонали
                if (j == col && c == arrForCheck[j][col]){
                    charCountInDiagonal += 1;
                }

                //считаем совпадения в обратной диагонали
                if ( j + col == arrForCheck[j].length - 1 && c == arrForCheck[j][col]){
                    charCountInReverseDiagonal += 1;
                }
            }

            if (charCountInCol == countCharForWin ||
                charCountInDiagonal == countCharForWin ||
                charCountInReverseDiagonal == countCharForWin) {
                return true;
            }
            col += 1;
        }
        return false;
    }

}
