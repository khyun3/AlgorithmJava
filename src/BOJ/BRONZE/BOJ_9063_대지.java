package BOJ.BRONZE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 임씨의 이름이 새겨진 옥구슬이 나오는 모든 지점을 포함하는 가장 작은 남북, 동서 방향으로 평행한 변을 갖는 직사각형의 대지를 임씨의 소유로 인정한다.”
public class BOJ_9063_대지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int maxX = -10001;
        int minX = 10001;
        int maxY = -10001;
        int minY = 10001;

        for (int t = 0; t < n; t++) {
            String[] inputToken = br.readLine().split(" ");
            int x = Integer.parseInt(inputToken[0]);
            int y = Integer.parseInt(inputToken[1]);
            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
        }

        int area = Math.abs((maxX - minX) * (maxY - minY));
        System.out.println(area);
    }
}
