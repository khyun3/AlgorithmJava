package BRONZE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1152_단어의_개수 {

    public static void main(String[] args) throws Exception {
        //첫 줄에 영어 대소문자와 공백으로 이루어진 문자열이 주어진다.
        //길이는 1,000,000을 넘지 않는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine(); // max 1,000,000
        StringTokenizer st = new StringTokenizer(input, " ");

        //문자열은 공백으로 시작하거나 끝날 수 있다.
        //단어는 공백 한 개로 구분, 공백이 연속해서 나오는 경우는 없다.
        System.out.print(st.countTokens());
    }
}
