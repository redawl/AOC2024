package com.github.redawl.aocday7;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AOCDay7Tests {
    List<String> challenge1TestData = List.of(
            "190: 10 19",
            "3267: 81 40 27",
            "83: 17 5",
            "156: 15 6",
            "7290: 6 8 6 15",
            "161011: 16 10 13",
            "192: 17 8 14",
            "21037: 9 7 18 13",
            "292: 11 6 16 20"
    );

    @Test
    public void exampleCaseShouldPassChallenge1(){
        long expected = 3749;
        long actual = AOCDay7.challenge1(challenge1TestData);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void exampleCaseShouldPassChallenge2(){
        long expected = 11387;
        long actual = AOCDay7.challenge2(challenge1TestData);

        Assert.assertEquals(expected, actual);
    }
}