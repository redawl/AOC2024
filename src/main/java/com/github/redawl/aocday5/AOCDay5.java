package com.github.redawl.aocday5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.redawl.util.FileUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AOCDay5 {
    private static final Logger logger = LoggerFactory.getLogger(AOCDay5.class);

    private static final FileUtils fileUtils = FileUtils.getFileUtils();

    private record Rule(String r1, String r2) {}

    private static boolean isSorted(int index, List<Rule> rules, List<String> parts) {
        // Don't need to check last part
        if(index == parts.size() - 1) {
            return true;
        }

        for (int i = index + 1; i < parts.size(); i++) {
            boolean found = false;
            for (Rule rule: rules) {
                if(rule.r1.equals(parts.get(index)) && rule.r2.equals(parts.get(i))) {
                    found = true;
                    break;
                }
            }

            if(!found) {
                return false;
            }
        }

        return isSorted(index + 1, rules, parts);
    }

    private static List<String> sort(int index, List<Rule> rules, List<String> parts) {
        if (index == parts.size()) {
            return new ArrayList<>();
        }

        List<String> arr = sort(index + 1, rules, parts);

        String page = parts.get(index);
        if(arr.isEmpty()) {
            arr.add(page);
            return arr;
        } else {
            for(int i = 0; i < arr.size(); i++) {
                for(Rule rule: rules) {
                    if(rule.r1.equals(page) && rule.r2.equals(arr.get(i))) {
                        List<String> ret = new ArrayList<>(arr.subList(0, i));
                        ret.add(page);
                        ret.addAll(arr.subList(i, arr.size()));
                        return ret;
                    }
                }
            }
        }

        arr.add(page);
        return arr;
    }

    public static int challenge1(List<String> rules, List<String> updates){
        // Preprocess rules
        List<Rule> rulesProcessed = rules.stream().map((rule) -> {
            String [] parts = rule.split("\\|");
            return new Rule(parts[0], parts[1]);
        }).toList();

        return updates.stream().mapToInt((update) -> {
            List<String> parts = Arrays.stream(update.split(",")).toList();
            if(isSorted(0, rulesProcessed, parts)) {
                return Integer.parseInt(parts.get(parts.size() / 2));
            }

            return -1;
        }).filter((pageNum) -> pageNum >= 0).sum();
    }

    public static int challenge2(List<String> rules, List<String> updates){
        // Preprocess rules
        List<Rule> rulesProcessed = rules.stream().map((rule) -> {
            String [] parts = rule.split("\\|");
            return new Rule(parts[0], parts[1]);
        }).toList();

        return updates.stream().mapToInt((update) -> {
            List<String> parts = Arrays.stream(update.split(",")).toList();
            if(!isSorted(0, rulesProcessed, parts)) {
                List<String> sorted = sort(0, rulesProcessed, parts);
                return Integer.parseInt(sorted.get(sorted.size() / 2));
            }

            return -1;
        }).filter((pageNum) -> pageNum >= 0).sum();
    }

    public static void main(String [] args){
        List<String> parts = fileUtils.getFileContents("challenge5.txt", "\n\n").toList();

        List<String> rules = Arrays.stream(parts.get(0).split("\n")).toList();
        List<String> updates = Arrays.stream(parts.get(1).split("\n")).toList();

        logger.info("Answer 1: {}", challenge1(rules, updates));
        logger.info("Answer 2: {}", challenge2(rules, updates));
    }
}