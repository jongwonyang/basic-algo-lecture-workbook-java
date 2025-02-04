package x0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1992 {

    static int N;
    static int[][] board = new int[64][64];
    static StringBuilder sb = new StringBuilder();

    static void func(int d, int x, int y) {
        int color = board[x][y];
        boolean same = true;
        for (int nx = x; nx < x + d; nx++) {
            for (int ny = y; ny < y + d; ny++) {
                if (board[nx][ny] != color) same = false;
            }
        }
        if (same) sb.append(color);
        else {
            sb.append("(");
            func(d / 2, x, y);
            func(d / 2, x, y + d / 2);
            func(d / 2, x + d / 2, y);
            func(d / 2, x + d / 2, y + d / 2);
            sb.append(")");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int x = 0; x < N; x++) {
            char[] line = br.readLine().toCharArray();
            for (int y = 0; y < N; y++) {
                board[x][y] = line[y] - '0';
            }
        }

        func(N, 0, 0);
        System.out.println(sb);

    }
}
