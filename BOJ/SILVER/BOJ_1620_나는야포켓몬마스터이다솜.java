package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1620_나는야포켓몬마스터이다솜 {
	static int N,M; //포켓몬 수, 내가 맞춰야 하는 거
	static HashMap<String, Integer> ht1 = new HashMap<>();
	static HashMap<Integer, String> ht2 = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//도감을 작성한다.
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			ht1.put(tmp, i+1);
			ht2.put(i+1, tmp);
		}
		//문제를 푼다.
		for (int i = 0; i <M ; i++) {
			String tmp = br.readLine();
			if(ht1.containsKey(tmp)) {
				sb.append(ht1.get(tmp)).append("\n");
			}
			else {
				sb.append(ht2.get(Integer.parseInt(tmp))).append("\n");
			}
		}
		System.out.print(sb);
	}
}