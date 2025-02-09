package x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15683 {

    static int N, M;
    static int[][] board = new int[8][8];
    static boolean[][] watch = new boolean[8][8];
    static List<Pair> cctv = new ArrayList<>();
    static int[] dir = new int[8]; // i번째 cctv가 보고있는 방향
    static int ans = Integer.MAX_VALUE;

    static final int[] dx = { 0, 1, 0, -1 }; // 우 하 좌 상
    static final int[] dy = { 1, 0, -1, 0 }; // 우 하 좌 상

    // i번 cctv가 j방향을 바라보고 있을 때 d
    static final int[][][] kind = {
            {},
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 3}, {0, 1}, {1, 2}, {2, 3}},
            {{0, 2, 3}, {0, 1, 3}, {0, 1, 2}, {1, 2, 3}},
            {{0, 1, 2, 3}}
    };

    static void func(int idx) {
        if (idx == cctv.size()) {
            for (int x = 0; x < N; x++) Arrays.fill(watch[x], false);
            for (int i = 0; i < cctv.size(); i++) {
                Pair cur = cctv.get(i);
                for (int d : kind[board[cur.x][cur.y]][dir[i]]) {
                    int nx = cur.x;
                    int ny = cur.y;
                    while (true) {
                        if (nx < 0 || nx >= N || ny < 0 || ny >= M) break;
                        if (board[nx][ny] == 6) break;
                        watch[nx][ny] = true;
                        nx += dx[d];
                        ny += dy[d];
                    }
                }
            }
            int cnt = 0;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (board[x][y] == 6) continue;
                    if (!watch[x][y]) cnt++;
                }
            }
            ans = Math.min(ans, cnt);
            return;
        }

        Pair cur = cctv.get(idx);
        for (int d = 0; d < kind[board[cur.x][cur.y]].length; d++) {
            dir[idx] = d;
            func(idx + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int x = 0; x < N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < M; y++) {
                board[x][y] = Integer.parseInt(st.nextToken());
                if (1 <= board[x][y] && board[x][y] <= 5) cctv.add(new Pair(x, y));
            }
        }

        func(0);

        System.out.println(ans);
    }

    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
