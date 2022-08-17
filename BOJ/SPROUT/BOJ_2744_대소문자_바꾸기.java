package SPROUT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//A -> 65 : 0100 0001 ^ 0010 0000 = 0110 0001 => 64 + 32 + 1 = 97 -> a
//a -> 97
//a - A = 32 -> ' '공백문자로 xor 시, 대소문자 반전
public class BOJ_2744_대소문자_바꾸기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        for(int i=0; i<input.length; i++) {
            input[i] = (char) (input[i]^0x20); //0010 0000 (' '; space 문자 )
        }
        System.out.print(input);
    }
}
