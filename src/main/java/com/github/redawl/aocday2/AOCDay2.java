package com.github.redawl.aocday2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.redawl.util.FileUtils;

import java.util.Arrays;
import java.util.List;

public class AOCDay2 {
    private static final Logger logger = LoggerFactory.getLogger(AOCDay2.class);

    private static final FileUtils fileUtils = FileUtils.getFileUtils();

    private static int checkSafety(int [] levels) {
        final boolean direction = (levels[0] - levels[levels.length - 1]) > 0;
        for (int i = 0; i < levels.length; i++) {
            if (i == levels.length - 1) return -1;
            else if(levels[i] == levels[i+1] || (levels[i] - levels[i+1] > 0) != direction || Math.abs(levels[i] - levels[i+1]) > 3) {
                return i;
            }
        }

        throw new RuntimeException("Should not happen");
    }

    private static int [] delete(int [] arr, int index) {
        int [] ret = new int[arr.length - 1];
        int retIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if(i != index){
                ret[retIndex] = arr[i];
                retIndex++;
            }
        }

        return ret;
    }

    public static int challenge1(List<String> input){
        return input.stream().mapToInt((line) -> {
            int [] levels = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            return checkSafety(levels) == -1 ? 1 : 0;
        }).sum();
    }

    public static int challenge2(List<String> input){
        return input.stream().mapToInt((line) -> {
            int [] levels = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int isSafe = checkSafety(levels);
            if (isSafe == -1) return 1;
            if(checkSafety(delete(levels, isSafe)) == -1 || (isSafe < levels.length - 1 && checkSafety(delete(levels, isSafe + 1)) == -1)){
                return 1;
            }
            return 0;
        }).sum();
    }

    public static void main(String [] args){
        List<String> challenge1 = fileUtils.getFileContents("challenge2.txt").toList();

        logger.info("Answer 1: {}", challenge1(challenge1));
        logger.info("Answer 2: {}", challenge2(challenge1));
    }
}