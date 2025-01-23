package x07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            char[] op = br.readLine().toCharArray();
            int N = Integer.parseInt(br.readLine());

            String line = br.readLine();
            line = line.substring(1, line.length() - 1);
            StringTokenizer st = new StringTokenizer(line, ",");

            Deque<String> dq = new ArrayDeque<>();
            for (int i = 0; i < N; i++) dq.offer(st.nextToken());

            boolean rev = false, err = false;
            for (char o : op) {
                if (o == 'R') rev = !rev;
                else { // 'D'
                    if (dq.isEmpty()) {
                        err = true;
                        break;
                    }
                    if (rev) dq.removeLast();
                    else dq.removeFirst();
                }
            }
            if (err) System.out.println("error");
            else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                while (!dq.isEmpty()) {
                    sb.append(rev ? dq.removeLast() : dq.removeFirst());
                    if (!dq.isEmpty()) sb.append(",");
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}