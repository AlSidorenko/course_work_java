package org.example.bucket;

import org.example.Array_Creation;
import org.example.Report_Sorting;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created on 29.07.2021 14:15.
 *
 * @author Aleks Sidorenko (e-mail: alek.sidorenko@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class StartBucketSort {

    public static void main(String[] args) {

        Report_Sorting reportSorting = new Report_Sorting();
        long timeStart = System.currentTimeMillis();

        int n = 100_000;

        int[] arr = new Array_Creation().array(n);
        System.out.printf("Source array: %s\n", Arrays.toString(arr));
        int[] arrBucketSort = new Bucket_Sort().sort(arr);
        System.out.printf("Bucket sort: %s\n", Arrays.toString(arrBucketSort));
        long timeFinish = System.currentTimeMillis();

        Date dt = new Date(timeFinish - timeStart);
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss:SS");
        String resTime = sdf.format(dt);
        System.out.printf("Time: %s", resTime);

        try {
            reportSorting.report("Bucket Sort: ", n, resTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
