package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2628_종이짜르기 {
	
	static int N, R, C; //선 개수, 행,열 크기
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		
		List<Integer> rLineList = new LinkedList<>();
		List<Integer> cLineList = new LinkedList<>();
		rLineList.add(0);
		cLineList.add(0);
		rLineList.add(R);
		cLineList.add(C);
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			if(Integer.parseInt(st.nextToken())==0) { //가로
				rLineList.add(Integer.parseInt(st.nextToken()));
			}
			else {//세로
				cLineList.add(Integer.parseInt(st.nextToken()));
			}
		}
		Collections.sort(rLineList);
		Collections.sort(cLineList);
		int answer=0; //max 값
		for (int i = 1; i < rLineList.size(); i++) {
			int rSize =  rLineList.get(i) - rLineList.get(i-1);
			
			for (int j = 1; j < cLineList.size(); j++) {
				int cSize = cLineList.get(j) - cLineList.get(j-1);
				answer = Math.max(answer, cSize*rSize);
			}
		}
		System.out.println(answer);
	}
}