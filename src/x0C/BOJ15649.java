package x0C;

import java.util.Scanner;

public class BOJ15649 {

    static int N, M;
    static int[] arr = new int[8];
    static boolean[] vis = new boolean[9];

    static void func(int idx) {
        if (idx == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) sb.append(arr[i]).append(" ");
            System.out.println(sb);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (vis[i]) continue;
            arr[idx] = i;
            vis[i] = true;
            func(idx + 1);
            vis[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        func(0);
    }
}
