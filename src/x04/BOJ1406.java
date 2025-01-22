package x04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1406 {

    static Node cur = new Node('\0');

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] line = br.readLine().toCharArray();
        for (char ch : line) insert(ch);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if (op.equals("L")) left();
            else if (op.equals("D")) right();
            else if (op.equals("B")) delete();
            else { // "P"
                char ch = st.nextToken().charAt(0);
                insert(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (cur.pre != null) cur = cur.pre;
        while (cur.nxt != null) {
            sb.append(cur.ch);
            cur = cur.nxt;
        }
        System.out.println(sb);
    }

    static void left() {
        if (cur.pre != null) cur = cur.pre;
    }

    static void right() {
        if (cur.nxt != null) cur = cur.nxt;
    }

    static void delete() {
        if (cur.pre != null) {
            if (cur.pre.pre == null) {
                cur.pre = null;
            } else {
                cur.pre.pre.nxt = cur;
                cur.pre = cur.pre.pre;
            }
        }
    }

    static void insert(char ch) {
        Node n = new Node(ch);
        if (cur.pre == null) {
            cur.pre = n;
            n.nxt = cur;
        } else {
            cur.pre.nxt = n;
            n.pre = cur.pre;
            n.nxt = cur;
            cur.pre = n;
        }
    }

    static class Node {
        Node pre;
        Node nxt;
        char ch;

        public Node(char ch) {
            this.ch = ch;
        }
    }
}
