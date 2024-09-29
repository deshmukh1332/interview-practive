package com.example.lld.dsa;


import org.apache.commons.math3.util.Pair;

import java.util.*;

public class MootsAlgo {

//    public static void main(String[] args) {
//        String s = "";
//        Stack<Character> stack = new Stack<>();
//        boolean ans = true;
//        for (int i = 0; i < s.length(); i++) {
//
//            System.out.println("Stack : " + stack);
//            if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{') {
//                stack.push(s.charAt(i));
//            } else {
//                if (s.charAt(i) == ']' && !stack.isEmpty() && stack.peek() != '[') {
//                    ans = false;
//                    break;
//                } else if (!stack.isEmpty()) {
//                    stack.pop();
//                }
//                if (s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() != '(') {
//                    ans = false;
//                    break;
//                } else if (!stack.isEmpty()) {
//                    stack.pop();
//                }
//                if (s.charAt(i) == '}' && !stack.isEmpty() && stack.peek() != '{') {
//                    ans = false;
//                    break;
//                } else if (!stack.isEmpty()) {
//                    stack.pop();
//                }
//            }
//        }
//        System.out.println("Hello World");
//        System.out.println("Answer : " + ans);
//    }
//
//    public static void main(String[] args) {
//        int[] arr = new int[]{1, 1, 2, 1, 3, 1, 4, 5, 2};
//
//        int majority = arr[0], count = 1;
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i] == majority) {
//                count++;
//            } else {
//                count--;
//            }
//            if (count <= 0) {
//                majority = arr[i];
//                count = 1;
//            }
//            System.out.println("count : " + count + " majority : " + majority);
//        }
//        int ans = -1, max_count = arr.length / 2, current_count = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == majority) {
//                current_count++;
//            }
//        }
//        if (current_count > max_count) {
//            ans = majority;
//        }
//        System.out.println("Answer : " + ans);
//    }

    public static void main(String[] args) {
        String s = "abcdaeec";

        Map<Character, Pair<Integer, Integer>> intervals = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (intervals.containsKey(c)) {
                intervals.put(c, Pair.create(intervals.get(c).getFirst(), i));
            } else {
                intervals.put(c, Pair.create(i, i));
            }
        }

        List<Pair<Integer, Integer>> intervalList = new ArrayList<>(intervals.values());

        intervalList.sort(Comparator.comparingInt(Pair::getFirst));
        System.out.println(intervalList);

        int node = 1;
        Pair<Integer, Integer> base = intervalList.get(0);
        Pair<Integer, Integer> temp;
        for (int i=1;i<intervalList.size();i++) {
            temp = intervalList.get(i);
            if (temp.getFirst() >= base.getFirst() && temp.getSecond() <= base.getSecond()) {
                continue;
            }
            if (temp.getFirst() <= base.getSecond()) {
                base = new Pair<>(base.getFirst(), temp.getSecond());
            } else {
                base = temp;
                node++;
            }
        }

        System.out.println(node);
    }
}