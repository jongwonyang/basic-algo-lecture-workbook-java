package x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9461 {

    static int T, N;
    static long[] arr = { 0, 1, 1, 1, 2, 2 };
    static long[] P = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        P[1] = 1;
        P[2] = 1;
        P[3] = 1;
        P[4] = 2;
        P[5] = 2;
        for (int i = 6; i <= 100; i++) {
            int a = 5 - (i % 5);
            int b = a - 1;
            if (b == 0) b = 5;
            P[i] = arr[a] + arr[b];
            arr[b] = P[i];
        }

        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            sb.append(P[N]).append('\n');
        }
        System.out.println(sb);
    }
}
