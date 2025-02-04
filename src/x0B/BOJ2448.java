package x0B;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2448 {

    static char[][] board = new char[4000][8000];

    static void func(int h, int x, int y) {
        if (h == 3) {
            board[x][y] = '*';
            board[x + 1][y - 1] = '*';
            board[x + 1][y + 1] = '*';
            board[x + 2][y - 2] = '*';
            board[x + 2][y - 1] = '*';
            board[x + 2][y] = '*';
            board[x + 2][y + 1] = '*';
            board[x + 2][y + 2] = '*';
            return;
        }

        int nh = h / 2;
        func(nh, x, y);
        func(nh, x + nh, y - nh);
        func(nh, x + nh, y + nh);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int x = 0; x < N; x++) Arrays.fill(board[x], ' ');

        func(N, 0, N - 1);

        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N + N - 1; y++) sb.append(board[x][y]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
