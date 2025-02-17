package BOJ.BRONZE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10988_팰린드롬인지_확인하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        solution(str);
    }

    static void solution(char[] str) {
        int len = str.length;
        int half = len / 2;
        byte isPalindrome = 1;

        for (int i = 0; i < half; i++) {
            if(str[i] != str[len - 1 - i]) {
                isPalindrome = 0;
                break;
            }
        }
        System.out.print(isPalindrome);
    }
}
