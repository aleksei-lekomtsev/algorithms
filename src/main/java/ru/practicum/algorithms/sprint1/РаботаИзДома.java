package ru.practicum.algorithms.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Вася реализовал функцию, которая переводит целое число из десятичной системы в двоичную.
 * Но, кажется, она получилась не очень оптимальной.
 * Попробуйте написать более эффективную программу.
 * Не используйте встроенные средства языка по переводу чисел в бинарное представление.
 * На вход подаётся целое число в диапазоне от 0 до 10000.
 * Выведите двоичное представление этого числа.
 */
public class РаботаИзДома {
    public static void main(String[] args) throws IOException {
        int n;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(bufferedReader.readLine().strip());
        }

        int quotient;
        int remainder;
        StringBuilder remainders = new StringBuilder();

        do {
            quotient = n / 2;
            remainder = n % 2;
            remainders.append(remainder);
            n = quotient;
        } while (quotient != 0);

        System.out.println(remainders.reverse());
    }
}
