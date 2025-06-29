package x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1932_1Indexed {

    static int N;
    static int[][] D = new int[501][501]; // D[i][j] = i번째 층의 j번째 숫자까지 도달했을 때 최대 합

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        D[1][1] = n;
        for (int i = 2; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= i; j++) {
                n = Integer.parseInt(st.nextToken());
                D[i][j] = Math.max(D[i - 1][j - 1], D[i - 1][j]) + n;
            }
        }

        int ans = -1;
        for (int j = 1; j <= N; j++) ans = Math.max(ans, D[N][j]);
        System.out.println(ans);
    }
}
