package x12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ4948 {

    static final int MAX = 123456 * 2;

    static boolean[] isPrime = new boolean[MAX + 1];
    static int[] acc = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        Arrays.fill(isPrime, 2, MAX + 1, true);

        for (int i = 2; i * i <= MAX; i++) {
            if (!isPrime[i]) continue;
            for (int j = i + i; j <= MAX; j += i) {
                isPrime[j] = false;
            }
        }

        int cnt = 0;
        for (int i = 2; i <= MAX; i++) {
            if (isPrime[i]) cnt++;
            acc[i] = cnt;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            sb.append(acc[2 * n] - acc[n]).append('\n');
        }
        System.out.println(sb);
    }
}
