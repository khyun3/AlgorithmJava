package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2108_통계학 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		double avg = 0;   //산술평균 	: 모든 수의 합 / N
		int mid = 0;   //중앙값 	: 오름차순에서 중앙에 위치하는 값
		int mode = 0;  //최빈값 	: 가장 많이 나타나는 값
		int range = 0; //범위		: 최대값 최소값 차이
		
		int [] number = new int [N];
		int [] mArr = new int [8001]; //최빈 수를 구하기 위해 사용
	
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(br.readLine());
			avg+=number[i];
			mArr[number[i]+4000]++;
		}
		Arrays.sort(number);
		
		avg =Math.round(avg/N);
		mid = number[N/2];
		
		//최 빈수
		int tmp = 0;
		int cnt = 0;
		for (int i = 0; i < mArr.length; i++) {
			if(tmp<mArr[i]) {
				tmp = mArr[i];
				mode = i-4000;
				cnt=0;
			}
			if(cnt<2 && tmp==mArr[i]) {
				cnt++;
				tmp = mArr[i];
				mode = i-4000;
			}
		}
		range =Math.abs(number[N-1] - number[0]);
		
		System.out.println((int)avg+"\n"+mid+"\n"+mode+"\n"+range);
	}
}