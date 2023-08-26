package ru.practicum.algorithms.sprint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

/**
 * Метеорологическая служба вашего города решила исследовать погоду новым способом.
 * Под температурой воздуха в конкретный день будем понимать максимальную температуру в этот день.
 * Под хаотичностью погоды за n дней служба понимает количество дней,
 * в которые температура строго больше, чем в день до (если такой существует)
 * и в день после текущего (если такой существует).
 * Например, если за 5 дней максимальная температура воздуха составляла [1, 2, 5, 4, 8] градусов,
 * то хаотичность за этот период равна 2: в 3-й и 5-й дни выполнялись описанные условия.
 * <p>
 * Определите по ежедневным показаниям температуры хаотичность погоды за этот период.
 * Заметим, что если число показаний n=1, то единственный день будет хаотичным.
 * <p>
 * В первой строке дано число n –— длина периода измерений в днях, 1 ≤ n≤ 105.
 * Во второй строке даны n целых чисел –— значения температуры в каждый из n дней.
 * Значения температуры не превосходят 273 по модулю.
 * <p>
 * Выведите единственное число — хаотичность за данный период.
 */
public class ХаотичностьПогоды {
    public static void main(String[] args) throws IOException {
        int n;
        Integer[] input;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(bufferedReader.readLine().strip());
            input = Arrays
                    .stream(bufferedReader.readLine().strip().split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }

        Integer result = 0;

        if (n == 1 || (n == 2 && !Objects.equals(input[0], input[1]))) {
            result = 1;
        } else {
            for (int i = 1; i < input.length - 1; i++) {
                if (input[i] > input[i - 1] && input[i] > input[i + 1]) {
                    result++;
                }
            }
            if (input[0] > input[1]) {
                result++;
            }
            if (input[input.length - 1] > input[input.length - 2]) {
                result++;
            }
        }

        System.out.println(result);
    }
}
