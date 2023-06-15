package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈주범검거 {
	static class Point{
		int x, y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N, M, R, C, L;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	// 상, 좌, 하, 우
	static int[][] hole = { {}, 
			{ 1, 1, 1, 1 }, 
			{ 1, 0, 1, 0 }, 
			{ 0, 1, 0, 1 }, 
			{ 1, 0, 0, 1 }, 
			{ 0, 0, 1, 1 },
			{ 0, 1, 1, 0 }, 
			{ 1, 1, 0, 0 }

	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			if (L == 1) {
				System.out.println("#" + tc + " " + 1);
			} else {
				int result = bfs();
				System.out.println("#" + tc + " " + result);
			}
			

		}
	}
	static int bfs() {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		queue.offer(new Point(R, C));
		visited[R][C] = true;
		int time = 1;
		int result = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point p = queue.poll();
				int curr = map[p.x][p.y];
				for (int i = 0; i < 4; i++) {
					if (hole[curr][i] != 1) {
						continue;
					}
					
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
						continue;
					}
					if (visited[nx][ny] || map[nx][ny] == 0) {
						continue;
					}
					int next = map[nx][ny];
					if (hole[next][(i + 2) % 4] != 1) {
						continue;
					}
					queue.offer(new Point(nx, ny));
					visited[nx][ny] = true;
					result++;
				}
			}
			time++;
			if (time == L) {
				return result;
			}
		}
		return result;
	}
}
