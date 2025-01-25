package x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ7569 {

    static int M, N, H;
    static int[][][] board = new int[100][100][100];
    static Deque<Cell> q = new ArrayDeque<>();
    static int[] dx = { -1, 1, 0, 0, 0, 0 };
    static int[] dy = { 0, 0, -1, 1, 0, 0 };
    static int[] dz = { 0, 0, 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        for (int z = 0; z < H; z++) {
            for (int x = 0; x < N; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < M; y++) {
                    board[x][y][z] = Integer.parseInt(st.nextToken());
                    if (board[x][y][z] == 1) q.offer(new Cell(x, y, z));
                }
            }
        }

        while (!q.isEmpty()) {
            Cell cur = q.poll();
            for (int d = 0; d < 6; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                int nz = cur.z + dz[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H) continue;
                if (board[nx][ny][nz] != 0) continue;
                q.offer(new Cell(nx, ny, nz));
                board[nx][ny][nz] = board[cur.x][cur.y][cur.z] + 1;
            }
        }

        int ans = 1;
        for (int z = 0; z < H; z++) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (board[x][y][z] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    ans = Math.max(ans, board[x][y][z]);
                }
            }
        }
        System.out.println(ans - 1);
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
