package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6581_HTML {
	static final String HR = "--------------------------------------------------------------------------------";
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		String str;
		boolean cBr=false; //br 2개인거 체크하기
		int len = 0;
		
		while((str = br.readLine())!=null) {
			
			st = new StringTokenizer(str);
			
			while(st.hasMoreTokens()) {
				String next = st.nextToken();
				switch(next) {
					//br이 다음 단어면 
					case "<br>":
						if(len==0 && !cBr) {//빈줄인 상태에서 ,<br>이 또 왔을 때 (1줄만 띌 수 있으므로)
							sb.append("\n");
							cBr = true;
						}
						if(len!=0) {
							sb.append("\n");
						}
						len = 0;
						break;
					case "<hr>":
						//len에 문자열이 있으면 먼저 개행을 해준다.
						if(len!=0) sb.append("\n");

						//'-' 80개를 추가하고 개행 1번
						sb.append(HR).append("\n");
						
						//다음줄로 변경되었으니까 cBr을 false로 바꾼다.
						cBr = false; 
						
						//개행을 했으니까 len = 0으로 변경한다.
						len = 0;
						break;
					default :
						//기존 len에 다음 단어의 길이를 더했더니 80 이상이라면
						if(len+next.length() >= 80) {
							sb.append("\n");
							len = 0;
						}
						//기존 len에 단어의 길이 + 공백하나를 추가한다.
						len += next.length()+1;
						sb.append(next).append(" ");
						
						//공백이 아니니까  br체크는 풀어준다.
						cBr = false;
				}
			}
		}
		sb.delete(sb.length()-1, sb.length());
		System.out.print(sb.toString());
	}
}