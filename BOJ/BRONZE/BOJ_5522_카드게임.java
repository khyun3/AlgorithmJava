package BRONZE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_5522_카드게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger res = BigInteger.ZERO;
        for (int i = 0; i < 5; i++) {
            res = res.add(new BigInteger(br.readLine()));
        }
        System.out.println(res);
    }
}
