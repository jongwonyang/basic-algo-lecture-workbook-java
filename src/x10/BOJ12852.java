package x10;

import java.util.Scanner;

public class BOJ12852 {

    static int N;
    static int[] D = new int[1000001];
    static int[] pre = new int[1000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        D[1] = 0;
        for (int i = 2; i <= N; i++) {
            D[i] = D[i - 1] + 1;
            pre[i] = i - 1;
            if (i % 3 == 0 && D[i / 3] < D[i]) {
                D[i] = D[i / 3] + 1;
                pre[i] = i / 3;
            }
            if (i % 2 == 0 && D[i / 2] < D[i]) {
                D[i] = D[i / 2] + 1;
                pre[i] = i / 2;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(D[N]).append('\n');

        int i = N;
        while (true) {
            sb.append(i).append(' ');
            if (i == 1) break;
            i = pre[i];
        }

        System.out.println(sb);
    }
}
