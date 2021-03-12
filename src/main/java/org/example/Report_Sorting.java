package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created on 23.01.2021 19:55.
 *
 * @author Aleks Sidorenko (e-mail: alek.sidorenko@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class Report_Sorting {

    public void report(String nameSort, int n, String resTime)
            throws IOException {
        FileWriter fw = new FileWriter("report_sorting.txt", true);
        BufferedWriter bufferWriter = new BufferedWriter(fw);
        bufferWriter.write(
                "----------------------------------------------- \n");
        bufferWriter.write(
                String.format("%s  N = %d | Time: %s\n",
                        nameSort, n, resTime)
        );
        bufferWriter.close();
        fw.close();
    }
}
