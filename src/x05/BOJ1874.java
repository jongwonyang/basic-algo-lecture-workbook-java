package x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> stk = new ArrayDeque<>();
        int nxt = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num >= nxt) {
                while (nxt <= num) {
                    stk.push(nxt++);
                    sb.append("+\n");
                }
                stk.pop();
                sb.append("-\n");
            } else {
                if (stk.isEmpty() || stk.peek() != num) {
                    System.out.println("NO");
                    return;
                }
                else {
                    stk.pop();
                    sb.append("-\n");
                }
            }
        }
        System.out.println(sb);
    }
}
