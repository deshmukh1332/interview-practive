package com.example.lld.machine_coding.InMemoryRDB;

public class Column {
    String name;
    String type;

    public Column(String key, String value) {
        this.name = key;
        this.type = value;
    }
}
