package com.example.lld.machine_coding.InMemoryRDB;

import java.util.*;

public class Database {
    String name;
    Map<String, Table> tableList;

    public Database(String name) {
        this.name = name;
        this.tableList = new HashMap<>();
    }

    public void createTable(String name, Map<String, String> columnList) {
        Table table = new Table(name);
        for (Map.Entry<String, String> column : columnList.entrySet()) {
            table.columnList.add(new Column(column.getKey(), column.getValue()));
        }
        tableList.putIfAbsent(name, table);
    }

    public void deleteTable(String name) {
        tableList.remove(name);
    }

    // Insert row
    public String insertRow(String name, List<String> valueList) {
        Table table = tableList.get(name);
        if (table == null) {
            return null;
        }
        List<Column> columnList = table.columnList;
        Row row = new Row(UUID.randomUUID().toString());
        row.values.put("id", row.id);
        for (int i = 0; i < columnList.size(); i++) {
            Column column = columnList.get(i);
            row.values.put(column.name, valueList.get(i));
            table.rowList.add(row);
        }
        return row.id;
    }
    // Update row
    // update table set name = "test", depy"tre  where name = "efibjve";

    public Runnable updateRow(String name, Map<String, String> valueMap, Map<String, String> whereMap) {
        Table table = tableList.get(name);
        if (table == null) {
            return null;
        }
        for (Map.Entry<String, String> where : whereMap.entrySet()) {
            for (Row row : table.rowList) {
                if (where.getValue().equals(row.values.get(where.getKey()))) {
                    synchronized (row.id) {
                        row.values.putAll(valueMap);
                        // 4 sec
                    }
                }
            }
        }
        return null;
    }
    // Delete row

    // delete from table where name = "efibjve";
    public void deleteRow(String name, Map<String, String> whereMap) {
        Table table = tableList.get(name);
        if (table == null) {
            return;
        }
        for (Map.Entry<String, String> where : whereMap.entrySet()) {
            table.rowList.removeIf(row -> where.getValue().equals(row.values.get(where.getKey())));
        }
    }

    //create index
    public void createIndex(String name, String columnName) {
        Table table = tableList.get(name);
        if (table == null) {
            return;
        }
        Index index = new Index(name + columnName);
        for (Row row : table.rowList) {
            String value = row.values.get(columnName);
            index.columnNameIdMap.putIfAbsent(value, new ArrayList<>());
            index.columnNameIdMap.get(value).add(row.id);
        }
    }

    public boolean showTable(String name) {
        Table table = tableList.get(name);
        if (table == null) {
            return false;
        }
        for (Row row : table.rowList) {
            System.out.println(row.values);
        }
        return false;
    }
}
