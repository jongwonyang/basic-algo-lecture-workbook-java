package x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14499 {

    static int N, M, x, y, K;
    static int[][] board = new int[20][20];
    static int[] dice = { 0, 0, 0, 0, 0, 0, 0 };
    static StringBuilder sb = new StringBuilder();

    static final int[] dx = { 0, 0, 0, -1, 1 };
    static final int[] dy = { 0, 1, -1, 0, 0 };

    static void move(int d) {
        int nx = x + dx[d];
        int ny = y + dy[d];
        if (nx < 0 || nx >= N || ny < 0 || ny >= M) return;
        x = nx;
        y = ny;

        if (d == 1) { // 동
            int tmp = dice[1];
            dice[1] = dice[4];
            dice[4] = dice[6];
            dice[6] = dice[3];
            dice[3] = tmp;
        } else if (d == 2) { // 서
            int tmp = dice[1];
            dice[1] = dice[3];
            dice[3] = dice[6];
            dice[6] = dice[4];
            dice[4] = tmp;
        } else if (d == 3) { // 북
            int tmp = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[6];
            dice[6] = dice[2];
            dice[2] = tmp;
        } else { // 남
            int tmp = dice[1];
            dice[1] = dice[2];
            dice[2] = dice[6];
            dice[6] = dice[5];
            dice[5] = tmp;
        }

        if (board[x][y] == 0) board[x][y] = dice[6];
        else {
            dice[6] = board[x][y];
            board[x][y] = 0;
        }

        sb.append(dice[1]).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int x = 0; x < N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < M; y++) {
                board[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < K; k++) {
            move(Integer.parseInt(st.nextToken()));
        }
        System.out.println(sb);
    }
}
