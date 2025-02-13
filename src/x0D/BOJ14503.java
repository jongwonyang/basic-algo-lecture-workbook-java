package x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503 {

    static int N, M, r, c, d;
    static int[][] board = new int[50][50];

    static final int[] dx = { -1, 0, 1, 0 };
    static final int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int x = 0; x < N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < M; y++) {
                board[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        while (true) {
            if (board[r][c] == 0) {
                board[r][c] = 2;
                ans++;
            }
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int nx = r + dx[d];
                int ny = c + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (board[nx][ny] == 0) {
                    r = nx;
                    c = ny;
                    break;
                }
            }
            if (board[r][c] == 2) {
                int nx = r + dx[(d + 2) % 4];
                int ny = c + dy[(d + 2) % 4];
                if (board[nx][ny] == 1) break;
                r = nx;
                c = ny;
            }
        }
        System.out.println(ans);
    }
}
