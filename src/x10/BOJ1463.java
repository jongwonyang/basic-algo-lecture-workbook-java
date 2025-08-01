package x10;

import java.util.Scanner;

public class BOJ1463 {

    static int N;
    static int[] D = new int[1_000_001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        D[1] = 0;
        for (int i = 2; i <= N; i++) {
            D[i] = D[i - 1] + 1;
            if (i % 3 == 0) D[i] = Math.min(D[i], D[i / 3] + 1);
            if (i % 2 == 0) D[i] = Math.min(D[i], D[i / 2] + 1);
        }

        System.out.println(D[N]);
    }
}
