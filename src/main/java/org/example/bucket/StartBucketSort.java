package org.example.bucket;

import org.example.ArrayCreation;
import org.example.ReportSorting;

import java.util.ResourceBundle;

/**
 * Created on 29.07.2021 14:15.
 *
 * @author Aleks Sidorenko (e-mail: alek.sidorenko@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class StartBucketSort {

    public static void main(String[] args) {
        init();
    }

    public static void init() {
        ReportSorting reportSorting = new ReportSorting();
        ResourceBundle resource = ResourceBundle.getBundle("messages");
        int nubOfItems = 100_000;
        int[] arr = new ArrayCreation().array(nubOfItems);
        int[] arrSortBucket = new BucketSort().sort(arr);

        reportSorting.writeReport(
                nubOfItems,
                resource.getString("bucket.sort"),
                arrSortBucket
        );
    }
}
