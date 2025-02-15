package x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14500 {

    static final int[][] tx = {
            { 0, 0, 0, 0 },
            { 0, 1, 2, 3 },
            { 0, 0, 1, 1 },
            { 0, 1, 2, 2 },
            { 0, 0, 0, 1 },
            { 0, 0, 1, 2 },
            { 0, 1, 1, 1 },
            { 0, 1, 2, 2 },
            { 0, 1, 1, 1 },
            { 0, 0, 1, 2 },
            { 0, 0, 0, 1 },
            { 0, 1, 1, 2 },
            { 0, 0, 1, 1 },
            { 0, 1, 1, 2 },
            { 0, 0, 1, 1 },
            { 0, 0, 0, 1 },
            { 0, 1, 1, 2 },
            { 0, 1, 1, 1 },
            { 0, 1, 1, 2 }
    };
    static final int[][] ty = {
            { 0, 1, 2, 3 },
            { 0, 0, 0, 0 },
            { 0, 1, 0, 1 },
            { 0, 0, 0, 1 },
            { 0, 1, 2, 0 },
            { 0, 1, 1, 1 },
            { 2, 0, 1, 2 },
            { 1, 1, 0, 1 },
            { 0, 0, 1, 2 },
            { 0, 1, 0, 0 },
            { 0, 1, 2, 2 },
            { 1, 0, 1, 0 },
            { 0, 1, 1, 2 },
            { 0, 0, 1, 1 },
            { 1, 2, 0, 1 },
            { 0, 1, 2, 1 },
            { 1, 0, 1, 1 },
            { 1, 0, 1, 2 },
            { 0, 0, 1, 0 }
    };

    static int N, M;
    static int[][] board = new int[500][500];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int x = 0; x < N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < M; y++) {
                board[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int t = 0; t < 19; t++) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    int sum = 0;
                    boolean valid = true;
                    for (int i = 0; i < 4; i++) {
                        int nx = x + tx[t][i];
                        int ny = y + ty[t][i];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                            valid = false;
                            break;
                        }
                        sum += board[nx][ny];
                    }
                    if (valid) ans = Math.max(ans, sum);
                }
            }
        }
        System.out.println(ans);
    }
}
