package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2493_탑 {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int height;
		int index = 1;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> sIndex = new Stack<Integer>();
		
		stack.push(Integer.parseInt(st.nextToken())); 
		//입력 끝
		sIndex.push(index++);
		sb.append("0 ");
		
		for (int i = 1; i < N; i++) {
			height = Integer.parseInt(st.nextToken());	//높이 하나 읽어옴
			
			while(!stack.isEmpty()) {	
				if(height < stack.peek()) {		//받아온 높이가 스텍의 탑보다 작으면 출력 string에 추가
					sb.append(sIndex.peek()+ " ");
					break;			//
				}
				stack.pop();			//만약에 이전 레이더 높이가 더 낮으면 이전 레이더 지움
				sIndex.pop();			//인덱스도 같이 지움
				if(stack.isEmpty()) {			//만약에 스텍에 아무것도 없으면 0을 출력 string에 추가
					sb.append("0 ");
				}
			}
			stack.push(height);			//이제 스텍에 받아온 높이를 가진 레이더를 넣음
			sIndex.push(index++);			//인덱스도 넣어줌
		}
		System.out.println(sb.toString());
	}
}