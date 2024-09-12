package com.example.lld.dsa;

import org.apache.commons.math3.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {
    public static void main(String[] args) {
        String[] grid = {"ab" , "bc", "cd", "da"};
        System.out.println(new Graph().isCircle(grid));
    }
    public int isCircle(String[] arr) {
        Map<Character, List<String>> characterStringHashMap = new HashMap<>();
        for (String s : arr) {
            Character c = s.charAt(0);
            characterStringHashMap.putIfAbsent(c, new ArrayList<>());
            characterStringHashMap.get(c).add(s);
        }

        Map<String, List<String>> graph = new HashMap<>();
        for (String s : arr) {
            Character end = s.charAt(s.length() - 1);
            graph.put(s, characterStringHashMap.get(end));
        }
        Map<String, Boolean> visited = Arrays.stream(arr).collect(Collectors.toMap(s -> s, s -> false, (a, b) -> b));
        return isCircleDfs(graph, visited, arr[0], arr[0]);
    }

    private int isCircleDfs(Map<String, List<String>> graph, Map<String, Boolean> visited, String s, String s1) {
        if (s.equals(s1) && visited.get(s)) {
            return 1;
        }
        if (visited.get(s)) {
            return 0;
        }
        visited.put(s, true);
        for (String next : graph.get(s)) {
            if (isCircleDfs(graph, visited, next, s1) == 1) {
                return 1;
            }
        }
        visited.put(s, false);
        return 0;
    }

    //Function to find whether a path exists from the source to destination.
    public int is_Possible(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = grid[0][0];
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        Pair<Integer,Integer> start = new Pair<>(0, 0);
        queue.add(start);
        while (!queue.isEmpty()) {
            Pair<Integer,Integer> u = queue.poll();
            int i = u.getFirst();
            int j = u.getSecond();
            if (i - 1 >= 0 && dist[i - 1][j] > dist[i][j] + grid[i - 1][j]) {
                dist[i - 1][j] = dist[i][j] + grid[i - 1][j];
                queue.add(new Pair<>(i - 1, j));
            }
            if (i + 1 < n && dist[i + 1][j] > dist[i][j] + grid[i + 1][j]) {
                dist[i + 1][j] = dist[i][j] + grid[i + 1][j];
                queue.add(new Pair<>(i + 1, j));
            }
            if (j - 1 >= 0 && dist[i][j - 1] > dist[i][j] + grid[i][j - 1]) {
                dist[i][j - 1] = dist[i][j] + grid[i][j - 1];
                queue.add(new Pair<>(i, j - 1));
            }
            if (j + 1 < m && dist[i][j + 1] > dist[i][j] + grid[i][j + 1]) {
                dist[i][j + 1] = dist[i][j] + grid[i][j + 1];
                queue.add(new Pair<>(i, j + 1));
            }
        }
        return dist[n-1][m-1];
    }

    private boolean bfs(int[][] grid, Pair<Integer, Integer> start, boolean[][] visited, int n, int m) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(start);
        visited[start.getFirst()][start.getSecond()] = true;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> u = queue.poll();
            int i = u.getFirst();
            int j = u.getSecond();
            if (grid[i][j] == 2) {
                return true;
            }
            if (i - 1 >= 0 && grid[i - 1][j] > 1 && !visited[i - 1][j]) {
                queue.add(new Pair<>(i - 1, j));
                visited[i - 1][j] = true;
            }
            if (i + 1 < n && grid[i + 1][j] > 1 && !visited[i + 1][j]) {
                queue.add(new Pair<>(i + 1, j));
                visited[i + 1][j] = true;
            }
            if (j - 1 >= 0 && grid[i][j - 1] > 1 && !visited[i][j - 1]) {
                queue.add(new Pair<>(i, j - 1));
                visited[i][j - 1] = true;
            }
            if (j + 1 < m && grid[i][j + 1] > 1 && !visited[i][j + 1]) {
                queue.add(new Pair<>(i, j + 1));
                visited[i][j + 1] = true;
            }
        }
        return false;
    }

    public int shortestDistance(int N, int M, int[][] A, int X, int Y) {
        // code here
        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], N*M);
        }
        dist[0][0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] u = queue.poll();
            int i = u[0];
            int j = u[1];
            if (i == X && j == Y) {
                break;
            }
            if (A[i][j] != 1) {
                continue;
            }
            if (i - 1 >= 0 && A[i - 1][j] == 1 && dist[i - 1][j] > dist[i][j] + 1) {
                dist[i - 1][j] = dist[i][j] + 1;
                queue.add(new int[]{i - 1, j});
            }
            if (i + 1 < N && A[i + 1][j] == 1 && dist[i + 1][j] > dist[i][j] + 1) {
                dist[i + 1][j] = dist[i][j] + 1;
                queue.add(new int[]{i + 1, j});
            }
            if (j - 1 >= 0 && A[i][j - 1] == 1 && dist[i][j - 1] > dist[i][j] + 1) {
                dist[i][j - 1] = dist[i][j] + 1;
                queue.add(new int[]{i, j - 1});
            }
            if (j + 1 < M && A[i][j + 1] == 1 && dist[i][j + 1] > dist[i][j] + 1) {
                dist[i][j + 1] = dist[i][j] + 1;
                queue.add(new int[]{i, j + 1});
            }
        }
        return dist[X][Y] == Integer.MAX_VALUE ? -1 : dist[X][Y];
    }

    public int kosaraju(int n, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adj, i, visited, s);
            }
        }
        ArrayList<ArrayList<Integer>> adjTranspose = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjTranspose.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j : adj.get(i)) {
                adjTranspose.get(j).add(i);
            }
        }
        Arrays.fill(visited, false);
        int count = 0;
        while (!s.isEmpty()) {
            int i = s.pop();
            if (!visited[i]) {
                dfs(adjTranspose, i, visited, new Stack<>());
                count++;
            }
        }
        return count;
    }

    private void dfs(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited, Stack<Integer> s) {
        visited[i] = true;
        for (int j : adj.get(i)) {
            if (!visited[j]) {
                dfs(adj, j, visited, s);
            }
        }
        s.push(i);
    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Write your code here
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (ArrayList<Integer> edge : adj.get(u)) {
                int v = edge.get(0);
                int w = edge.get(1);
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    queue.add(v);
                }
            }
        }
        return dist;
    }

    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    roamIsland(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void roamIsland(int i, int j, char[][] grid, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        roamIsland(i + 1, j, grid, visited);
        roamIsland(i - 1, j, grid, visited);
        roamIsland(i, j + 1, grid, visited);
        roamIsland(i, j - 1, grid, visited);
        roamIsland(i + 1, j + 1, grid, visited);
        roamIsland(i - 1, j - 1, grid, visited);
        roamIsland(i + 1, j + 1, grid, visited);
        roamIsland(i - 1, j - 1, grid, visited);
    }
}
