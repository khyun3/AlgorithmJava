package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2491_수열 {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		//증가하는 방향의 이전 수, 감소하는 방향의 이전 수, 증가 카운트, 감소 카운트
		int preNum=0, dCnt=0, iCnt=0;
		int decMax=0, incMax=0;
		int tmp = 0;
		for (int i = 0; i < N; i++) {
			tmp = Integer.parseInt(st.nextToken());
			
			//첫 번재 수일 때
			if(i==0) {
				preNum = tmp;
				dCnt ++;
				iCnt ++;
			}else { //2번째 수 부터
				
				if(tmp>preNum) {
					//증가한다.
					//증가하면 감소하는 카운트를 0으로 바꾼다.
					dCnt = 1;
					//증가 카운트를 1증가시킨다.
					iCnt++;
					
				} else if(tmp<preNum) {
					//감소한다.
					//감소하면 증가하는 카운트를 0으로 바꾼다.
					iCnt = 1;
					dCnt++;					
				}
				else { //같다. 증,감 카운트 모두 1씩 증가
					dCnt++;
					iCnt++;
				}	
			}
			preNum = tmp;
			decMax = Math.max(dCnt, decMax);
			incMax = Math.max(iCnt, incMax);
		}
		
		System.out.println(Math.max(decMax, incMax));
	}
}