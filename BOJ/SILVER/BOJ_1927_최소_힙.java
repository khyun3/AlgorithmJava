package SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//우선순위 큐로 푸는게 더 빠름
public class BOJ_1927_최소_힙 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeMap<Long, Integer> minHeap = new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        Long X = 0L;

        for(int i=0; i<N; i++){
            X = Long.parseLong(br.readLine());
            if(X == 0L) {
                removeFirst(minHeap, sb);
            }
            else {
                add(minHeap, X);
            }
        }
        System.out.println(sb.toString());
    }

    static void removeFirst(TreeMap<Long, Integer> minHeap, StringBuilder sb) {
        if (!minHeap.isEmpty()) {
            Map.Entry<Long, Integer> first = minHeap.firstEntry();
            sb.append(first.getKey().toString()).append("\n");
            if(first.getValue() <= 1){
                minHeap.remove(first.getKey());
            }
            else {
                minHeap.put(first.getKey(), first.getValue() - 1);
            }
        }
        else {
            sb.append(0).append("\n");
        }
    }

    static void add(TreeMap<Long, Integer> minHeap, Long X) {
        if(minHeap.containsKey(X)){
            minHeap.put(X, minHeap.get(X) + 1);
        }
        else {
            minHeap.put(X, 1);
        }
    }
}