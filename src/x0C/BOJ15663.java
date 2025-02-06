package x0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15663 {

    static int N, M;
    static int[] num = new int[8];
    static int[] arr = new int[8];
    static boolean[] sel = new boolean[8];
    static StringBuilder sb = new StringBuilder();

    static void func(int idx) {
        if (idx == M) {
            for (int i = 0; i < M; i++) sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }

        int pre = -1;
        for (int i = 0; i < N; i++) {
            if (sel[i] || num[i] == pre) continue;
            arr[idx] = num[i];
            pre = num[i];
            sel[i] = true;
            func(idx + 1);
            sel[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(num, 0, N);
        func(0);
        System.out.println(sb);
    }
}
