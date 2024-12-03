package com.github.redawl.aocday3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.redawl.util.FileUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AOCDay3 {
    private static final Logger logger = LoggerFactory.getLogger(AOCDay3.class);

    private static final FileUtils fileUtils = FileUtils.getFileUtils();

    private static final Pattern MULT_PATTERN = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
    private static final Pattern MULT_PATTERN2 = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)|(do\\(\\))|(don't\\(\\))");

    public static int challenge1(String instructions){
        Matcher matcher = MULT_PATTERN.matcher(instructions);

        int ret = 0;

        while (matcher.find()) {
            ret += Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
        }

        return ret;
    }

    public static int challenge2(String instructions){
        boolean enabled = true;
        Matcher matcher = MULT_PATTERN2.matcher(instructions);

        int ret = 0;

        while(matcher.find()){
            if("do()".equals(matcher.group()))  {
                enabled = true;
            } else if ("don't()".equals(matcher.group())) {
                enabled = false;
            } else if (enabled) {
                ret += Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
            }
        }
        return ret;
    }

    public static void main(String [] args){
        String challenge1 = fileUtils.getFileContents("challenge3.txt").collect(Collectors.joining());

        logger.info("Answer 1: {}", challenge1(challenge1));
        logger.info("Answer 2: {}", challenge2(challenge1));
    }
}