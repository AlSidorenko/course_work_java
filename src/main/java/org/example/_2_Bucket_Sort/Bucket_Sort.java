package org.example._2_Bucket_Sort;

import java.util.Scanner;

/**
 * Created on 16.02.2021 22:08.
 *
 * @author Aleks Sidorenko (e-mail: alek.sidorenko@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class Bucket_Sort {

    public static void bucketSort(int[] array, int n) {
        int i, j;
        int[] count = new int[n];
        for (i = 0; i < n; i++) {
            count[i] = 0;
        }

        for (i = 0; i < n; i++) {
            (count[array[i]])++;
        }

        for (i = 0, j = 0; i < n; i++) {
            for (; count[i] > 0; (count[i])--) {
                array[j++] = i;
            }
        }
    }
    /* End of Bucket_Sort() */

    /* The main() begins */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int[] array = new int[100];
        int i;

        System.out.print("Enter the size of array : ");
        int num = sc.nextInt();
        int[] array = new int[num];

        System.out.printf("Enter the %d elements to be sorted:\n", num);
        for (i = 0; i < num; i++) {
            array[i] = sc.nextInt();
        }

        System.out.printf("\nThe array of elements before sorting : \n");
        for (i = 0; i < num; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.printf("\nThe array of elements after sorting : \n");
        bucketSort(array, num);
        for (i = 0; i < num; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.println();
    }
}
