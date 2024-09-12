package com.example.lld.dsa;

import org.apache.commons.math3.util.Pair;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Collections.emptyList()));
        adj.add(new ArrayList<>(Collections.singletonList(2)));
        adj.add(new ArrayList<>(Arrays.asList(1, 3)));
        adj.add(new ArrayList<>(Collections.singletonList(2)));
        System.out.println(new Solution().isCycle(4, adj));
    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i=0;i<V;i++) {
            if (!visited[i]) {
                topo(i, adj, visited, stack);
            }
        }
        int[] res = new int[V];
        for (int i=0;i<V;i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    private static void topo(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[i] = true;
        for (int j : adj.get(i)) {
            if (!visited[j]) {
                topo(j, adj, visited, stack);
            }
        }
        stack.push(i);
    }


    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        visited[0] = true;
        for (int i=0;i<V;i++) {
            if (!visited[i]) {
                if (cycle(i, adj, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean cycle(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent) {
        for (int j : adj.get(i)) {
            if (visited[j]) {
                return true;
            }
            visited[j] = true;
            if (cycle(j, adj, visited, i)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[V];
        bfs(0, adj, visited, res);
        return res;
    }

    private void bfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> res) {
        visited[i] = true;
        res.add(i);
        for (int j : adj.get(i)) {
            if (!visited[j]) {
                bfs(j, adj, visited, res);
            }
        }
    }
}
