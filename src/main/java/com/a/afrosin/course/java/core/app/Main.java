package com.a.afrosin.course.java.core.app;

public class Main {
    public static void main(String[] args) {
        String[][] array4x4 = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        String[][] arrayErrorRowCount = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        String[][] arrayErrorColCount = {
                {"1", "2", "3", "4"},
                {"1", "2", "3"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        String[][] arrayErrorParse = {
                {"1", "AA", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        printSumArray(array4x4);
        printSumArray(arrayErrorRowCount);
        printSumArray(arrayErrorColCount);
        printSumArray(arrayErrorParse);

    }

    public static void printSumArray(String[][] array) {
        try {
            System.out.printf("Сумма элементов массива = %d\n", sumArray(array));
        } catch (MyArraySizeException e) {
            System.out.printf("Ошибка: %s %d\n", e.getErrorMessage(), e.getErrorSize());
        } catch (MyArrayDataException e) {
            System.out.printf("Ошибка: %s. Ошибочный элемент array[%d][%d] = '%s'\n",
                    e.getErrorMessage(),
                    e.getErrorRowNumber(),
                    e.getErrorColNumber(),
                    e.getErrorElementValue()
                    );
        }
    }

    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException  {
        final int MATRIX_SIZE = 4;
        int sum = 0;
        if (array.length != MATRIX_SIZE) {
            throw new MyArraySizeException(array.length, "Неверное количество строк в массиве");
        }
        for (int i = 0, arrayLength = array.length; i < arrayLength; i++) {

            if (array[i].length != MATRIX_SIZE) {
                throw new MyArraySizeException(array[i].length, "Неверное количество столбцов в массиве");
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, array[i][j], "Ошибка преобразования элемента в число");
                }

            }
        }

        return sum;
    }
}
