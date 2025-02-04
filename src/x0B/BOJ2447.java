package x0B;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2447 {

    static char[][] board = new char[6600][6600];

    static void func(int n, int x, int y) {
        if (n == 3) {
            board[x + 1][y + 1] = ' ';
            return;
        }

        int nn = n / 3;

        for (int nx = x + nn; nx < x + nn + nn; nx++) {
            for (int ny = y + nn; ny < y + nn + nn; ny++) {
                board[nx][ny] = ' ';
            }
        }

        func(nn, x, y);
        func(nn, x, y + nn);
        func(nn, x, y + nn + nn);
        func(nn, x + nn, y);
        func(nn, x + nn, y + nn + nn);
        func(nn, x + nn + nn, y);
        func(nn, x + nn + nn, y + nn);
        func(nn, x + nn + nn, y + nn + nn);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int x = 0; x < N; x++) Arrays.fill(board[x], '*');

        func(N, 0, 0);

        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) sb.append(board[x][y]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
