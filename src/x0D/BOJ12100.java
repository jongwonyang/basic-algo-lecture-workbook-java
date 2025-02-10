package x0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ12100 {

    static int N;
    static int[][] board = new int[20][20];
    static int[][] boardCopy = new int[20][20];
    static int[] move = new int[5];
    static int ans = 0;

    static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;

    static void up() {
        for (int y = 0; y < N; y++) {
            Deque<Integer> dq = new ArrayDeque<>();
            int nx = 0;
            for (int x = 0; x < N; x++) {
                if (boardCopy[x][y] != 0) {
                    if (dq.isEmpty() || dq.peekLast() != boardCopy[x][y]) dq.addLast(boardCopy[x][y]);
                    else {
                        dq.removeLast();
                        dq.addLast(boardCopy[x][y] * 2);
                        while (!dq.isEmpty()) boardCopy[nx++][y] = dq.removeFirst();
                    }
                }
            }
            while (!dq.isEmpty()) boardCopy[nx++][y] = dq.removeFirst();
            while (nx < N) boardCopy[nx++][y] = 0;
        }
    }

    static void down() {
        for (int y = 0; y < N; y++) {
            Deque<Integer> dq = new ArrayDeque<>();
            int nx = N - 1;
            for (int x = N - 1; x >= 0; x--) {
                if (boardCopy[x][y] != 0) {
                    if (dq.isEmpty() || dq.peekLast() != boardCopy[x][y]) dq.addLast(boardCopy[x][y]);
                    else {
                        dq.removeLast();
                        dq.addLast(boardCopy[x][y] * 2);
                        while (!dq.isEmpty()) boardCopy[nx--][y] = dq.removeFirst();
                    }
                }
            }
            while (!dq.isEmpty()) boardCopy[nx--][y] = dq.removeFirst();
            while (nx >= 0) boardCopy[nx--][y] = 0;
        }
    }

    static void left() {
        for (int x = 0; x < N; x++) {
            Deque<Integer> dq = new ArrayDeque<>();
            int ny = 0;
            for (int y = 0; y < N; y++) {
                if (boardCopy[x][y] != 0) {
                    if (dq.isEmpty() || dq.peekLast() != boardCopy[x][y]) dq.addLast(boardCopy[x][y]);
                    else {
                        dq.removeLast();
                        dq.addLast(boardCopy[x][y] * 2);
                        while (!dq.isEmpty()) boardCopy[x][ny++] = dq.removeFirst();
                    }
                }
            }
            while (!dq.isEmpty()) boardCopy[x][ny++] = dq.removeFirst();
            while (ny < N) boardCopy[x][ny++] = 0;
        }
    }

    static void right() {
        for (int x = 0; x < N; x++) {
            Deque<Integer> dq = new ArrayDeque<>();
            int ny = N - 1;
            for (int y = N - 1; y >= 0; y--) {
                if (boardCopy[x][y] != 0) {
                    if (dq.isEmpty() || dq.peekLast() != boardCopy[x][y]) dq.addLast(boardCopy[x][y]);
                    else {
                        dq.removeLast();
                        dq.addLast(boardCopy[x][y] * 2);
                        while (!dq.isEmpty()) boardCopy[x][ny--] = dq.removeFirst();
                    }
                }
            }
            while (!dq.isEmpty()) boardCopy[x][ny--] = dq.removeFirst();
            while (ny >= 0) boardCopy[x][ny--] = 0;
        }
    }

    static void copyBoard() {
        for (int x = 0; x < N; x++) boardCopy[x] = Arrays.copyOf(board[x], N);
    }

    static void game() {
        copyBoard();
        for (int m : move) {
            switch (m) {
                case UP:
                    up();
                    break;
                case DOWN:
                    down();
                    break;
                case LEFT:
                    left();
                    break;
                case RIGHT:
                    right();
                    break;
            }
        }
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                ans = Math.max(ans, boardCopy[x][y]);
            }
        }
    }

    static void func(int idx) {
        if (idx == 5) {
            game();
            return;
        }

        for (int d = 0; d < 4; d++) {
            move[idx] = d;
            func(idx + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int x = 0; x < N; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int y = 0; y < N; y++) {
                board[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        func(0);
        System.out.println(ans);
    }
}
