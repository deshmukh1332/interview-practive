package com.example.lld.machine_coding.InMemoryRDB;

import java.util.ArrayList;
import java.util.List;

public class Table {
    String name;
    List<Column> columnList;
    List<Row> rowList;
    List<Index> indexList;

    Table(String name) {
        this.name = name;
        this.columnList = new ArrayList<>();
        this.rowList = new ArrayList<>();
        this.indexList = new ArrayList<>();
    }

}
