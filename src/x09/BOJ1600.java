package x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ1600 {

    static int K, W, H;
    static int[][] board = new int[200][200];
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int[] dhx = { -2, -1, 1, 2, 2, 1, -1, -2 };
    static int[] dhy = { 1, 2, 2, 1, -1, -2, -2, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        for (int x = 0; x < H; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < W; y++) {
                board[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        Deque<Cell> q = new ArrayDeque<>();
        int[][][] dist = new int[H][W][K + 1];

        q.offer(new Cell(0, 0, 0));
        dist[0][0][0] = 1;

        while (!q.isEmpty()) {
            Cell cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
                if (board[nx][ny] == 1 || dist[nx][ny][cur.z] != 0) continue;
                q.offer(new Cell(nx, ny, cur.z));
                dist[nx][ny][cur.z] = dist[cur.x][cur.y][cur.z] + 1;
            }
            if (cur.z == K) continue;
            for (int d = 0; d < 8; d++) {
                int nx = cur.x + dhx[d];
                int ny = cur.y + dhy[d];
                if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;
                if (board[nx][ny] == 1 || dist[nx][ny][cur.z + 1] != 0) continue;
                q.offer(new Cell(nx, ny, cur.z + 1));
                dist[nx][ny][cur.z + 1] = dist[cur.x][cur.y][cur.z] + 1;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int z = 0; z <= K; z++) {
            if (dist[H - 1][W - 1][z] != 0) {
                ans = Math.min(ans, dist[H - 1][W - 1][z]);
            }
        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans - 1);
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
