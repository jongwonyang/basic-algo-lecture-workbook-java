package x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1003_2D {

    static int[][] D = new int[41][2]; // D[i][j] = i를 호출했을 때 j(0 또는 1)가 출력되는 횟수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        D[0][0] = 1;
        D[0][1] = 0;
        D[1][0] = 0;
        D[1][1] = 1;
        for (int i = 2; i <= 40; i++) {
            D[i][0] = D[i - 1][0] + D[i - 2][0];
            D[i][1] = D[i - 1][1] + D[i - 2][1];
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(D[N][0]).append(' ').append(D[N][1]).append('\n');
        }
        System.out.println(sb);
    }
}
