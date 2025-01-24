package x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ4179 {

    static int R, C;
    static char[][] board = new char[1000][1000];
    static int[][] distJ = new int[1000][1000];
    static int[][] distF = new int[1000][1000];
    static Deque<Pair> qJ = new ArrayDeque<>();
    static Deque<Pair> qF = new ArrayDeque<>();
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for (int x = 0; x < R; x++) {
            Arrays.fill(distJ[x], -1);
            Arrays.fill(distF[x], Integer.MAX_VALUE);
        }

        for (int x = 0; x < R; x++) {
            char[] line = br.readLine().toCharArray();
            for (int y = 0; y < C; y++) {
                board[x][y] = line[y];
                if (board[x][y] == 'J') {
                    qJ.offer(new Pair(x, y));
                    distJ[x][y] = 0;
                }
                if (board[x][y] == 'F') {
                    qF.offer(new Pair(x, y));
                    distF[x][y] = 0;
                }
            }
        }

        while (!qF.isEmpty()) {
            Pair cur = qF.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (board[nx][ny] == '#' || distF[nx][ny] != Integer.MAX_VALUE) continue;
                qF.offer(new Pair(nx, ny));
                distF[nx][ny] = distF[cur.x][cur.y] + 1;
            }
        }

        while (!qJ.isEmpty()) {
            Pair cur = qJ.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    System.out.println(distJ[cur.x][cur.y] + 1);
                    return;
                }
                if (board[nx][ny] == '#' || distF[nx][ny] <= distJ[cur.x][cur.y] + 1 || distJ[nx][ny] != -1) continue;
                qJ.offer(new Pair(nx, ny));
                distJ[nx][ny] = distJ[cur.x][cur.y] + 1;
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
