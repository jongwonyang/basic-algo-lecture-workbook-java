package x0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1780 {

    static int N;
    static int[][] board = new int[2200][2200];
    static int[] cnt = new int[3];

    static void func(int n, int sx, int sy) {
        int num = board[sx][sy];
        boolean same = true;
        for (int x = sx; x < sx + n; x++) {
            for (int y = sy; y < sy + n; y++) {
                if (board[x][y] != num) {
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }
        if (same) cnt[num + 1]++;
        else {
            int d = n / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    func(d, sx + (i * d), sy + (j * d));
                }
            }
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

        for (int c : cnt) System.out.println(c);
    }
}
