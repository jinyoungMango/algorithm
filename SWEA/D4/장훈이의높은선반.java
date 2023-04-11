package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 장훈이의높은선반 {
    static int N, B, minDiff;
    static int[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            height = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }
            minDiff = Integer.MAX_VALUE;
            dfs(0, 0, 0);
            System.out.println("#" + tc + " " + minDiff);
        }

    }

    static void dfs(int cnt, int start, int result) {
        if (cnt == N || result >= B) {
            if (result >= B) {
                minDiff = Math.min(minDiff, result - B);
            }
            return;
        }
        for (int i = start; i < N; i++) {
            dfs(cnt + 1, i + 1, result + height[i]);
        }
    }
}
