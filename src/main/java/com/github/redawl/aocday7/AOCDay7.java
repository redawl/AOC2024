package com.github.redawl.aocday7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.redawl.util.FileUtils;

import java.util.Arrays;
import java.util.List;

public class AOCDay7 {
    private static final Logger logger = LoggerFactory.getLogger(AOCDay7.class);

    private static final FileUtils fileUtils = FileUtils.getFileUtils();

    private static boolean checkPossible(long ans, long [] constants, int index, long accumulator) {
        if(index == constants.length) {
            return ans == accumulator;
        }

        return checkPossible(ans, constants, index + 1, accumulator * constants[index])
                || checkPossible(ans, constants, index + 1, accumulator + constants[index]);
    }

    public static long challenge1(List<String> equations){
        return equations.stream().mapToLong((equation) -> {
            String [] parts = equation.split(":");

            long ans = Long.parseLong(parts[0]);

            long [] constants = Arrays.stream(parts[1].split("\\s")).filter(constant -> !constant.isEmpty()).mapToLong(Long::parseLong).toArray();

            return checkPossible(ans, constants, 0, 0) ? ans : 0L;
        }).sum();
    }

    private static boolean checkPossible2(long ans, long [] constants, int index, long accumulator) {
        if(index == constants.length) {
            return ans == accumulator;
        }

        if(accumulator >= ans) return false;

        return checkPossible2(ans, constants, index + 1, accumulator * constants[index])
                || checkPossible2(ans, constants, index + 1, accumulator + constants[index])
                || checkPossible2(ans, constants, index + 1, Long.parseLong(accumulator + "" + constants[index]));
    }

    public static long challenge2(List<String> equations){
        return equations.stream().mapToLong((equation) -> {
            String [] parts = equation.split(":");

            long ans = Long.parseLong(parts[0]);

            long [] constants = Arrays.stream(parts[1].split("\\s")).filter(constant -> !constant.isEmpty()).mapToLong(Long::parseLong).toArray();

            return checkPossible2(ans, constants, 0, 0) ? ans : 0L;
        }).sum();
    }

    public static void main(String [] args){
        List<String> challenge1 = fileUtils.getFileContents("challenge7.txt").toList();

        logger.info("Answer 1: {}", challenge1(challenge1));
        logger.info("Answer 2: {}", challenge2(challenge1));
    }
}