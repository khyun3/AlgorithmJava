package BOJ.BRONZE;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10813_공바꾸기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] token = br.readLine().split(" ");
        int n = Integer.parseInt(token[0]);
        int m = Integer.parseInt(token[1]);
        int[] baskets = makeBasket(n);

        for (int i = 0; i < m; i++) {
            token = br.readLine().split(" ");
            change(baskets,
                    Integer.parseInt(token[0]) - 1,
                    Integer.parseInt(token[1]) - 1);
        }
        print(baskets);
        br.close();
    }

    static int[] makeBasket(int n) {
        int[] baskets = new int[n];
        for (int i = 0; i < n; i++) {
            baskets[i] = i + 1;
        }
        return baskets;
    }

    static void change(int[] baskets, int i, int j) {
        int temp = baskets[i];
        baskets[i] = baskets[j];
        baskets[j] = temp;
    }

    static void print(int[] baskets) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int basket : baskets) {
            bw.write(basket + " ");
        }
        bw.flush();
    }
}
