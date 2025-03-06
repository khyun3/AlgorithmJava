package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_4949_균형잡힌_세상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            //1. 문자열을 입력 받는다.
            char[] input = br.readLine().toCharArray();
            //2. 종료조건(.)을 체크한다.
            if (input[0] == '.') {
                break;
            }
            //3. 균형잡힌 문자열인지 체크한다.
            sb.append(solution(input)).append("\n");
        }
        System.out.print(sb);
    }

    static String solution(char[] input) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : input) {
            switch (c) {
                //(과 [는 stack에 넣는다.
                case '(':
                case '[':
                    stack.push(c);
                    break;
                //stack이 비어있거나 stack의 peek가 '('인지 체크한다.
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return "no";
                    }
                    //stack peek을 제거한다.
                    stack.pop();
                    break;
                //stack이 비어있거나 stack의 peek가 '['인지 체크한다.
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return "no";
                    }
                    //stack peek을 제거한다.
                    stack.pop();
                    break;
            }
        }
        //마지막까지 왔다면 stack이 비었는지 체크한다.
        if (stack.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }
    }
}
