package com.github.redawl.aocday5;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AOCDay5Tests {

    private static final List<String> rules = List.of(
            "47|53",
                    "97|13",
                    "97|61",
                    "97|47",
                    "75|29",
                    "61|13",
                    "75|53",
                    "29|13",
                    "97|29",
                    "53|29",
                    "61|53",
                    "97|53",
                    "61|29",
                    "47|13",
                    "75|47",
                    "97|75",
                    "47|61",
                    "75|61",
                    "47|29",
                    "75|13",
                    "53|13"
    );

    private static final List<String> updates = List.of(
                    "75,47,61,53,29",
                    "97,61,53,29,13",
                    "75,29,13",
                    "75,97,47,61,53",
                    "61,13,29",
                    "97,13,75,29,47"
    );

    @Test
    public void exampleCaseShouldPassChallenge1(){
        int expected = 143;
        int actual = AOCDay5.challenge1(rules, updates);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void exampleCaseShouldPassChallenge2(){
        int expected = 123;
        int actual = AOCDay5.challenge2(rules, updates);

        Assert.assertEquals(expected, actual);
    }
}