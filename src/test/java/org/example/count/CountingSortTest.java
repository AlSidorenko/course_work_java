package org.example.count;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created on 30.07.2021 21:07.
 *
 * @author Aleks Sidorenko (e-mail: alek.sidorenko@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class CountingSortTest {

    @Test
    public void whenSortCount() {
        CountingSort countingSort = new CountingSort();
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        int[] result = countingSort.sort(arr);
        int[] expected = {2, 24, 45, 66, 75, 90, 170, 802};

        assertThat(result, is(expected));
        System.out.println("Test done!");
    }
}
