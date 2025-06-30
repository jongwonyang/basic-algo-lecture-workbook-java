package x10;

import java.util.Scanner;

public class BOJ11727 {

    static int N;
    static int[] D = new int[1001]; // D[i] = i번째 까지 채울 수 있는 방법의 수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        D[1] = 1;
        D[2] = 3;
        for (int i = 3; i <= N; i++) {
            D[i] = (D[i - 1] + D[i - 2] + D[i - 2]) % 10007;
        }

        System.out.println(D[N]);
    }
}
