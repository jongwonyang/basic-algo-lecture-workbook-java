package x12;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1929 {

    static int M, N;
    static boolean[] isPrime = new boolean[1000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        Arrays.fill(isPrime, 2, N + 1, true);
        for (int i = 2; i * i <= N; i++) {
            if (!isPrime[i]) continue;

            for (int j = i * i; j <= N; j += i) {
                isPrime[j] = false;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (isPrime[i]) sb.append(i).append('\n');
        }
        System.out.println(sb);
    }
}
