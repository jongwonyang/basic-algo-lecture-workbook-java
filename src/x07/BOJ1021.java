package x07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ1021 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) dq.addLast(i);

        int ans = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            Deque<Integer> lRot = new ArrayDeque<>();
            Deque<Integer> rRot = new ArrayDeque<>();
            while (dq.peekFirst() != num) lRot.offer(dq.removeFirst());
            while (dq.peekLast() != num) rRot.offer(dq.removeLast());
            if (lRot.size() < rRot.size() + 1) {
                ans += lRot.size();
                dq.removeFirst();
                while (!rRot.isEmpty()) dq.addLast(rRot.removeLast());
                while (!lRot.isEmpty()) dq.addLast(lRot.removeFirst());
            } else {
                ans += (rRot.size() + 1);
                dq.removeLast();
                while (!lRot.isEmpty()) dq.addFirst(lRot.removeLast());
                while (!rRot.isEmpty()) dq.addFirst(rRot.removeFirst());
            }
        }
        System.out.println(ans);
    }
}
