package x08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ3986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i < N; i++) {
            char[] word = br.readLine().toCharArray();
            Deque<Character> stk = new ArrayDeque<>();
            for (char c : word) {
                if (stk.isEmpty()) stk.push(c);
                else {
                    if (stk.peek() == c) stk.pop();
                    else stk.push(c);
                }
            }
            if (stk.isEmpty()) ans++;
        }
        System.out.println(ans);
    }
}
