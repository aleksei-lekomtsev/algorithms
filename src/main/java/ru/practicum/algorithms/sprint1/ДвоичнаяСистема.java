package ru.practicum.algorithms.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Тимофей записал два числа в двоичной системе счисления и попросил Гошу вывести их сумму, также в двоичной системе.
 * Встроенную в язык программирования возможность сложения двоичных чисел применять нельзя.
 * Помогите Гоше решить задачу.
 * Решение должно работать за O(N), где N –— количество разрядов максимального числа на входе.
 * Два числа в двоичной системе счисления, каждое на отдельной строке.
 * Длина каждого числа не превосходит 10 000 символов.
 * Одно число в двоичной системе счисления
 */
public class ДвоичнаяСистема {
    public static void main(String[] args) throws IOException {
        String n1;
        String n2;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            n1 = bufferedReader.readLine();
            n2 = bufferedReader.readLine();
        }

        StringBuilder result = new StringBuilder();
        int i = n1.length() - 1;
        int j = n2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;

            if (i >= 0) {
                sum += n1.charAt(i) - '0';
            }

            if (j >= 0) {
                sum += n2.charAt(j) - '0';
            }

            if (sum == 0 || sum == 1) {
                result.append(sum);
                carry = 0;
            } else if (sum == 2) {
                carry = 1;
                result.append("0");
            } else {
                carry = 1;
                result.append("1");
            }
            i--;
            j--;
        }

        if (carry == 1) {
            result.append("1");
        }
        System.out.println(result.reverse());
    }
}
