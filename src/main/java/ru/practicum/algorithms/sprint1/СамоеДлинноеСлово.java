package ru.practicum.algorithms.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Чтобы подготовиться к семинару, Гоше надо прочитать статью по эффективному менеджменту.
 * Так как Гоша хочет спланировать день заранее, ему необходимо оценить сложность статьи.
 * Он придумал такой метод оценки: берётся случайное предложение из текста и в нём ищется самое длинное слово.
 * Его длина и будет условной сложностью статьи.
 * Помогите Гоше справиться с этой задачей.
 * <p>
 * В первой строке дана длина текста L (1 ≤ L ≤ 10^5).
 * В следующей строке записан текст, состоящий из строчных латинских букв и пробелов.
 * Слово —– последовательность букв, не разделённых пробелами.
 * Пробелы могут стоять в самом начале строки и в самом её конце.
 * Текст заканчивается переносом строки, этот символ не включается в число остальных L символов.
 * <p>
 * В первой строке выведите самое длинное слово.
 * Во второй строке выведите его длину. Если подходящих слов несколько, выведите то, которое встречается раньше.
 */
public class СамоеДлинноеСлово {
    public static void main(String[] args) throws IOException {
        String[] inputArray;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            inputArray = bufferedReader.readLine().strip().split(" ");
        }

        String maxString = inputArray[0];

        for (int i = 1; i < inputArray.length; i++) {
            if (maxString.length() < inputArray[i].length()) {
                maxString = inputArray[i];
            }
        }

        System.out.println(maxString);
        System.out.println(maxString.length());
    }
}
