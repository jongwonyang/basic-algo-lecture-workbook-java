package x02;

import java.util.Scanner;

public class BOJ2446 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < i; j++) sb.append(" ");
            for (int j = 0; j < N + N - ((i + 1) * 2 - 1); j++) sb.append("*");
            sb.append("\n");
        }
        for (int i = 1; i < N; i++) sb.append(" ");
        sb.append("*\n");
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N - 1 - i; j++) sb.append(" ");
            for (int j = 0; j < (i + 1) * 2 - 1; j++) sb.append("*");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
