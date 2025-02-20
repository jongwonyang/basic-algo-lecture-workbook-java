package x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ14502 {

    static int N, M;
    static int[][] board = new int[8][8];
    static int ans = 0;

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static void go() {
        int[][] boardCopy = new int[N][M];
        Deque<Pair> q = new ArrayDeque<>();
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                boardCopy[x][y] = board[x][y];
                if (boardCopy[x][y] == 2) q.offer(new Pair(x, y));
            }
        }
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (boardCopy[nx][ny] != 0) continue;
                boardCopy[nx][ny] = 2;
                q.offer(new Pair(nx, ny));
            }
        }
        int safe = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (boardCopy[x][y] == 0) safe++;
            }
        }
        ans = Math.max(ans, safe);
    }

    static void func(int cnt, int st) {
        if (cnt == 3) {
            go();
            return;
        }

        for (int i = st; i < N * M; i++) {
            if (board[i / M][i % M] != 0) continue;
            board[i / M][i % M] = 1;
            func(cnt + 1, i + 1);
            board[i / M][i % M] = 0;
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
            }
        }

        func(0, 0);
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
