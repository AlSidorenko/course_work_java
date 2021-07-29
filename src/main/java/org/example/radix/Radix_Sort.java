package org.example.radix;

import org.example.Sorting;

/**
 * Created on 16.02.2021 21:59.
 *
 * @author Aleks Sidorenko (e-mail: alek.sidorenko@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class Radix_Sort implements Sorting {

    @Override
    public int[] sort(int[] input) {
        int[][] bucket = new int[10][10];
        int[] bucket_count = new int[10];
        int i, j, k, remainder, NOP = 0, divisor = 1, larger, pass;
        larger = largest(input);
        while (larger > 0) {
            NOP++;
            larger /= 10;
        }
        for (pass = 0; pass < NOP; pass++) { // Initialize the buckets
            for (i = 0; i < 10; i++) {
                bucket_count[i] = 0;
            }
            for (i = 0; i < 10; i++) {
                // sort the numbers according to the digit at passth place
                remainder = (input[i] / divisor) % 10;
                bucket[remainder][bucket_count[remainder]] = input[i];
                bucket_count[remainder] += 1;
            }
            // collect the numbers after PASS pass
            i = 0;
            for (k = 0; k < 10; k++) {
                for (j = 0; j < bucket_count[k]; j++) {
                    input[i] = bucket[k][j];
                    i++;
                }
            }
            divisor *= 10;
        }
        return input;
    }

    public static int largest(int[] a) {
        int larger = a[0], i;
        for (i = 1; i < 10; i++) {
            if (a[i] > larger)
                larger = a[i];
        }
        return larger;
    }
}
