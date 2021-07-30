package org.example.count;

import org.example.Sorting;

import java.util.Arrays;

/**
 * Created on 10.03.2021 12:08.
 *
 * @author Aleks Sidorenko (e-mail: alek.sidorenko@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class CountingSort implements Sorting {

    @Override
    public int[] sort(int[] input) {
        int max = Arrays.stream(input).max().getAsInt();
        int min = Arrays.stream(input).min().getAsInt();
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            count[input[i] - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = input.length - 1; i >= 0; i--) {
            output[count[input[i] - min] - 1] = input[i];
            count[input[i] - min]--;
        }

        for (int i = 0; i < input.length; i++) {
            input[i] = output[i];
        }
        return input;
    }
}
