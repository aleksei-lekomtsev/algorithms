package ru.practicum.algorithms.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Помогите Васе понять, будет ли фраза палиндромом.
 * Учитываются только буквы и цифры, заглавные и строчные буквы считаются одинаковыми.
 * Решение должно работать за O(N), где N — длина строки на входе.
 * В единственной строке записана фраза или слово.
 * Буквы могут быть только латинские. Длина текста не превосходит 20000 символов.
 * Фраза может состоять из строчных и прописных латинских букв, цифр, знаков препинания.
 * Выведите «True», если фраза является палиндромом, и «False», если не является.
 */
public class Палиндром {
    public static void main(String[] args) throws IOException {
        String input;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            input = bufferedReader.readLine();
        }
        input = input.replaceAll("[^a-zA-Z0-9]", "");
        input = input.toLowerCase();

        String result = "True";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                result = "False";
                break;
            }
        }
        System.out.println(result);
    }
}
