package x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ1926 {

    static int N, M;
    static int[][] board = new int[500][500];
    static final int[] dx = { -1, 1, 0, 0 };
    static final int[] dy = { 0, 0, -1, 1 };

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

        int ans = 0, mx = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (board[x][y] == 1) {
                    int s = bfs(x, y);
                    mx = Math.max(mx, s);
                    ans++;
                }
            }
        }
        System.out.println(ans);
        System.out.println(mx);
    }

    static int bfs(int x, int y) {
        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(x, y));
        board[x][y] = 0;

        int ret = 0;
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            ret++;
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (board[nx][ny] == 0) continue;
                q.offer(new Pair(nx, ny));
                board[nx][ny] = 0;
            }
        }
        return ret;
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
