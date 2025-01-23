package x07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        int x;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            switch (op) {
                case "push_front":
                    x = Integer.parseInt(st.nextToken());
                    dq.addFirst(x);
                    break;
                case "push_back":
                    x = Integer.parseInt(st.nextToken());
                    dq.addLast(x);
                    break;
                case "pop_front":
                    if (dq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(dq.removeFirst()).append("\n");
                    break;
                case "pop_back":
                    if (dq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(dq.removeLast()).append("\n");
                    break;
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                case "empty":
                    sb.append(dq.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    if (dq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(dq.peekFirst()).append("\n");
                    break;
                case "back":
                    if (dq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(dq.peekLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
