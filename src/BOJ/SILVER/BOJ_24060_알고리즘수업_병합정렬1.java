package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_24060_알고리즘수업_병합정렬1 {
    static int k = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        int[] elements = new int[n];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            elements[i] = Integer.parseInt(input[i]);
        }
        mergeSort(elements, 0, n - 1);
        if (k > count) {
            System.out.println(-1);
        }
    }

    static void mergeSort(int[] arr, int p, int r) {
        if(k == count) return;
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(arr, p, q);
            mergeSort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    static void merge(int[] arr, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;
        int[] tmp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[t] = arr[i++];
            } else {
                tmp[t] = arr[j++];
            }
            t++;
        }
        while (i <= q) {
            tmp[t++] = arr[i++];
        }
        while (j <= r) {
            tmp[t++] = arr[j++];
        }
        i = p;
        t = 0;
        while (i <= r) {
            arr[i++] = tmp[t++];
            if(++count == k) {
                System.out.print(arr[i-1]);
            }
        }
    }
}