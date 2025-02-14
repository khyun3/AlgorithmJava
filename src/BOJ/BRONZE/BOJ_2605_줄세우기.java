package BOJ.BRONZE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2605_줄세우기 {

	static int N;
	static List<Integer> studentOrder = new LinkedList<>();
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer drawNumberTokenizer;
		
		N = Integer.parseInt(br.readLine());
		drawNumberTokenizer = new StringTokenizer(br.readLine()," ");
		
		for (int i = 0; i < N; i++) {
			int drawNumber = Integer.parseInt(drawNumberTokenizer.nextToken());
			//1번이 들어왔을 때
			if(i==0) {
				studentOrder.add(i+1);
			}
			//2번 학생부터
			else {
				//뽑은 번호가 0이면 뒤에 붙인다.
				if(drawNumber==0) {
					studentOrder.add(i+1);
				}
				//뽑은 번호가 0이 아니라면
				else {
					//끝 인덱스는 i가 알고 있음.
					studentOrder.add(i-drawNumber, i+1);
				}
			}
			
		}
		StringBuilder lineUp = new StringBuilder();
		for (int i = 0; i<studentOrder.size(); i++) {
			lineUp.append(studentOrder.get(i)).append(" ");
		}
		System.out.println(lineUp);
	}
}