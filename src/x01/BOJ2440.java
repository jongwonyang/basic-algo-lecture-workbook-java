package x01;

import java.util.Scanner;

public class BOJ2440 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - i; j++) sb.append("*");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
