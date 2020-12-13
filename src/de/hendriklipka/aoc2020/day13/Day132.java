package de.hendriklipka.aoc2020.day13;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: hli
 * Date: 13.12.20
 * Time: 22:40
 */
public class Day132
{
    public static void main(String[] args)
    {
        try
        {
            List<String> lines = FileUtils.readLines(new File("data/day13.txt"), StandardCharsets.UTF_8).stream().filter(StringUtils::isNotBlank).collect(Collectors.toList());
            List<String> busses = Arrays.stream(lines.get(1).split(",")).collect(Collectors.toList());
            // determine offsets for the busses
            // sort busses by their ID
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
