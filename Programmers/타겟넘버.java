public class 타겟넘버 {
	public static void main(String[] args) {
		System.out.println(solution(new int [] {1, 1, 1, 1, 1}, 3));
		
	}
	static int answer;
	static public int solution(int[] numbers, int target) {
        
        dfs(numbers, 0, target, 0);
        
        return answer;
    }
	static void dfs(int [] numbers, int ans, int target, int cnt) {
		
		if(cnt==numbers.length) {
			if(target==ans) answer++;
			return;
		}
		dfs(numbers, ans+numbers[cnt], target, cnt+1);
		dfs(numbers, ans-numbers[cnt], target, cnt+1);
	}
}
