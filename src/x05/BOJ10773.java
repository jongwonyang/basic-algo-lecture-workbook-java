package x05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) stack.pop();
            else stack.push(num);
        }

        int sum = 0;
        while (!stack.isEmpty()) sum += stack.pop();

        System.out.println(sum);
    }
}
