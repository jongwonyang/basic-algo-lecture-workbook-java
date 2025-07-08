package x10;

import java.io.IOException;
import java.util.Scanner;

public class BOJ10844 {

    static int N;
    static long[][] D = new long[101][10]; // D[i][j] = i번째 자리의 숫자 j의 개수

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for (int j = 1; j <= 9; j++) D[1][j] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j - 1 >= 0) D[i][j - 1] += D[i - 1][j];
                if (j + 1 <= 9) D[i][j + 1] += D[i - 1][j];
            }
            for (int j = 0; j <= 9; j++) D[i][j] %= 1_000_000_000;
        }

        long ans = 0;
        for (int j = 0; j <= 9; j++) ans += D[N][j];
        System.out.println(ans % 1_000_000_000);
    }
}
