package com.github.redawl.aocday2;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AOCDay2Tests {
    private static List<String> challenge1TestData = List.of(
            "7 6 4 2 1",
            "1 2 7 8 9",
            "9 7 6 2 1",
            "1 3 2 4 5",
            "8 6 4 4 1",
            "1 3 6 7 9"
    );
    @Test
    public void exampleCaseShouldPassChallenge1(){
        int expected = 2;
        int actual = AOCDay2.challenge1(challenge1TestData);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void exampleCaseShouldPassChallenge2(){
        int expected = 4;
        int actual = AOCDay2.challenge2(challenge1TestData);
        Assert.assertEquals(expected, actual);
    }
}