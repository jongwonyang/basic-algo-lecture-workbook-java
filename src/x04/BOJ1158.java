package x04;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class BOJ1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) list.add(i);

        ListIterator<Integer> iter = list.listIterator();
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (true) {
            int t = 0;
            for (int i = 0; i < K; i++) {
                if (iter.hasNext()) t = iter.next();
                else {
                    iter = list.listIterator();
                    t = iter.next();
                }
            }
            sb.append(t);
            iter.remove();
            if (list.isEmpty()) break;
            sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}
