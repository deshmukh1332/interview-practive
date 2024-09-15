package com.example.lld.dsa;

import java.util.Arrays;

public class UnionFind {
    private final int[] parent;
    private final int[] size;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(5);
        unionFind.union(0, 1);
        unionFind.union(1, 2);
        unionFind.union(3, 4);
        System.out.println(unionFind.find(0));
        System.out.println(unionFind.find(2));
        System.out.println(unionFind.find(3));
        System.out.println(Arrays.toString(unionFind.size));
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) {
            return;
        }
        if (size[xRoot] < size[yRoot]) {
            parent[xRoot] = yRoot;
            size[yRoot] += size[xRoot];
        } else if (size[xRoot] > size[yRoot]) {
            parent[yRoot] = xRoot;
            size[xRoot] += size[yRoot];
        } else {
            parent[yRoot] = xRoot;
            size[xRoot] += size[yRoot];
        }
    }
}
