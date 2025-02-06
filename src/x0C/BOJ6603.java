package x0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6603 {

    static int K;
    static int[] S = new int[13];
    static int[] arr = new int[6];
    static boolean[] sel = new boolean[13];
    static StringBuilder sb = new StringBuilder();

    static void func(int idx, int st) {
        if (idx == 6) {
            for (int i = 0; i < 6; i++) sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = st; i < K; i++) {
            if (sel[i]) continue;
            arr[idx] = S[i];
            sel[i] = true;
            func(idx + 1, i + 1);
            sel[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if (K == 0) break;
            for (int i = 0; i < K; i++) S[i] = Integer.parseInt(st.nextToken());
            func(0, 0);
            // print sb
            System.out.println(sb);
            // init sb
            sb = new StringBuilder();
        }
    }
}
