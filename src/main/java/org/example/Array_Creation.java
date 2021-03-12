package org.example;

import java.util.Random;

/**
 * Created on 23.01.2021 18:19.
 *
 * @author Aleks Sidorenko (e-mail: alek.sidorenko@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class Array_Creation {

    public int[] array(int n) {
        int[] arrTemp = new int[n];

        Random r = new Random();
        int low = 10;
        int high = 100;

        for (int i = 0; i < arrTemp.length; i++) {
            arrTemp[i] = r.nextInt(high - low) + low;
        }
        return arrTemp;
    }
}
