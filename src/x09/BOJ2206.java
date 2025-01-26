package x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ2206 {

    static int N, M;
    static int[][] board = new int[1000][1000];
    static int[][][] dist = new int[1000][1000][2];
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

        Deque<Cell> q = new ArrayDeque<>();
        q.offer(new Cell(0, 0, 0));
        dist[0][0][0] = 1;
        while (!q.isEmpty()) {
            Cell cur =q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (dist[nx][ny][cur.z] != 0) continue;
                if (board[nx][ny] == 1) {
                    if (cur.z == 0 && dist[nx][ny][1] == 0) {
                        q.offer(new Cell(nx, ny, 1));
                        dist[nx][ny][1] = dist[cur.x][cur.y][0] + 1;
                    }
                } else {
                    q.offer(new Cell(nx, ny, cur.z));
                    dist[nx][ny][cur.z] = dist[cur.x][cur.y][cur.z] + 1;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        if (dist[N - 1][M - 1][0] != 0) min = Math.min(min, dist[N - 1][M - 1][0]);
        if (dist[N - 1][M - 1][1] != 0) min = Math.min(min, dist[N - 1][M - 1][1]);
        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    static class Cell {
        int x, y, z;
        public Cell(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
