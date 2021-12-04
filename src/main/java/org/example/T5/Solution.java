package org.example.T5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: LKH
 * @Parameter: rows: 用于标记这一行是否已经放过棋子
 * clos: 用于标记这一列是否已经放过棋子
 * k:  k 个棋子
 */
public class Solution {

    static int n;
    static int k;
    static int ans;
    static boolean[] rows;
    static boolean[] cols;
    static char[][] chess;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            n = in.nextInt();
            k = in.nextInt();
            if (n == -1 && k == -1) {
                break;
            }
            ans = 0;
            chess = new char[n][n];
            rows = new boolean[n];
            cols = new boolean[n];
            Arrays.fill(rows, false);
            Arrays.fill(cols, false);
            for (int i = 0; i < n; i++) {
                String str = in.next();
                chess[i] = str.toCharArray();
            }

            dfs(0, 0);
            System.out.println(ans);
        }
    }

    /**
     * @param count 已经摆放好的棋子的数量
     */
    static void dfs(int count, int s) {
        // 如果棋子都放好了，就可以返回了
        if (count == k) {
            ans++;
            return;
        }
        // 每次都要从上一次放的下一行开始放
        for (int i = s; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] == false && cols[j] == false && chess[i][j] == '#') {
                    rows[i] = true;
                    cols[j] = true;
                    // 需要从当前行的下一行开始放。
                    dfs(count + 1, i + 1);
                    rows[i] = false;
                    cols[j] = false;
                }
            }
        }
    }
}
