package com.example.lld.dsa;

import java.util.*;

public class Recursion {
    public static void main(String[] args) {
        String digits = "";
        List<String> ans = letterCombinations(digits);
        System.out.println(ans);
    }


    public static List<String> letterCombinations(String digits) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        if (digits.isEmpty()) {
            return list;
        }
        map.put("2", Arrays.asList("a", "b", "c"));
        map.put("3", Arrays.asList("d", "e", "f"));
        map.put("4", Arrays.asList("g", "h", "i"));
        map.put("5", Arrays.asList("j", "k", "l"));
        map.put("6", Arrays.asList("m", "n", "o"));
        map.put("7", Arrays.asList("p", "q", "r", "s"));
        map.put("8", Arrays.asList("t", "u", "v"));
        map.put("9", Arrays.asList("w", "x", "y", "z"));
        return helper(list, digits, 0, map);
    }

    public static List<String> helper(List<String> list, String digits, int size, Map<String, List<String>> map) {
        List<String> ans = new ArrayList<>();
        List<String> keys = map.get(digits.substring(size, size + 1));
        if (size == digits.length() - 1) {
            return keys;
        }
        List<String> next = helper(list, digits, size + 1, map);
        for (String key : keys) {
            for (String n : next) {
                ans.add(key + n);
            }
        }
        return ans;
    }

}
