package com.github.redawl.aocday4;

import com.github.redawl.aocday3.AOCDay3;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AOCDay4Tests {
    private static final List<String> challenge1TestData = List.of(
            "MMMSXXMASM",
            "MSAMXMSMSA",
            "AMXSXMAAMM",
            "MSAMASMSMX",
            "XMASAMXAMM",
            "XXAMMXXAMA",
            "SMSMSASXSS",
            "SAXAMASAAA",
            "MAMMMXMMMM",
            "MXMXAXMASX"
    );

    @Test
    public void exampleCaseShouldPassChallenge1(){
        int expected = 18;
        int actual = AOCDay4.challenge1(challenge1TestData);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void exampleCaseShouldPassChallenge2(){
        int expected = 9;
        int actual = AOCDay4.challenge2(challenge1TestData);

        Assert.assertEquals(expected, actual);
    }
}