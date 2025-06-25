package x10;

import java.util.Scanner;

public class BOJ9095 {

    static int[] D = new int[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        D[1] = 1;
        D[2] = 2;
        D[3] = 4;
        for (int i = 4; i <= 10; i++) {
            D[i] = D[i - 1] + D[i - 2] + D[i - 3];
        }

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            System.out.println(D[n]);
        }
    }
}
