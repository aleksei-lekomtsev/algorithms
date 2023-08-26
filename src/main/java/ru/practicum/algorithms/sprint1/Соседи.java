package ru.practicum.algorithms.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Дана матрица. Нужно написать функцию, которая для элемента возвращает всех его соседей.
 * Соседним считается элемент, находящийся от текущего на одну ячейку влево, вправо, вверх или вниз.
 * Диагональные элементы соседними не считаются.
 * Например, в матрице A соседними элементами для (0, 0) будут 2 и 0. А для (2, 1) –— 1, 2, 7, 7.
 * <p>
 * В первой строке задано n — количество строк матрицы. Во второй — количество столбцов m.
 * Числа m и n не превосходят 1000. В следующих n строках задана матрица.
 * Элементы матрицы — целые числа, по модулю не превосходящие 1000.
 * В последних двух строках записаны координаты элемента, соседей которого нужно найти. Индексация начинается с нуля.
 * <p>
 * Напечатайте нужные числа в возрастающем порядке через пробел.
 */
public class Соседи {
    public static void main(String[] args) throws IOException {
        int n;
        int m;
        int x;
        int y;

        List<List<Integer>> matrix = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(bufferedReader.readLine().strip());
            m = Integer.parseInt(bufferedReader.readLine().strip());

            for (int i = 0; i < n; i++) {
                List<Integer> row = Arrays.stream(bufferedReader.readLine().strip().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                matrix.add(row);
            }

            x = Integer.parseInt(bufferedReader.readLine().strip());
            y = Integer.parseInt(bufferedReader.readLine().strip());
        }

        ArrayList<Integer> result = new ArrayList<>();
        if (x == 0 && y == 0) {
            if (n > 1 && m > 1) {
                result.add(matrix.get(x).get(y + 1));
                result.add(matrix.get(x + 1).get(y));
            } else if (n > 1 && m == 1) {
                result.add(matrix.get(x + 1).get(y));
            } else if (n == 1 && m > 1) {
                result.add(matrix.get(x).get(y + 1));
            }
        } else if (x == 0 && y > 0 && y < m - 1) {
            if (n > 1 && m > 1) {
                result.add(matrix.get(x).get(y + 1));
                result.add(matrix.get(x).get(y - 1));
                result.add(matrix.get(x + 1).get(y));
            }
        } else if (x == 0 && y == m - 1) {
            result.add(matrix.get(x).get(y - 1));
            result.add(matrix.get(x + 1).get(y));
        } else if (x > 0 && x < n - 1 && y == 0) {
            result.add(matrix.get(x).get(y + 1));
            result.add(matrix.get(x - 1).get(y));
            result.add(matrix.get(x + 1).get(y));
        } else if (x > 0 && x < n - 1 && y > 0 && y < m - 1) {
            result.add(matrix.get(x).get(y + 1));
            result.add(matrix.get(x - 1).get(y));
            result.add(matrix.get(x).get(y - 1));
            result.add(matrix.get(x + 1).get(y));
        } else if (x > 0 && x < n - 1 && y == m - 1) {
            result.add(matrix.get(x - 1).get(y));
            result.add(matrix.get(x).get(y - 1));
            result.add(matrix.get(x + 1).get(y));
        } else if (x == n - 1 && y == 0) {
            result.add(matrix.get(x - 1).get(y));
            result.add(matrix.get(x).get(y + 1));
        } else if (x == n - 1 && y < m - 1) {
            result.add(matrix.get(x - 1).get(y));
            result.add(matrix.get(x).get(y - 1));
            result.add(matrix.get(x).get(y + 1));
        } else if (x == n - 1 && y == m - 1) {
            result.add(matrix.get(x - 1).get(y));
            result.add(matrix.get(x).get(y - 1));
        }

        Collections.sort(result);

        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
