package x02;

import java.util.Scanner;

public class BOJ2443 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) sb.append(" ");
            for (int j = 0; j < N + N - (2 * (i + 1) - 1); j++) sb.append("*");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
