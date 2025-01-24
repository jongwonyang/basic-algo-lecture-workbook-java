package x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ7576 {

    static int N, M;
    static int[][] board = new int[1000][1000];
    static Deque<Pair> q = new ArrayDeque<>();
    static int[][] dist = new int[1000][1000];
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for (int x = 0; x < N; x++) Arrays.fill(dist[x], -1);

        for (int x = 0; x < N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < M; y++) {
                board[x][y] = Integer.parseInt(st.nextToken());
                if (board[x][y] == 1) {
                    q.offer(new Pair(x, y));
                    dist[x][y] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (board[nx][ny] == -1 || dist[nx][ny] != -1) continue;
                q.offer(new Pair(nx, ny));
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
            }
        }

        int ans = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (board[x][y] != -1 && dist[x][y] == -1) {
                    System.out.println(-1);
                    return;
                }
                ans = Math.max(ans, dist[x][y]);
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
