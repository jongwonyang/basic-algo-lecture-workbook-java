package x08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            char[] line = br.readLine().toCharArray();
            if (line[0] == '.') break;

            Deque<Character> stk = new ArrayDeque<>();
            boolean bal = true;
            for (char c : line) {
                if (c == '(' || c == '[') stk.push(c);
                else if (c == ')') {
                    if (stk.isEmpty() || stk.pop() != '(') {
                        bal = false;
                        break;
                    }
                } else if (c == ']') {
                    if (stk.isEmpty() || stk.pop() != '[') {
                        bal = false;
                        break;
                    }
                }
            }
            if (!stk.isEmpty()) System.out.println("no");
            else System.out.println(bal ? "yes" : "no");
        }
    }
}
