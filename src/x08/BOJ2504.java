package x08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();

        Deque<Element> stk = new ArrayDeque<>();
        boolean valid = true;
        for (char c : line) {
            if (c == '(' || c == '[') stk.push(new Element(c, 0));
            else {
                if (stk.isEmpty()) {
                    valid = false;
                    break;
                }
                if (c == ')' && stk.peek().paren == '(') {
                    stk.pop();
                    stk.push(new Element('.', 2));
                    continue;
                } else if (c == ']' && stk.peek().paren == '[') {
                    stk.pop();
                    stk.push(new Element('.', 3));
                    continue;
                }
                int sum = 0;
                while (true) {
                    if (stk.isEmpty()) {
                        valid = false;
                        break;
                    }
                    Element top = stk.pop();
                    if (top.paren == '.') sum += top.num;
                    else if (c == ')' && top.paren == '(') {
                        stk.push(new Element('.', 2 * sum));
                        break;
                    } else if (c == ']' && top.paren == '[') {
                        stk.push(new Element('.', 3 * sum));
                        break;
                    } else {
                        valid = false;
                        break;
                    }
                }
            }
            if (!valid) break;
        }
        if (!valid) System.out.println(0);
        else {
            int ans = 0;
            for (Element e : stk) {
                if (e.paren != '.') {
                    System.out.println(0);
                    return;
                }
                ans += e.num;
            }
            System.out.println(ans);
        }
    }

    static class Element {
        char paren;
        int num;

        public Element(char paren, int num) {
            this.paren = paren;
            this.num = num;
        }
    }
}
