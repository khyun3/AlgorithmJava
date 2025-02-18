package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class BOJ_7785_회사에_있는_사람 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.print(solution(br, n));
        br.close();
    }

    static String solution(BufferedReader br, int n) throws IOException {
        StringBuilder sb = new StringBuilder();
        TreeSet<String> empInOffice = new TreeSet<>();
        String[] tokens;
        for (int t = 0; t < n; t++) {
            tokens = br.readLine().split(" ");
            String name = tokens[0];
            String stat = tokens[1];

            if (stat.equals("enter")) {
                empInOffice.add(name);
            } else {
                empInOffice.remove(name);
            }
        }
        empInOffice.descendingSet().forEach(name -> sb.append(name).append("\n"));
        return sb.toString();
    }
}