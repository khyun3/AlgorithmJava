package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17413_단어뒤집기2 {

	static char[] str;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		// 문자를 읽는다.
		str = br.readLine().trim().toCharArray();
		boolean flag = false;
		
		for (int i = 0; i < str.length; i++) {

			if(str[i] == '<') {
				sb = new StringBuilder();
				flag = true;

				System.out.print(sb2.reverse());     //뒤집어서 출력하고
				sb2 = new StringBuilder();
				sb.append(str[i]);
			}
			
			else if(str[i] == '>') {
				flag = false;
				sb.append(str[i]);
				System.out.print(sb);	
			}	
			else {
				//만약에 태그 내부 문자면
				if(flag == true)
					sb.append(str[i]);
				else { 
					if(str[i] == ' ') { 							     //문자열을 나누는 기준인 공백문자인가?
						System.out.print(sb2.reverse().append(" "));     //뒤집어서 출력하고
						sb2 = new StringBuilder();						 //초기화
					}
					else {
						sb2.append(str[i]);
					}
				}
			}
		}
		if(sb2.length() != 0) {
			System.out.print(sb2.reverse());
		}
	}
}