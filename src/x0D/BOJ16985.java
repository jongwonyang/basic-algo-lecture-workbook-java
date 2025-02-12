package x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ16985 {

    static final int N = 5;
    static final int[] dx = { -1, 1, 0, 0, 0, 0 };
    static final int[] dy = { 0, 0, -1, 1, 0, 0 };
    static final int[] dz = { 0, 0, 0, 0, -1, 1 };

    static int[][][][] board = new int[5][4][5][5]; // [i][d][x][y]
    static int[][][] maze = new int[5][5][5]; // [x][y][z]
    static int[] lvl = new int[5];
    static boolean[] sel = new boolean[5];
    static int[] rot = new int[5];
    static int ans = Integer.MAX_VALUE;

    static void game() {
        for (int z = 0; z < N; z++) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    maze[x][y][z] = board[lvl[z]][rot[z]][x][y];
                }
            }
        }
        if (maze[0][0][0] == 0 || maze[N - 1][N - 1][N - 1] == 0) return;

        Deque<Cell> q = new ArrayDeque<>();
        int[][][] dist = new int[N][N][N];
        q.offer(new Cell(0, 0, 0));
        dist[0][0][0] = 1;
        while (!q.isEmpty()) {
            Cell cur = q.poll();
            for (int d = 0; d < 6; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                int nz = cur.z + dz[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || nz < 0 || nz >= N) continue;
                if (maze[nx][ny][nz] == 0 || dist[nx][ny][nz] != 0) continue;
                q.offer(new Cell(nx, ny, nz));
                dist[nx][ny][nz] = dist[cur.x][cur.y][cur.z] + 1;
            }
        }
        if (dist[N - 1][N - 1][N - 1] != 0) ans = Math.min(ans, dist[N - 1][N - 1][N - 1] - 1);
    }

    static void func2(int idx) {
        if (idx == N) {
            game();
            return;
        }

        for (int d = 0; d < 4; d++) {
            rot[idx] = d;
            func2(idx + 1);
        }
    }

    static void func1(int idx) {
        if (idx == N) {
            func2(0);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (sel[i]) continue;
            lvl[idx] = i;
            sel[i] = true;
            func1(idx + 1);
            sel[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < N; i++) {
            for (int x = 0; x < N; x++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int y = 0; y < N; y++) {
                    board[i][0][x][y] = Integer.parseInt(st.nextToken());
                }
            }
            for (int d = 1; d < 4; d++) {
                for (int x = 0; x < N; x++) {
                    for (int y = 0; y < N; y++) {
                        board[i][d][y][N - 1 - x] = board[i][d - 1][x][y];
                    }
                }
            }
        }

        func1(0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
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
