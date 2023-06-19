package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 디저트카페 {
	static int N, max;
	static int[][] map;
	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { 1, -1, -1, 1 };
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			visited = new boolean[101];
			max = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(i, j, i, j, 0, 1);
				}
			}

			System.out.println("#" + tc + " " + max);

		}
	}

	static void dfs(int x, int y, int nowX, int nowY, int dir, int cnt) {
		visited[map[x][y]] = true;
		for (int i = dir; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
				continue;
			}

			if (!visited[map[nx][ny]]) {
				dfs(nx, ny, nowX, nowY, i, cnt + 1);
			} else if (nowX == nx && nowY == ny && cnt >= 4) {

				max = Math.max(max, cnt);
			}

		}
		visited[map[x][y]] = false;

	}

}