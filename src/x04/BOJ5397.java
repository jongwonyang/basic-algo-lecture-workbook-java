package x04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BOJ5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            char[] line = br.readLine().toCharArray();
            List<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();

            for (char c : line) {
                switch (c) {
                    case '-':
                        if (iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    case '<':
                        if (iter.hasPrevious()) {
                            iter.previous();
                        }
                        break;
                    case '>':
                        if (iter.hasNext()) {
                            iter.next();
                        }
                        break;
                    default:
                        iter.add(c);
                        break;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (char c : list) sb.append(c);
            System.out.println(sb);
        }
    }
}
