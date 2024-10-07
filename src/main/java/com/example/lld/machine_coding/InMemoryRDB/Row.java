package com.example.lld.machine_coding.InMemoryRDB;

import java.util.HashMap;
import java.util.Map;

public class Row {
    final String id;
    Map<String, String> values;

    public Row(String id) {
        this.id = id;
        this.values = new HashMap<>();
    }
}
