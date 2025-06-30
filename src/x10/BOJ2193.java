package x10;

import java.util.Scanner;

public class BOJ2193 {

    static int N;
    static long[][] D = new long[91][2]; // D[i][j] = i번째 자리에 j(0 또는 1)가 올 때 이친수의 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        D[1][0] = 0;
        D[1][1] = 1;

        for (int i = 2; i <= N; i++) {
            D[i][0] = D[i - 1][0] + D[i - 1][1];
            D[i][1] = D[i - 1][0];
        }

        System.out.println(D[N][0] + D[N][1]);
    }
}
