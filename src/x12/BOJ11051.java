package x12;

import java.util.Scanner;

public class BOJ11051 {

    static int N, K;
    static int[][] D = new int[1001][1001]; // D[i][j] = iCj

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        for (int i = 1; i <= 1000; i++) {
            D[i][0] = D[i][i] = 1;
            for (int j = 1; j < i; j++) {
                D[i][j] = (D[i - 1][j] + D[i - 1][j - 1]) % 10007;
            }
        }

        System.out.println(D[N][K]);
    }
}
