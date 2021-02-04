package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2504_괄호의값 {
	static char [] str;
	static int idx;
	static boolean flag = true;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine().toCharArray();
		//idx, type ==> -1, 0==(, 1==[
//		operation(' ', 0);
	}
//	static int operation(char type, int mul) {
//		int res = 0;
//		
//		while(flag && idx < str.length) {
//			switch(str[idx]) {
//			case '(':
//				idx++;
//				res += operation('(');
//			case '[':
//				idx++;
//				res += operation('[');
//			case ')':
//				if(type!='(') {
//					flag = false;
//					return mul*3;
//				}
//				//'('가 넘어온게 맞으면
//				else {
//					return mul*2;
//				}
//			case ']':
//				if(type!='[') {
//					flag = false;
//					return 0;
//				}
//				//'['가 넘어온게 맞으면
//				else {
//					return 3;
//				}
//			}
//		}
//	}
}
