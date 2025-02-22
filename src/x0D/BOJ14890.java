package x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14890 {

    static int N, L;
    static int[][] board = new int[100][100];
    static boolean[] used = new boolean[100];
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        for (int x = 0; x < N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < N; y++) {
                board[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        for (int x = 0; x < N; x++) {
            Arrays.fill(used, false);
            boolean pass = true;
            int cy = 0;
            for (int ny = 1; ny < N; ny++) {
                if (board[x][cy] == board[x][ny]) {
                    cy++;
                    continue;
                }
                if (board[x][cy] + 1 == board[x][ny]) {
                    for (int i = 0; i < L; i++) {
                        int py = cy - i;
                        if (py < 0 || board[x][py] != board[x][cy] || used[py]) {
                            pass = false;
                            break;
                        }
                        used[py] = true;
                    }
                    cy++;
                    continue;
                }
                if (board[x][cy] - 1 == board[x][ny]) {
                    for (int i = 0; i < L; i++) {
                        int nny = ny + i;
                        if (nny >= N || board[x][ny] != board[x][nny] || used[nny]) {
                            pass = false;
                            break;
                        }
                        used[nny] = true;
                    }
                    cy++;
                    continue;
                }
                pass = false;
                break;
            }
            if (pass) ans++;
        }

        for (int y = 0; y < N; y++) {
            Arrays.fill(used, false);
            boolean pass = true;
            int cx = 0;
            for (int nx = 1; nx < N; nx++) {
                if (board[cx][y] == board[nx][y]) {
                    cx++;
                    continue;
                }
                if (board[cx][y] + 1 == board[nx][y]) {
                    for (int i = 0; i < L; i++) {
                        int px = cx - i;
                        if (px < 0 || board[px][y] != board[cx][y] || used[px]) {
                            pass = false;
                            break;
                        }
                        used[px] = true;
                    }
                    cx++;
                    continue;
                }
                if (board[cx][y] - 1 == board[nx][y]) {
                    for (int i = 0; i < L; i++) {
                        int nnx = nx + i;
                        if (nnx >= N || board[nx][y] != board[nnx][y] || used[nnx]) {
                            pass = false;
                            break;
                        }
                        used[nnx] = true;
                    }
                    cx++;
                    continue;
                }
                pass = false;
                break;
            }
            if (pass) ans++;
        }

        System.out.println(ans);
    }
}
