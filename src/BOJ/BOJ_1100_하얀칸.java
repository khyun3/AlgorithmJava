package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1100_하얀칸 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        //하얀 칸 위에 말이 몇개 있는가?
        for (int i = 0; i < 8; i++) {
            boolean color = i % 2 == 0;
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                if(input[j] == 'F' && color) {
                    count++;
                }
                color = !color;
            }
        }
        System.out.println(count);
    }
}
