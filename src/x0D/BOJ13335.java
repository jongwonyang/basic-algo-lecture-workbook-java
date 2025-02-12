package x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ13335 {

    static int N, W, L;
    static int[] weight = new int[1000];
    static int[] dist = new int[1000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) weight[i] = Integer.parseInt(st.nextToken());

        int left = 0, right = 0, t = 0, l = 0;
        while (left < N) {
            for (int i = left; i < right; i++) dist[i]++;
            if (dist[left] >= W) {
                l -= weight[left];
                left++;
            }
            if (right < N && l + weight[right] <= L) {
                l += weight[right];
                right++;
            }
            t++;
        }
        System.out.println(t);
    }
}
