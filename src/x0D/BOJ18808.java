package x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18808 {

    static int N, M, K, R, C;
    static int[][] board = new int[40][40];
    static int[][] sticker = new int[10][10];
    static int[][] tmp = new int[10][10];

    static boolean check(int x, int y) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (sticker[i][j] == 1 && board[x + i][y + j] == 1)
                    return false;
            }
        }
        return true;
    }

    static void rotate() {
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                tmp[x][y] = sticker[x][y];
            }
        }
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                sticker[y][R - 1 - x] = tmp[x][y];
            }
        }
        int r = R;
        R = C;
        C = r;
    }

    static void attach(int x, int y) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (sticker[i][j] == 1) board[x + i][y + j] = 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            for (int x = 0; x < R; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < C; y++) {
                    sticker[x][y] = Integer.parseInt(st.nextToken());
                }
            }

            boolean att = false;
            for (int r = 0; r < 4; r++) {
                for (int x = 0; x + R <= N; x++) {
                    for (int y = 0; y + C <= M; y++) {
                        if (check(x, y)) {
                            attach(x, y);
                            att = true;
                            break;
                        }
                    }
                    if (att) break;
                }
                if (att) break;
                rotate();
            }
        }

        int cnt = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (board[x][y] == 1) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
