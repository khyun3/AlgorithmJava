import java.util.Arrays;

public class 소수만들기 {
	static boolean [] primeNumbers = new boolean [2998];
	static int res=0, selected[] = new int [3];
	
	public static void main(String[] args) {
		solution(new int [] {1,2,3,4});
		solution(new int [] {1,2,7,6,4});
	}
	static public int solution(int[] nums) {
	        int answer = -1;

	        //0과 1 처리
	        primeNumbers[0] = true;
	        primeNumbers[1] = true;
	        
	        //에라토스테네스의 체를 이용
	        setPrimeNumbers();

	        //nC3조합
	        combination(nums, 0, 0);
	        System.out.println(res);
	        return answer = res;
	    }
		static void combination(int nums[], int cnt, int start) {
			if(cnt==3) {
				int index = selected[0]+selected[1]+selected[2];
				res += primeNumbers[index] ? 0 : 1; 
				return;
			}
			for (int i = start; i < nums.length; i++) {
				selected[cnt] = nums[i];
				combination(nums, cnt+1, i+1);
			}
		}
		
	    static void setPrimeNumbers(){
	        //1000이하의 자연수 3개를 더했을 때 최대로 나올 수 있는 숫자는 1000+999+998
	        int max = 1000+999+998; // 2997
	        int sqrt = (int)Math.sqrt(max); //sqrt 2997 => 54.7
	        
	        for (int i = 2; i < sqrt; i++) {
				if(primeNumbers[i]) continue;
				
				for (int j = i*2; j < primeNumbers.length; j+=i) {
					primeNumbers[j] = true;
				}
			}
	    }
}
