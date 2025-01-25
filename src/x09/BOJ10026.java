package x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ10026 {

    static int N;
    static char[][] boardA = new char[100][100];
    static char[][] boardB = new char[100][100];
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static void bfs(int x, int y, char[][] board) {
        Deque<Cell> q = new ArrayDeque<>();
        q.offer(new Cell(x, y, board[x][y]));
        board[x][y] = '.';
        while (!q.isEmpty()) {
            Cell cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (board[nx][ny] != cur.color) continue;
                q.offer(new Cell(nx, ny, board[nx][ny]));
                board[nx][ny] = '.';
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int x = 0; x < N; x++) {
            char[] line = br.readLine().toCharArray();
            for (int y = 0; y < N; y++) {
                boardA[x][y] = line[y];
                boardB[x][y] = line[y];
                if (boardB[x][y] == 'G') boardB[x][y] = 'R';
            }
        }

        int a = 0, b = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (boardA[x][y] != '.') {
                    bfs(x, y, boardA);
                    a++;
                }
                if (boardB[x][y] != '.') {
                    bfs(x, y, boardB);
                    b++;
                }
            }
        }
        System.out.println(a + " " + b);
    }

    static class Cell {
        int x, y;
        char color;
        public Cell(int x, int y, char color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}
