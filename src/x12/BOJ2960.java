package x12;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2960 {

    static int N, K;
    static boolean[] isPrime = new boolean[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        Arrays.fill(isPrime, 2, 1001, true);

        int cnt = 0, ans = 0;
        for (int i = 2; i <= N; i++) {
            if (!isPrime[i]) continue;
            for (int j = i; j <= N; j += i) {
                if (!isPrime[j]) continue;
                isPrime[j] = false;
                cnt++;
                if (cnt == K) ans = j;
            }
        }
        System.out.println(ans);
    }
}
