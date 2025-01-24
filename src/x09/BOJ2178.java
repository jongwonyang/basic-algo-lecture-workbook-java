package x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ2178 {

    static int N, M;
    static int[][] board = new int[100][100];
    static int[][] dist = new int[100][100];
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int x = 0; x < N; x++) {
            char[] line = br.readLine().toCharArray();
            for (int y = 0; y < M; y++) {
                board[x][y] = line[y] - '0';
            }
        }

        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(0, 0));
        dist[0][0] = 1;
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (board[nx][ny] == 0 || dist[nx][ny] != 0) continue;
                q.offer(new Pair(nx, ny));
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
            }
        }
        System.out.println(dist[N - 1][M - 1]);
    }

    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
