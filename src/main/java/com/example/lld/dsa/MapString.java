package com.example.lld.dsa;

import java.util.LinkedHashMap;

public class MapString {
    public static void main(String[] args) {
        System.out.println("Hello World");

        String s = "aabadegghhicde";
        System.out.println(find2ndDuplicate(s,2));
    }

    public static Character find2ndDuplicate(String s, int count) {
        Character ans = null;
        LinkedHashMap<Character , Integer> map = new LinkedHashMap<>();
        for (int i=0;i<s.length();i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            } else {
                map.putIfAbsent(c,1);
            }
        }
//        System.out.println(map);
        int index = 0;
        for (java.util.Map.Entry<Character,Integer> itr : map.entrySet()) {
            if (itr.getValue() == 1) {
                index ++;
            }
            if (index == count) {
                return itr.getKey();
            }
        }
        return ans;
    }
}