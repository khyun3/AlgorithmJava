package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class BOJ_25206_너의_평점은 {
    public static void main(String[] args) throws IOException {
        Map<String, Float> gradeMap = makeGradeMap();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double totalCredits = 0; //전체 받은 학점의 합
        double weightedSum = 0.0;//가중합
        String inputLine = br.readLine();

        while (inputLine != null && !inputLine.isBlank()) {
            String[] tokens = inputLine.split(" ");
            Double credit = Double.parseDouble(tokens[1]); //현 과목의 받음 학점

            if (gradeMap.containsKey(tokens[2])) {
                weightedSum += gradeMap.get(tokens[2]) * credit;
                totalCredits += credit;
            }
            inputLine = br.readLine();
        }

        System.out.print(weightedSum / totalCredits);
    }

    static Map<String, Float> makeGradeMap() {
        return Map.of(
                "A+", 4.5f, "A0", 4.0f,
                "B+", 3.5f, "B0", 3.0f,
                "C+", 2.5f, "C0", 2.0f,
                "D+", 1.5f, "D0", 1.0f,
                "F", 0.0f);
    }
}
