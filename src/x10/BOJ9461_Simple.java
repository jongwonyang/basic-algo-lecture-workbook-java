package x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9461_Simple {

    static int T, N;
    static long[] D = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        D[1] = 1;
        D[2] = 1;
        D[3] = 1;
        for (int i = 4; i <= 100; i++) {
            D[i] = D[i - 2] + D[i - 3];
        }

        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            sb.append(D[N]).append('\n');
        }
        System.out.println(sb);
    }
}
