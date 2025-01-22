package x04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class BOJ1406_LinkedList {

    static List<Character> lst;
    static ListIterator<Character> it;

    public static void main(String[] args) throws IOException {
        lst = new LinkedList<>();
        it = lst.listIterator();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();
        for (char ch : line) it.add(ch);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if (op.equals("L")) {
                if (it.hasPrevious()) it.previous();
            } else if (op.equals("D")) {
                if (it.hasNext()) it.next();
            } else if (op.equals("B")) {
                if (it.hasPrevious()) {
                    it.previous();
                    it.remove();
                }
            } else { // "P"
                char ch = st.nextToken().charAt(0);
                it.add(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : lst) sb.append(ch);
        System.out.println(sb);
    }
}
