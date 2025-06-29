package x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1932 {

    static int N;
    static int[][] D = new int[500][500]; // D[i][j] = i층의 j번째 숫자까지 도달했을 때 최대 합

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        D[0][0] = n;
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j <= i; j++) {
                n = Integer.parseInt(st.nextToken());

                if (j != 0) D[i][j] = Math.max(D[i][j], D[i - 1][j - 1]);
                if (j != i) D[i][j] = Math.max(D[i][j], D[i - 1][j]);
                D[i][j] += n;
            }
        }

        int ans = -1;
        for (int j = 0; j < N; j++) ans = Math.max(ans, D[N - 1][j]);
        System.out.println(ans);
    }
}
