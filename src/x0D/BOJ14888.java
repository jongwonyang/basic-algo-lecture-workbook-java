package x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 {

    static int N;
    static int[] num = new int[11];
    static int[] op = new int[10];
    static int[] ord = new int[10];
    static boolean[] used = new boolean[10];
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    static void calc() {
        int result = num[0];
        for (int i = 0; i < N - 1; i++) {
            switch (ord[i]) {
                case 0: // +
                    result += num[i + 1];
                    break;
                case 1: // -
                    result -= num[i + 1];
                    break;
                case 2: // *
                    result *= num[i + 1];
                    break;
                case 3: // /
                    result /= num[i + 1];
                    break;
            }
        }
        max = Math.max(max, result);
        min = Math.min(min, result);
    }

    static void func(int idx) {
        if (idx == N - 1) {
            calc();
            return;
        }

        for (int i = 0; i < N - 1; i++) {
            if (used[i]) continue;
            ord[idx] = op[i];
            used[i] = true;
            func(idx + 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) num[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int idx = 0;
        for (int i = 0; i < 4; i++) {
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) op[idx++] = i;
        }

        func(0);

        System.out.println(max);
        System.out.println(min);
    }
}
