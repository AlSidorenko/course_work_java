package org.example.radix;

import org.example.count.CountingSort;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created on 30.07.2021 21:12.
 *
 * @author Aleks Sidorenko (e-mail: alek.sidorenko@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class RadixSortTest {

    @Test
    public void whenSortCount() {
        RadixSort radixSort = new RadixSort();
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        int[] result = radixSort.sort(arr);
        int[] expected = {2, 24, 45, 66, 75, 90, 170, 802};

        assertThat(result, is(expected));
        System.out.println("Test done!");
    }
}
