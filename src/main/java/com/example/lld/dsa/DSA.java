package com.example.lld.dsa;

import java.util.Arrays;
import java.util.Queue;

public class DSA {
    public static void main(String[] args) {
        String word = "ACDEG";

        char[][] graph = new char[][]{
            {'A', 'C', 'C'},
            {'C', 'D', 'E'},
            {'E', 'F', 'G'},
            {'A', 'B', 'C'},
            {'C', 'D', 'E'},
            {'E', 'F', 'G'}
        };

        System.out.println(Arrays.deepToString(isWordPresent(word, graph)));
    }

    static int[][] isWordPresent(String word, char[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        for (int i = 0; i < n; i++) { // n = graph length
            for (int j = 0; j < m; j++) {   // n graph[0] length
                if (graph[i][j] == word.charAt(0)) {
                    int[][] result = new int[word.length()][2];
                    if (bfs(graph, i, j, n, m, word, result)) { // n*n = word length
                        return result;
                    }
                }
            }
        }
        return new int[][]{};
    }

    private static boolean bfs(char[][] graph, int i, int j, int n, int m, String word, int[][] result) {
        boolean[][] visited = new boolean[n][m];
        visited[i][j] = true;
        Queue<int[]> queue = new java.util.LinkedList<>();
        int index = 1;
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            result[index-1] = curr;
            if (word.charAt(word.length() - 1) == graph[curr[0]][curr[1]]) {
                return true;
            }
            if (index == word.length()) {
                return false;
            }
            i = curr[0];
            j = curr[1];

            if (i > 0 && !visited[i - 1][j] && graph[i - 1][j] == word.charAt(index)) {
                queue.add(new int[]{i - 1, j});
                visited[i - 1][j] = true;
            }
            if (i < n - 1 && !visited[i + 1][j] && graph[i + 1][j] == word.charAt(index)) {
                queue.add(new int[]{i + 1, j});
                visited[i + 1][j] = true;
            }
            if (j > 0 && !visited[i][j - 1] && graph[i][j - 1] == word.charAt(index)) {
                queue.add(new int[]{i, j - 1});
                visited[i - 1][j] = true;
            }
            if (j < m - 1 && !visited[i][j + 1] && graph[i][j + 1] == word.charAt(index)) {
                queue.add(new int[]{i, j + 1});
                visited[i][j + 1] = true;
            }
            index++;
        }
        return false;
    }
}
