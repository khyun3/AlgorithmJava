package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1764_듣보잡 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); //듣도 못한 사람
		int M = Integer.parseInt(st.nextToken()); //보도 못한 사람
		int cnt = 0;
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < N; i++) {
			map.put(br.readLine().trim(), 1);
		}
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			String str = br.readLine().trim();
			if(map.containsKey(str)){
				list.add(str);
				cnt++;
			}
		}
		Collections.sort(list);
		for (String s : list) { sb.append(s).append("\n");}
		System.out.println(cnt+"\n"+sb);
	}
}