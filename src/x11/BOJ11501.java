package x11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11501 {

    static int T, N;
    static int[] P = new int[1000000];
    static int[] M = new int[1000000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                P[i] = Integer.parseInt(st.nextToken());
            }

            M[N - 1] = P[N - 1];
            for (int i = N - 2; i >= 0; i--) {
                M[i] = Math.max(M[i + 1], P[i]);
            }

            long cnt = 0;
            long val = 0;
            long ans = 0;
            for (int i = 0; i < N; i++) {
                if (P[i] < M[i]) {
                    cnt++;
                    val += P[i];
                } else {
                    ans += (P[i] * cnt) - val;
                    cnt = 0;
                    val = 0;
                }
            }
            System.out.println(ans);
        }
    }
}
