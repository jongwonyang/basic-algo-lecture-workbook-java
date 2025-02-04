package x0C;

import java.util.Scanner;

public class BOJ9663 {

    static int N;
    static int[][] board = new int[15][15];
    static int ans = 0;
    static int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 }; // 상, 하, 좌, 우, 좌상, 우상, 좌하, 우하
    static int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 }; // 상, 하, 좌, 우, 좌상, 우상, 좌하, 우하

    static void func(int x) {
        if (x == N) {
            ans++;
            return;
        }

        for (int y = 0; y < N; y++) {
            if (board[x][y] != 0) continue;
            board[x][y]++;
            for (int d = 0; d < 8; d++) {
                int nx = x;
                int ny = y;
                while (true) {
                    nx = nx + dx[d];
                    ny = ny + dy[d];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;
                    board[nx][ny]++;
                }
            }
            func(x + 1);
            board[x][y]--;
            for (int d = 0; d < 8; d++) {
                int nx = x;
                int ny = y;
                while (true) {
                    nx = nx + dx[d];
                    ny = ny + dy[d];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;
                    board[nx][ny]--;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        func(0);
        System.out.println(ans);
    }
}
