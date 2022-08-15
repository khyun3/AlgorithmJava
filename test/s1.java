import java.util.ArrayList;
import java.util.StringTokenizer;

public class s1 {

	public static void main(String[] args) {
		String S = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker";
		String C = "example";
		StringBuilder answer = new StringBuilder();
		
		ArrayList<String> nList = new ArrayList<>(); 
		
		//1명의 풀 네임
		StringTokenizer nameTok = new StringTokenizer(S,";");
		//first and last 네임만 남기기
		StringTokenizer firstLastTok = null;
		
		while(nameTok.hasMoreTokens()) {
			StringBuilder email = new StringBuilder();
			String name = nameTok.nextToken().trim();
			firstLastTok = new StringTokenizer(name, " ");
			answer.append(name).append(" <");
			
			//이름, 중간이름, 성까지 다 들어갔을 경우
			String first = null;
			String last = null;
			if(firstLastTok.countTokens()>2) {
				first = firstLastTok.nextToken().toLowerCase();
				 
				//중간 이름을 버리고 성만 가지고오기
				while(firstLastTok.hasMoreTokens()) {
					last = firstLastTok.nextToken().toLowerCase();
				}
			}
			//이름, 성만 입력된 경우
			else {
				first = firstLastTok.nextToken().toLowerCase();
				last = firstLastTok.nextToken().toLowerCase();
			}
			
			//-빼기
			if(last.contains("-")) {
				StringTokenizer st = new StringTokenizer(last,"-");
				StringBuilder sb = new StringBuilder();
				while(st.hasMoreTokens()) {
					sb.append(st.nextToken());
				}
				last = sb.toString();
			}
			
			//같은 이름 있는지 확인
			email
			.append(first)
			.append(".")
			.append(last.length() > 8 ? last.substring(0, 8) : last);
			
			int cnt = 0;
			for (String s : nList) {
				if(s.equals(email.toString())) {
					cnt++;
				}
			}
			nList.add(email.toString());

			if(cnt>0) {
				email.append(cnt+1);
			}
			
			email
			.append("@")
			.append(C)
			.append(".com");

			answer.append(email).append(">; ");
			
		}
		System.out.print(answer.toString().substring(0, answer.length()-2));
	}
}
