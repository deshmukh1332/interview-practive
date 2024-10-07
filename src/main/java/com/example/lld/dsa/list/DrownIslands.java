package com.example.lld.dsa.list;

import java.util.Arrays;

public class DrownIslands {
    public static void main(String[] args) {
        String[][] board = new String[][]{{"X", "X", "X", "X"}, {"X", "O", "O", "X"}, {"X", "O", "X", "X"}};
        System.out.println(Arrays.deepToString(board));
        System.out.println(Arrays.deepToString(solve(board)));
    }

    public static String[][] solve(String[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            if (board[i][0].equals("O")) {
                dfs(visit, board, i, 0, n, m, "Y");
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[i][m - 1].equals("O")) {
                dfs(visit, board, i, m - 1, n, m, "Y");
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[0][i].equals("O")) {
                dfs(visit, board, 0, i, n, m, "Y");
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[n - 1][i].equals("O")) {
                dfs(visit, board, n - 1, i, n, m, "Y");
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && board[i][j].equals("O")) {
                    dfs(visit, board, i, j, n, m, "X");
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && board[i][j].equals("O")) {
                    dfs(visit, board, i, j, n, m, "X");
                }
            }
        }
        return board;
    }

    public static void dfs(boolean[][] visit, String[][] board, int i, int j, int n, int m, String temp) {
        if (visit[i][j]) {
            return;
        }
        visit[i][j] = true;
        if (board[i - 1][j].equals("O")) {
            dfs(visit, board, i - 1, j, n, m, temp);
        }
        if (board[i][j - 1].equals("O")) {
            dfs(visit, board, i, j - 1, n, m, temp);
        }
        if (i < n - 1 && board[i + 1][j].equals("O")) {
            dfs(visit, board, i + 1, j, n, m, temp);
        }
        if (j < m - 1 && board[i][j + 1].equals("O")) {
            dfs(visit, board, i, j + 1, n, m, temp);
        }
        board[i][j] = temp;
    }
}

