package org.example;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created on 10.03.2021 12:08.
 *
 * @author Aleks Sidorenko (e-mail: alek.sidorenko@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class Counting_Sort {

    public static void main(String[] args) {

        Report_Sorting reportSorting = new Report_Sorting();
        long timeStart = System.currentTimeMillis();

        int n = 100_000;

        int[] arr = new Array_Creation().array(n);
        System.out.printf("Source array: %s\n", Arrays.toString(arr));
        int[] arrCountingSort = countSort(arr);
        System.out.printf("Counting sort: %s\n", Arrays.toString(arrCountingSort));
        long timeFinish = System.currentTimeMillis();

        Date dt = new Date(timeFinish - timeStart);
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss:SS");
        String resTime = sdf.format(dt);
        System.out.printf("Time: %s", resTime);

        try {
            reportSorting.report("Counting Sort: ", n, resTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int[] countSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
        return arr;
    }
}
