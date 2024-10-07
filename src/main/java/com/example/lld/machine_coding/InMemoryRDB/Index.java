package com.example.lld.machine_coding.InMemoryRDB;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Index {
    String name;
    Map<String, List<String>> columnNameIdMap;

    public Index(String name) {
        this.name = name;
        this.columnNameIdMap = new HashMap<>();
    }

//    tech -> [1,2]
//    sales -> [3]
}
