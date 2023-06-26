package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 홈방범서비스 {
	static class Home {
		int x, y;

		public Home(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M, max; // 도시의 크기, 비용
	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bfs(i, j);
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}

	static void bfs(int x, int y) {
		int[][] visited = new int[N][N];
		Queue<Home> queue = new LinkedList<>();
		queue.offer(new Home(x, y));
		visited[x][y] = 1;
		int maxDist = 0;
		while (!queue.isEmpty()) {
			Home h = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = h.x + dx[i];
				int ny = h.y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}
				if (visited[nx][ny] > 0) {
					continue;
				}
				queue.offer(new Home(nx, ny));
				visited[nx][ny] = visited[h.x][h.y] + 1;
				maxDist = Math.max(maxDist, visited[nx][ny]);
			}
		}

		calcProfit(maxDist, visited);
	}

	static void calcProfit(int maxDist, int[][] visited) {
		for (int k = 1; k <= maxDist; k++) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] <= k && map[i][j] == 1) {
						cnt++;
					}
				}
			}
			// 운영 비용 : K * K + (K - 1) * (K - 1)
			int cost = k * k + (k - 1) * (k - 1);
			// 이익
			int profit = M * cnt - cost;
			if (profit >= 0 && max < cnt) {
				max = cnt;
			}
		}
	}

}
