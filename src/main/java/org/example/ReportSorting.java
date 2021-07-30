package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created on 23.01.2021 19:55.
 *
 * @author Aleks Sidorenko (e-mail: alek.sidorenko@gmail.com).
 * @version Id$.
 * @since 0.1.
 */
public class ReportSorting {

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

    public void writeReport(int n, String sortingType, int[]arrSort) {
        long timeStart = System.currentTimeMillis();

        //System.out.printf("Source array: %s\n\n", Arrays.toString(arr));
        System.out.println(sortingType + Arrays.toString(arrSort));
        long timeFinish = System.currentTimeMillis();

        Date dt = new Date(timeFinish - timeStart);
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss:SS");
        String resTime = sdf.format(dt);
        System.out.printf("Time: %s", resTime);

        try {
            report(sortingType, n, resTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
