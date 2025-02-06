package x0C;

import java.util.Scanner;

public class BOJ15651 {

    static int N, M;
    static int[] arr = new int[7];
    static StringBuilder ans = new StringBuilder();

    static void func(int idx) {
        if (idx == M) {
            for (int i = 0; i < M; i++) ans.append(arr[i]).append(" ");
            ans.append("\n");
            return;
        }

        for (int num = 1; num <= N; num++) {
            arr[idx] = num;
            func(idx + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        func(0);
        System.out.println(ans);
    }
}
