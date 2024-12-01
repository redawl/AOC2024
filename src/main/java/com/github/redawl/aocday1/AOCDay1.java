package com.github.redawl.aocday1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.redawl.util.FileUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AOCDay1 {
    private static final Logger logger = LoggerFactory.getLogger(AOCDay1.class);

    private static final FileUtils fileUtils = FileUtils.getFileUtils();

    public static int challenge1(List<String> input){
        List<Integer> list1 = new ArrayList<>();

        List<Integer> list2 = new ArrayList<>();

        input.forEach((pair) -> {
            String[] parts = pair.split("\\s+");
            list1.add(Integer.parseInt(parts[0]));
            list2.add(Integer.parseInt(parts[1]));
        });

        list1.sort(Integer::compareTo);
        list2.sort(Integer::compareTo);

        assert list1.size() == list2.size();
        int answer = 0;
        for(int i = 0; i < list1.size(); i++){
            answer += Math.abs(list1.get(i) - list2.get(i));
        }

        return answer;
    }

    public static int challenge2(List<String> input){
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        input.forEach((pair) -> {
            String[] parts = pair.split("\\s+");
            list1.add(Integer.parseInt(parts[0]));
            list2.add(Integer.parseInt(parts[1]));
        });

        Map<Integer, Integer> cache = new HashMap<>();

        return list1.stream()
                .mapToInt(number -> {
                    if (cache.get(number) != null){
                        return cache.get(number);
                    }
                    int forCache = Math.toIntExact(number * list2.stream().filter(number2 -> number2.equals(number)).count());
                    cache.put(number, forCache);

                    return forCache;
                })
                .sum();
    }

    public static void main(String [] args){
        List<String> challenge1 = fileUtils.getFileContents("challenge1.txt").toList();

        logger.info("Answer 1: {}", challenge1(challenge1));
        logger.info("Answer 2: {}", challenge2(challenge1));
    }
}