package de.hendriklipka.aoc2020.day4;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User: hli
 * Date: 05.12.20
 * Time: 16:17
 */
public class Day041
{
    public static void main(String[] args)
    {
        try
        {
            Iterator<String> lines = FileUtils.readLines(new File("data/day4.txt"), StandardCharsets.UTF_8).listIterator();
            List<Passport> passports = new ArrayList<>();
            Passport currentPass = new Passport();
            while (lines.hasNext())
            {
                String line = lines.next();
                if (StringUtils.isEmpty(line))
                {
                    passports.add(currentPass);
                    currentPass = new Passport();
                }
                parseLine(line,currentPass);
            }
            passports.add(currentPass);
            System.out.println(passports.stream().filter(Passport::isComplete).count());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void parseLine(final String line, final Passport pass)
    {
        String[] fields =line.split(" ",0);
        for (String field: fields)
        {
            if (StringUtils.isNotBlank(field))
            {
                String[] fieldData = field.split(":");
                if (fieldData.length==2 && fieldData[0].length()==3)
                {
                    parseField(fieldData[0], fieldData[1], pass);
                }
            }
        }
    }

    private static void parseField(final String fieldName, final String fieldValue, final Passport pass)
    {
        switch(fieldName)
        {
            case "byr": pass.setByr(fieldValue); break;
            case "iyr": pass.setIyr(fieldValue); break;
            case "eyr": pass.setEyr(fieldValue); break;
            case "hgt": pass.setHgt(fieldValue); break;
            case "hcl": pass.setHcl(fieldValue); break;
            case "ecl": pass.setEcl(fieldValue); break;
            case "pid": pass.setPid(fieldValue); break;
            case "cid": pass.setCid(fieldValue); break;
        }
    }

    private static class Passport
    {
        private String byr;

        private String iyr;

        private String eyr;

        private String hgt;

        private String hcl;

        private String ecl;

        private String pid;

        private String cid;

        public String getByr()
        {
            return byr;
        }

        public void setByr(final String byr)
        {
            this.byr = byr;
        }

        public String getIyr()
        {
            return iyr;
        }

        public void setIyr(final String iyr)
        {
            this.iyr = iyr;
        }

        public String getEyr()
        {
            return eyr;
        }

        public void setEyr(final String eyr)
        {
            this.eyr = eyr;
        }

        public String getHgt()
        {
            return hgt;
        }

        public void setHgt(final String hgt)
        {
            this.hgt = hgt;
        }

        public String getHcl()
        {
            return hcl;
        }

        public void setHcl(final String hcl)
        {
            this.hcl = hcl;
        }

        public String getEcl()
        {
            return ecl;
        }

        public void setEcl(final String ecl)
        {
            this.ecl = ecl;
        }

        public String getPid()
        {
            return pid;
        }

        public void setPid(final String pid)
        {
            this.pid = pid;
        }

        public String getCid()
        {
            return cid;
        }

        public void setCid(final String cid)
        {
            this.cid = cid;
        }

        public boolean isComplete()
        {
            return StringUtils.isNoneBlank(byr, iyr, eyr, hgt, hcl, ecl, pid);
        }
    }
}

