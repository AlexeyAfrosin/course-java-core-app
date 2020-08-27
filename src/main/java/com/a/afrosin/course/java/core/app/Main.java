package com.a.afrosin.course.java.core.app;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        task_1();
        task_2();
    }

    public static void task_1() {
        System.out.println("Задание 1");
        int minValue = 0;
        int maxValue = 10;
        int maxAttemptCount = 3;
        int userAnswer;
        boolean userIsRight;

        String resultMessage;
        Random random = new Random();

        int randomNumber;
        Scanner sc = new Scanner(System.in);

        int i;
        do {
            userIsRight = false;
            i = 0;
            randomNumber = random.nextInt(maxValue);
            System.out.printf("Введите число от %d до %d\n", minValue, maxValue);
            do {
                userAnswer = sc.nextInt();

                if (userAnswer > randomNumber) {
                    resultMessage = "Ваше число больше заданного.";
                } else if (userAnswer < randomNumber) {
                    resultMessage = "Ваше число меньше заданного.";
                } else {
                    resultMessage = "Поздравляем!!! Вы угадали!";
                    userIsRight = true;
                }
                if (!userIsRight && (i + 1) < maxAttemptCount) {
                    resultMessage = resultMessage.concat(" Попробуйте еще раз!");
                }

                System.out.println(resultMessage);

                i++;
            } while (i < maxAttemptCount && !userIsRight);

            if (!userIsRight) {
                System.out.printf("Правильный ответ: %d\n", randomNumber);
            }
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");

        } while (1 == sc.nextInt());

    }

    public static void task_2() {
        System.out.println("Задание 2");

        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                        "avocado", "broccoli", "carrot", "cherry", "garlic",
                        "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                        "nut", "olive", "pea", "peanut", "pear", "pepper",
                        "pineapple", "pumpkin", "potato"
        };

        Scanner sc = new Scanner(System.in);
        String userAnswer;
        Random random = new Random();

        String randomWord = words[random.nextInt(words.length)];

        System.out.println("Угдайте один из фруктов");
        System.out.printf("Возможные варианты: %s\n", Arrays.toString(words));

        do {
            System.out.println("Введите название фрукта:");

            userAnswer = sc.nextLine().toLowerCase();

            if (userAnswer.equals(randomWord)){
                System.out.println("Поздравляем!!! Вы угадали!");
                System.out.println("Игра завершена!");
                userAnswer = randomWord;
            }
            else{
                System.out.println("Вы не угадали.");
                System.out.println("Возможно, это вам подскажет: " + encodeWord(userAnswer, randomWord));
            }
        } while (!userAnswer.equals(randomWord));
    }

    public static String encodeWord(String userAnswer, String randomWord){
        StringBuilder tmpStr = new StringBuilder();
        char appendChar = '#';
        int maxTmpStrLength = 15;
        int i = 0;

        char userAnswerCh;
        char randomWordCh;
        while(i < userAnswer.length() && i < randomWord.length()){
            userAnswerCh = userAnswer.charAt(i);
            randomWordCh = randomWord.charAt(i);
            if (userAnswerCh == randomWordCh){
                tmpStr.append(userAnswerCh);
            }
            else{
                tmpStr.append(appendChar);
            }

            i++;
        }

        for (i = tmpStr.length() - 1; i < maxTmpStrLength; i++) {
            tmpStr.append(appendChar);
        }
        return tmpStr.toString();
    }

}
