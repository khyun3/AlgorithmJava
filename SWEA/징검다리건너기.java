
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 징검다리건너기 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 0;
		N = Integer.parseInt(br.readLine());
		int [] stones = new int [N];
		
		int k = 0;
		k = Integer.parseInt(br.readLine()); //k입력
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int i = 0;
		while(st.hasMoreTokens()) {
			stones[i++] = Integer.parseInt(st.nextToken());
		}
		solution(stones,k);
	}
	 public static int solution(int[] stones, int k) {
		   int answer = 0;
		   int max=0, min=Integer.MAX_VALUE;
		   
		   for (int i = 0; i < stones.length; i++) {
			   max = Math.max(max, stones[i]);
			   min = Math.min(min, stones[i]);
		   }
		  answer = binarySearch(stones, k, max, min);
		  System.out.println(answer);
	        return answer;
	 }
	 public static int binarySearch(int[] stones, int k, int high, int low) {
		 	int answer=Integer.MAX_VALUE;
		 	int first = low;
			int last = high;
			int mid = 0;
			int cnt = 0;
			
			while(first<=last) {
				cnt = 0;
				mid = (first+last)/2;

				for (int i = 0; i < stones.length; i++) {
					if(stones[i]<=mid) {
						cnt++;
						if(cnt>=k) break;
					}
					else cnt=0;
					
				}
				if(cnt<k) {
					last = mid - 1;
				}
				else {
					answer = Math.min(answer, mid);
					first = mid + 1; 
				}
			}
			return answer;
		}
}