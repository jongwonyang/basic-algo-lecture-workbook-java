package x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15684 {

    static int N, M, H;
    static int[][] board = new int[31][11]; // [M][N]
    static int ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a][b] = 1;
            board[a][b + 1] = 2;
        }

        for (int lim = 0; lim <= 3; lim++) {
            func(0, lim);
            if (ans != -1) break;
        }

        System.out.println(ans);
    }

    static void func(int cnt, int lim) {
        if (cnt == lim) {
            if (check()) ans = cnt;
            return;
        }

        for (int n = 1; n < N; n++) {
            for (int h = 1; h <= H; h++) {
                if (board[h][n] != 0 || board[h][n + 1] != 0) continue;
                board[h][n] = 1;
                board[h][n + 1] = 2;
                func(cnt + 1, lim);
                board[h][n] = 0;
                board[h][n + 1] = 0;
            }
        }
    }

    static void printBoard() {
        for (int h = 1; h <= H; h++) {
            for (int n = 1; n <= N; n++) {
                System.out.print(board[h][n] + " ");
            }
            System.out.println();
        }
    }

    static int go(int start) {
        int n = start;
        for (int h = 1; h <= H; h++) {
            if (board[h][n] == 0) continue;
            if (board[h][n] == 1) n++;
            else if (board[h][n] == 2) n--;
        }
        return n;
    }

    static boolean check() {
        boolean res = true;
        for (int i = 1; i <= N; i++) {
            if (i != go(i)) {
                res = false;
                break;
            }
        }
        return res;
    }
}
