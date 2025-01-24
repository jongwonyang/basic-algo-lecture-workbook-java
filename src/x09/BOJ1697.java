package x09;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class BOJ1697 {

    static int N, K;
    static Deque<Integer> q = new ArrayDeque<>();
    static int[] dist = new int[200001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        if (N == K) {
            System.out.println(0);
            return;
        }

        Arrays.fill(dist, -1);
        q.offer(N);
        dist[N] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            int[] nxt = { cur - 1, cur + 1, cur + cur };
            for (int nx : nxt) {
                if (nx < 0 || nx > 200000) continue;
                if (dist[nx] != -1) continue;
                if (nx == K) {
                    System.out.println(dist[cur] + 1);
                    return;
                }
                q.offer(nx);
                dist[nx] = dist[cur] + 1;
            }
        }
    }
}
