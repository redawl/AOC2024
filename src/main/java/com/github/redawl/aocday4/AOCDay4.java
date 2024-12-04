package com.github.redawl.aocday4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.redawl.util.FileUtils;

import java.util.List;

public class AOCDay4 {
    private static final Logger logger = LoggerFactory.getLogger(AOCDay4.class);

    private static final FileUtils fileUtils = FileUtils.getFileUtils();

    private static final String word = "XMAS";

    private static int recurse(int x, int y, int wordIndex, List<String> wordSearch, int xDirection, int yDirection){
        if (wordIndex == word.length()) {
            return 1;
        }

        if(y == wordSearch.size() || x == wordSearch.get(0).length() || x < 0 || y < 0) {
            return 0;
        }

        if(wordSearch.get(y).charAt(x) != word.charAt(wordIndex)) {
            return 0;
        }

        int ret = 0;
        int xLength = (x < wordSearch.get(0).length() - 1 ? x + 1 : x);
        int yLength = (y < wordSearch.size() - 1 ? y + 1 : y);

        if (wordIndex == 0) {
            for (int xIndex = x > 0 ? x - 1 : 0; xIndex <= xLength; xIndex++) {
                for (int yIndex = y > 0 ? y - 1 : 0; yIndex <= yLength; yIndex++) {
                    // Ignore current search x and y, but search all others
                    if (xIndex != x || yIndex != y) {
                        ret += recurse(xIndex, yIndex, wordIndex + 1, wordSearch, xIndex - x, yIndex - y);
                    }
                }
            }
        } else {
            ret += recurse(x + xDirection, y + yDirection, wordIndex + 1, wordSearch, xDirection, yDirection);
        }

        return ret;
    }

    public static int challenge1(List<String> wordSearch){
        int ret = 0;
        for(int y = 0; y < wordSearch.size(); y++) {
            for(int x = 0; x < wordSearch.get(0).length(); x++){
                ret += recurse(x, y, 0, wordSearch, 0, 0);
            }
        }
        return ret;
    }

    private static int checkForXMAS(int x, int y, List<String> wordSearch) {
        // check for Ms
        List<Character> chars = List.of(
                wordSearch.get(y+1).charAt(x+1),
                wordSearch.get(y+1).charAt(x-1),
                wordSearch.get(y-1).charAt(x-1),
                wordSearch.get(y-1).charAt(x+1)
        );

        boolean foundDuplicateS = false;
        boolean foundDuplicateM = false;
        for (int i = 0; i < chars.size(); i++) {
            if (chars.get(i) != 'M' && chars.get(i) != 'S') {
                return 0;
            }
            if(chars.get(i) == 'M'){
                if(chars.get(i) == chars.get((i+1) % chars.size())) {
                    foundDuplicateM = true;
                }
            } else if(chars.get(i) == 'S'){
                if(chars.get(i) == chars.get((i+1) % chars.size())) {
                    foundDuplicateS = true;
                }
            }
        }

        return (foundDuplicateM && foundDuplicateS) ? 1 : 0;
    }

    public static int challenge2(List<String> wordSearch){
        int ret = 0;
        for(int x = 1; x < wordSearch.get(0).length() - 1; x++){
            for (int y = 1; y < wordSearch.size() - 1; y++) {
                if (wordSearch.get(y).charAt(x) == 'A') {
                    ret += checkForXMAS(x, y, wordSearch);
                }
            }
        }

        return ret;
    }

    public static void main(String [] args){
        List<String> challenge1 = fileUtils.getFileContents("challenge4.txt").toList();

        logger.info("Answer 1: {}", challenge1(challenge1));
        logger.info("Answer 2: {}", challenge2(challenge1));
    }
}