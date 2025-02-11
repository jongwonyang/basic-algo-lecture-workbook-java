package x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14891 {

    static int[][] gear = new int[5][8];
    static int[] top = new int[5];

    static int left(int i) {
        return (top[i] + 6) % 8;
    }

    static int right(int i) {
        return (top[i] + 2) % 8;
    }

    static void rotate(int i, int d) {
        if (d == -1) top[i] = (top[i] + 1) % 8;
        else if (d == 1) top[i] = (top[i] + 7) % 8;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 4; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) gear[i][j] = line[j] - '0';
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int[] rot = new int[5];
            rot[n] = d;

            for (int nn = n - 1; nn >= 1; nn--) {
                if (gear[nn][right(nn)] != gear[nn + 1][left(nn + 1)]) rot[nn] = -rot[nn + 1];
                else break;
            }
            for (int nn = n + 1; nn <= 4; nn++) {
                if (gear[nn][left(nn)] != gear[nn - 1][right(nn - 1)]) rot[nn] = -rot[nn - 1];
                else break;
            }

            for (int j = 1; j <= 4; j++) {
                rotate(j, rot[j]);
            }
        }

        int ans = 0;
        if (gear[1][top[1]] == 1) ans += 1;
        if (gear[2][top[2]] == 1) ans += 2;
        if (gear[3][top[3]] == 1) ans += 4;
        if (gear[4][top[4]] == 1) ans += 8;
        System.out.println(ans);
    }
}
