package x01;

import java.util.Scanner;

public class BOJ2445 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) sb.append("*");
            for (int j = 0; j < N + N - (i + i); j++) sb.append(" ");
            for (int j = 0; j < i; j++) sb.append("*");
            sb.append("\n");
        }
        for (int i = 0; i < N + N; i++) sb.append("*");
        sb.append("\n");
        for (int i = N - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) sb.append("*");
            for (int j = 0; j < N + N - (i + i); j++) sb.append(" ");
            for (int j = 0; j < i; j++) sb.append("*");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
