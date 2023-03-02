package SWEA.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자만들기 {
    static int[] number;
    static int[] operNum;
    static int max, min;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            operNum = new int[4];
            for (int i = 0; i < 4; i++) {
                operNum[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            number = new int[n];
            for (int i = 0; i < number.length; i++) {
                number[i] = Integer.parseInt(st.nextToken());
            }

            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            dfs(number[0], 1);
            int diff = max - min;
            System.out.println("#" + tc + " " + diff);
        }

    }

    static void dfs(int result, int cnt) {
        if (cnt == n) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        } else {
            for (int i = 0; i < 4; i++) {
                if (operNum[i] == 0) {
                    continue;
                }
                operNum[i]--;
                if (i == 0) {
                    dfs(result + number[cnt], cnt + 1);
                } else if (i == 1) {
                    dfs(result - number[cnt], cnt + 1);
                } else if (i == 2) {
                    dfs(result * number[cnt], cnt + 1);
                } else if (i == 3) {
                    dfs(result / number[cnt], cnt + 1);
                }
                operNum[i]++;
            }
        }
    }
}
