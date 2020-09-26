package D3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author Yun
 * 아이디어 : 첫 숫자를 스택에 넣는다.
 * 		   2번째 숫자부터 스택의 탑과 비교해본다. => 만약 탑과 같다면 pop 하고 다음 숫자를 가지고 온다. => 마지막 숫자까지 반복한다.
 * 시뮬레이션 : 입력받은 숫자의 배열 => 1234554312
 * 	    	1
 * 			1 | 2 push
 * 			1 | 2 | 3 push
 * 			1 | 2 | 3 | 4 push
 * 			1 | 2 | 3 | 4 | 5 push
 * 			1 | 2 | 3 | 4 | 5 == 5 pop
 * 			1 | 2 | 3 | 4 == 4 pop
 * 			1 | 2 | 3 == 3 pop
 * 			1 | 2 | 1 push
 * 			1 | 2 | 1 | 2 push
 */
public class D3_1234_비밀번호 {
	static int T = 10, N;
	static char[] data;
	static Stack<String> stack = new Stack<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb;
		for (int t = 1; t <= 10; t++) {
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // n개를 받았다.
			stack.clear();
			data = new char[N];

			data = st.nextToken().toCharArray(); // 숫자가 붙어있으니까 char배열로 다 넣는다.

			// 초기 데이터 1개를 넣는다.
			stack.push(data[0] + "");
			
			for (int i = 1; i < N; i++) {
				String next = data[i] + "";		//다음 숫자 1개를 가지고온다.
				
				if (!stack.isEmpty()) {			//스택에 데이터가 1개라도 존재하면
					String pre = stack.peek();  //탑을 본다.
					
					if (next.equals(pre)) {		//전 숫자와 같으면
						stack.pop();			//둘다 지운다.
					}else stack.push(data[i]+""); //아니면 스택에 넣는다.
					
				}else stack.push(data[i]+"");	//스텍이 비어있다면 넣는다.
			
			}
			while(!stack.isEmpty()) sb.append(stack.pop()); //스텍을 스트링빌더에 넣는다.
			System.out.print("#"+t+" "); //먼저 출력한다.
			System.out.println(sb.reverse().toString());//뒤집어서 출력한다.
		}
	}
}