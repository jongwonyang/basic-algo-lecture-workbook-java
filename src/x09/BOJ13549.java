package x09;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class BOJ13549 {

    static int[] dx = { -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Deque<Integer> dq = new ArrayDeque<>();
        int[] dist = new int[200001];
        Arrays.fill(dist, -1);

        dq.addLast(N);
        dist[N] = 0;

        while (!dq.isEmpty()) {
            int cur = dq.removeFirst();

            if (cur + cur < 200000 && dist[cur + cur] == -1) {
                dq.addFirst(cur + cur);
                dist[cur + cur] = dist[cur];
            }

            for (int nxt : new int[] { cur - 1, cur + 1 }) {
                if (nxt < 0 || nxt >= 200000) continue;
                if (dist[nxt] != -1) continue;
                dq.addLast(nxt);
                dist[nxt] = dist[cur] + 1;
            }
        }

        System.out.println(dist[K]);
    }
}
