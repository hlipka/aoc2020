package de.hendriklipka.aoc2020.day1;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day012
{

    public static void main(String[] args) {
        try
        {
            List<String> lines = FileUtils.readLines(new File(args[0]), StandardCharsets.UTF_8).stream().filter(StringUtils::isNotBlank).collect(Collectors.toList());
            int[] values = new int[lines.size()];
            for (int i=0;i<lines.size();i++)
            {
                String line = lines.get(i);
                values[i] = Integer.parseInt(line);
            }
            Arrays.sort(values);
            for (int i=0;i<values.length-2;i++)
            {
                int value1 = values[i];
                for (int j=i+1;j<values.length-1;j++)
                {
                    int value2=values[j];
                    int other = 2020- value1-value2;
                    if (-1<Arrays.binarySearch(values, other))
                    {
                        System.out.println("found "+ value1 +" + "+ value2 +" + "+other+" -> "+ value1 *value2*other);
                    }
                }

            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        // write your code here
    }
}
