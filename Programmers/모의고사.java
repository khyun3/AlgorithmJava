import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 모의고사 {
	public static void main(String[] args) {
		
		
		System.out.println(Arrays.toString(solution(new int [] {1,3,2,4,2})));
	}
	
	static public int[] solution(int[] answers) {
		ArrayList<Integer> aList = new ArrayList<>();
		int[] answer = {};
		//1, 2, 3, 4, 5    len = 5
        //2, 1, 2, 3, 2, 4, 2, 5 len = 8
        //3, 3, 1, 1, 2, 2, 4, 4, 5, 5 len = 10
		int [][] suPoJa = {{1, 2, 3, 4, 5},{2, 1, 2, 3, 2, 4, 2, 5},{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
		int [] cnt = new int[3];
		
		for (int a = 0; a < answers.length; a++) {
			cnt[0] += suPoJa[0][a] == answers[a] ? 1 : 0;
			cnt[1] += suPoJa[1][a] == answers[a] ? 1 : 0;
			cnt[2] += suPoJa[2][a] == answers[a] ? 1 : 0;
		}
		
		//가장 높은 점수를 받은 사람을 찾기
		//가장 큰 수를 찾는다
		int maxIndex = 0;
		for (int i = 1; i < cnt.length; i++) {
			if(cnt[maxIndex] < cnt[i]) {
				maxIndex = i;
			}
		}
		aList.add(maxIndex+1);
		//가장 큰 수와 같은 개수가 있는지 찾는다
		for (int i = 0; i < cnt.length; i++) {
			if(i!=maxIndex && cnt[i]==cnt[maxIndex]) {
				aList.add(i+1);
			}
		}
		Collections.sort(aList);
		answer = new int [aList.size()];
		for (int i = 0; i < aList.size(); i++) {
			answer[i] = aList.get(i);
		}
		
		return answer;
	}
}
