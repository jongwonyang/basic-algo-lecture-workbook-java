package x0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630 {

    static int N;
    static int[][] board = new int[128][128];
    static int[] cnt = new int[2];

    static void func(int n, int x, int y) {
        int color = board[x][y];
        boolean same = true;
        for (int nx = x; nx < x + n; nx++) {
            for (int ny = y; ny < y + n; ny++) {
                if (board[nx][ny] != color) same = false;
            }
        }
        if (same) cnt[color]++;
        else {
            func(n / 2, x, y);
            func(n / 2, x + n / 2, y);
            func(n / 2, x, y + n / 2);
            func(n / 2, x + n / 2, y + n / 2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int x = 0; x < N; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int y = 0; y < N; y++) {
                board[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        func(N, 0, 0);

        for (int i : cnt) System.out.println(i);
    }
}
