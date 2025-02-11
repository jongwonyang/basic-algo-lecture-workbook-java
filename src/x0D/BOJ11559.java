package x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11559 {

    static final int N = 12, M = 6;
    static final int[] dx = { -1, 1, 0, 0 };
    static final int[] dy = { 0, 0, -1, 1 };

    static char[][] board = new char[N][M];
    static boolean[][] vis = new boolean[N][M];
    static int ans = 0;

    static boolean bfs(int sx, int sy) {
        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(sx, sy));
        vis[sx][sy] = true;
        List<Pair> hist = new ArrayList<>();
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            hist.add(cur);
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (vis[nx][ny] || board[nx][ny] != board[cur.x][cur.y]) continue;
                q.offer(new Pair(nx, ny));
                vis[nx][ny] = true;
            }
        }
        if (hist.size() >= 4) {
            for (Pair h : hist) board[h.x][h.y] = '.';
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int x = 0; x < N; x++) {
            board[x] = br.readLine().toCharArray();
        }

        while (true) {
            boolean isPuyo = false;
            for (int x = 0; x < N; x++) Arrays.fill(vis[x], false);
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (vis[x][y] || board[x][y] == '.') continue;
                    boolean puyo = bfs(x, y);
                    if (puyo) isPuyo = true;
                }
            }

            if (isPuyo) ans++;
            else break;

            for (int y = 0; y < M; y++) {
                int i = N - 1;
                for (int x = N - 1; x >= 0; x--) {
                    if (board[x][y] == '.') continue;
                    char c = board[x][y];
                    board[x][y] = '.';
                    board[i--][y] = c;
                }
            }
        }

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
