package x10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1003 {

    static int[] D0 = new int[41];
    static int[] D1 = new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        D0[0] = 1;
        D0[1] = 0;
        for (int i = 2; i <= 40; i++) {
            D0[i] = D0[i - 1] + D0[i - 2];
        }

        D1[0] = 0;
        D1[1] = 1;
        for (int i = 2; i <= 40; i++) {
            D1[i] = D1[i - 1] + D1[i - 2];
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(D0[N]).append(' ').append(D1[N]).append('\n');
        }
        System.out.println(sb);
    }
}
