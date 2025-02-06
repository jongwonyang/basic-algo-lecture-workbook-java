package x0C;

import java.util.Scanner;

public class BOJ15652 {

    static int N, M;
    static int[] arr = new int[8];
    static StringBuilder sb = new StringBuilder();

    static void func(int idx, int st) {
        if (idx == M) {
            for (int i = 0; i < M; i++) sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int num = st; num <= N; num++) {
            arr[idx] = num;
            func(idx + 1, num);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        func(0, 1);
        System.out.println(sb);
    }
}
