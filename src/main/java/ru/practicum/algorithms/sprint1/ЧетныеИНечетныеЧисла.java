package ru.practicum.algorithms.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Представьте себе онлайн-игру для поездки в метро:
 * игрок нажимает на кнопку, и на экране появляются три случайных числа.
 * Если все три числа оказываются одной чётности, игрок выигрывает.
 * Напишите программу, которая по трём числам определяет, выиграл игрок или нет.
 * <p>
 * В первой строке записаны три случайных целых числа a, b и c. Числа не превосходят 10^9 по модулю.
 * <p>
 * Выведите «WIN», если игрок выиграл, и «FAIL» в противном случае.
 */
public class ЧетныеИНечетныеЧисла {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());

        if (a % 2 == 0 && b % 2 == 0 && c % 2 == 0 || a % 2 != 0 && b % 2 != 0 && c % 2 != 0) {
            System.out.println("WIN");
        } else {
            System.out.println("FAIL");
        }
    }
}
