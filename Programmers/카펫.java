import java.util.Arrays;

public class 카펫 {
	public static void main(String[] args) {
		int[] brown = {10,8,24};
		int[] yellow = {2,1,24};
		for (int i = 0; i < 3; i++) {
			solution(brown[i], yellow[i]);
		}
	}
	
	static int [] solution(int brown, int yellow) {
		int[] answer = new int [2];
		
		int total = brown + yellow;
		
		//가로 길이가 세로 길이보다 크거나 같음
		//총 타일 수를 만들 수 있는 수의 곱을 찾아야 함
		//가로나 세로의 최소 크기는 3임
		//4*3 o, 6*2 x
		int i = 3;
		int r, c;
		while(true) {
			if(total%i == 0) {
				r = total/i;
				c = i;//
				
				if(r<c) break;
				else if(((r-2) * (c-2)) == yellow) {
					answer[0] = r;
					answer[1] = c;
					break;
				}
			}
			i++;
		}
		
		return answer;
	}
}
