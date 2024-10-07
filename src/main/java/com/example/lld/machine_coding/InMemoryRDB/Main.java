package com.example.lld.machine_coding.InMemoryRDB;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Database database = new Database("test");

        database.createTable("employee", new HashMap<String, String>() {{
            put("name", "String");
            put("dept", "String");
            put("age", "String");
        }});

        database.createTable("dept", new HashMap<String, String>() {{
            put("name", "String");
            put("head", "String");
        }});

        database.insertRow("employee", Arrays.asList("yash", "tech", "24")); // 1
        database.insertRow("employee", Arrays.asList("hari", "tech", "24")); // 2
        database.insertRow("employee", Arrays.asList("bob", "sales", "34")); // 3

        database.showTable("employee");
        database.deleteRow("employee", new HashMap<String, String>() {{
            put("name", "yash");
        }});
        System.out.println("Delete \n");
        database.showTable("employee");

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(database.updateRow("employee", new HashMap<String, String>() {{
            put("name", "yash");
        }}, new HashMap<String, String>() {{
            put("name", "test1");
        }}));
        executor.execute(database.updateRow("employee", new HashMap<String, String>() {{
            put("name", "yash");
        }}, new HashMap<String, String>() {{
            put("name", "test2");
        }}));

        database.showTable("employee");
    }
}
