package SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11279_최대_힙 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        StringBuilder sb = new StringBuilder();
        Integer X = 0;

        for (int i = 0; i < N; i++) {
            X = Integer.parseInt(br.readLine());
            if (X == 0L) {
                removeLast(maxHeap, sb);
            } else {
                add(maxHeap, X);
            }
        }
        System.out.println(sb);
    }

    static void removeLast(PriorityQueue<Integer> maxHeap, StringBuilder sb) {
        if (!maxHeap.isEmpty()) {
            Integer maxValue = maxHeap.poll();
            sb.append(maxValue).append("\n");
        } else {
            sb.append(0).append("\n");
        }
    }

    static void add(PriorityQueue maxHeap, Integer X) {
        maxHeap.add(X);
    }
}