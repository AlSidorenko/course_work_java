package org.example.bucket;

import org.example.Sorting;

import java.util.*;

/**
 * Created on 11.03.2021 12:16.
 *
 * @author Aleks Sidorenko (e-mail: alek.sidorenko@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class Bucket_Sort implements Sorting {

    @Override
    public int[] sort(int[] input) {
        // get hash codes
        final int[] code = hash(input);

        // create and initialize buckets to ArrayList: O(n)
        //List[] buckets = new List[code[1]];
        List[] buckets = new List[code[1]];
        for (int i = 0; i < code[1]; i++) {
            buckets[i] = new ArrayList();
        }

        // distribute data into buckets: O(n)
        for (int i : input) {
            buckets[hash(i, code)].add(i);
        }

        // sort each bucket O(n)
        for (List bucket : buckets) {
            Collections.sort(bucket);
        }
        int ndx = 0;

        // merge the buckets: O(n)
        for (int b = 0; b < buckets.length; b++) {
            for (Object v : buckets[b]) {
                input[ndx++] = (int) v;
            }
        }
        return input;
    }

    /**
     * @param input * @return an array containing hash of input
     */
    private static int[] hash(int[] input) {
        int m = input[0];
        for (int i = 1; i < input.length; i++) {
            if (m < input[i]) {
                m = input[i];
            }
        }
        return new int[]{m, (int) Math.sqrt(input.length)};
    }

    /**
     * @param i * @param code * @return
     */
    private static int hash(int i, int[] code) {
        return (int) ((double) i / code[0] * (code[1] - 1));
    }
}
