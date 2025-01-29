package x0B;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ11729 {

    static List<String> ans = new ArrayList<>();

    static void func(int k, int from, int to, int by) {
        if (k == 1) ans.add(from + " " + to);
        else {
            func(k - 1, from, by, to);
            ans.add(from + " " + to);
            func(k - 1, by, to, from);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        func(K, 1, 3, 2);
        System.out.println(ans.size());
        StringBuilder sb = new StringBuilder();
        for (String s : ans) sb.append(s).append("\n");
        System.out.println(sb);
    }
}
