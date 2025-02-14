package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2941_크로아티아_알파벳 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char [] input = br.readLine().toCharArray();
		int answer=0;
		
		for (int i = 0; i < input.length; i++) {
			if(i+1<input.length) {
				
				if (input[i] == 'c' && (input[i+1]=='-' || input[i+1]=='=')) {
					i++;
				}
				else if (input[i] == 'd') {
					if(i+2<input.length && input[i+1]=='z' && input[i+2]=='=') i+=2;
					else if(input[i+1]=='-') i++;
				}
				else if (input[i] == 'l' && input[i+1]=='j') i++;
				else if (input[i] == 'n' && input[i+1]=='j') i++;
				else if (input[i] == 's' && input[i+1]=='=') i++;
				else if (input[i] == 'z' && input[i+1]=='=') i++;	
			}
			answer++;
		}
		System.out.println(answer);
	}
}