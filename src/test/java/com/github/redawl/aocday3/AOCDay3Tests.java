package com.github.redawl.aocday3;

import org.junit.Assert;
import org.junit.Test;

public class AOCDay3Tests {
    private static final String challenge1TestData = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";
    private static final String challenge2TestData = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))";

    @Test
    public void exampleCaseShouldPassChallenge1(){
        int expected = 161;
        int actual = AOCDay3.challenge1(challenge1TestData);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void exampleCaseShouldPassChallenge2(){
        int expected = 48;
        int actual = AOCDay3.challenge2(challenge2TestData);

        Assert.assertEquals(expected, actual);
    }
}