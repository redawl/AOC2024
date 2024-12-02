package com.github.redawl.aocday1;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AOCDay1Tests {
    private final List<String> challenge1TestData = List.of("3   4",
            "4   3",
            "2   5",
            "1   3",
            "3   9",
            "3   3"
    );
    @Test
    public void exampleCaseShouldPassChallenge1(){
        int expected = 11;
        int actual = AOCDay1.challenge1(challenge1TestData);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void exampleCaseShouldPassChallenge2(){
        int expected = 31;
        int actual = AOCDay1.challenge2(challenge1TestData);

        Assert.assertEquals(expected, actual);
    }
}