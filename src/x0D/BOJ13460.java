package x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ13460 {

    static int N, M;
    static char[][] board = new char[10][10];

    static final int[] dx = { -1, 1, 0, 0 };
    static final int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Deque<State> q = new ArrayDeque<>();
        int rx = 0, ry = 0, bx = 0, by = 0;
        for (int x = 0; x < N; x++) {
            char[] line = br.readLine().toCharArray();
            for (int y = 0; y < M; y++) {
                board[x][y] = line[y];
                if (board[x][y] == 'R') {
                    board[x][y] = '.';
                    rx = x;
                    ry = y;
                }
                if (board[x][y] == 'B') {
                    board[x][y] = '.';
                    bx = x;
                    by = y;
                }
            }
        }
        q.offer(new State(rx, ry, bx, by, 0));

        while (!q.isEmpty()) {
            State cur = q.poll();
            if (cur.mv == 10) continue;
            for (int d = 0; d < 4; d++) {
                int nrx = cur.rx;
                int nry = cur.ry;
                int nbx = cur.bx;
                int nby = cur.by;
                boolean rout = false, bout = false;
                int rmv = 0, bmv = 0;
                while (true) {
                    if (board[nrx + dx[d]][nry + dy[d]] == '#') break;
                    if (board[nrx + dx[d]][nry + dy[d]] == 'O') {
                        rout = true;
                        break;
                    }
                    nrx += dx[d];
                    nry += dy[d];
                    rmv++;
                }
                while (true) {
                    if (board[nbx + dx[d]][nby + dy[d]] == '#') break;
                    if (board[nbx + dx[d]][nby + dy[d]] == 'O') {
                        bout = true;
                        break;
                    }
                    nbx += dx[d];
                    nby += dy[d];
                    bmv++;
                }
                if (bout) continue;
                if (rout) {
                    System.out.println(cur.mv + 1);
                    return;
                }
                if (nrx == nbx && nry == nby) {
                    if (rmv > bmv) {
                        nrx -= dx[d];
                        nry -= dy[d];
                    } else {
                        nbx -= dx[d];
                        nby -= dy[d];
                    }
                }
                q.offer(new State(nrx, nry, nbx, nby, cur.mv + 1));
            }
        }
        System.out.println(-1);
    }

    static class State {
        int rx, ry, bx, by, mv;
        public State(int rx, int ry, int bx, int by, int mv) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.mv = mv;
        }
    }
}
