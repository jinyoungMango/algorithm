package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2667 {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((cnt = bfs(i, j)) > 0) {
                    result++;
                    sb.append(cnt).append("\n");
                    cnt = 0;
                }
            }
        }
        System.out.println(result);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);

    }

    private static int bfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return 0;
        }
        if (map[x][y] == 1 && !visited[x][y]) {
            visited[x][y] = true;
            cnt++;
            bfs(x - 1, y);
            bfs(x, y - 1);
            bfs(x + 1, y);
            bfs(x, y + 1);
            return cnt;
        }
        return 0;
    }
}
