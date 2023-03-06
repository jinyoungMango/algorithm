package SWEA.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 등산로조성 {
    static int N, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int result;
    static boolean cut;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            visited = new boolean[N][N];
            result = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (max < map[i][j]) {
                        max = map[i][j];
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == max) {
                        visited[i][j] = true;
                        dfs(i, j, map[i][j], 1, 1);
                        visited[i][j] = false;
                    }
                }
            }

            System.out.println("#" + tc + " " + result);

        }
    }

    static void dfs(int x, int y, int h, int depth, int cnt) {
        result = Math.max(result, depth);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;
            if (visited[nx][ny])
                continue;
            visited[nx][ny] = true;
            if (map[nx][ny] < h) {
                dfs(nx, ny, map[nx][ny], depth + 1, cnt);
            } else if (cnt == 1 && map[nx][ny] - K < h) {
                dfs(nx, ny, h - 1, depth + 1, cnt - 1);
            }
            visited[nx][ny] = false;
        }
    }
}
