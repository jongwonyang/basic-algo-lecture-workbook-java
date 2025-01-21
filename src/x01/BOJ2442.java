package x01;

import java.util.Scanner;

public class BOJ2442 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < N - i; j++) sb.append(" ");
            for (int j = 0; j < i + i - 1; j++) sb.append("*");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
