package x0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16987 {

    static int N;
    static int[] def = new int[8];
    static int[] atk = new int[8];
    static int[] ord = new int[8];
    static int ans = 0;

    static void game() {
        int[] defCopy = Arrays.copyOf(def, N);
        for (int i = 0; i < N; i++) {
            int t = ord[i];
            if (defCopy[i] == 0) continue;
            if (defCopy[t] == 0) {
                for (int j = 0; j < N; j++) {
                    if (j == i) continue;
                    if (defCopy[j] > 0) return;
                }
                continue;
            }
            defCopy[i] -= atk[t];
            if (defCopy[i] < 0) defCopy[i] = 0;
            defCopy[t] -= atk[i];
            if (defCopy[t] < 0) defCopy[t] = 0;
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (defCopy[i] == 0) sum++;
        }
        ans = Math.max(ans, sum);
    }

    static void func(int idx) {
        if (idx == N) {
            game();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (i == idx) continue;
            ord[idx] = i;
            func(idx + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            def[i] = Integer.parseInt(st.nextToken());
            atk[i] = Integer.parseInt(st.nextToken());
        }
        func(0);
        System.out.println(ans);
    }
}
