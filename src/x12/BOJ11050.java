package x12;

import java.util.Scanner;

public class BOJ11050 {

    static int N, K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        int ans = 1;
        for (int i = 0; i < K; i++) ans *= (N - i);
        for (int i = 1; i <= K; i++) ans /= i;
        System.out.println(ans);
    }
}
