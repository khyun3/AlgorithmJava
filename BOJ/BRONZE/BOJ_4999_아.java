package BRONZE;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_4999_아 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int j = br.readLine().length();
        int d = br.readLine().length();
        System.out.print(j >= d ? "go" : "no");
    }
}
