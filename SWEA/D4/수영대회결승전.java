package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 수영대회결승전 {
    static class Point {
        int x, y, time;

        Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int N, result;
    static int[][] map, startEnd;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            startEnd = new int[2][2];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 2; j++) {
                    // [0][j] : start
                    // [1][j] : end
                    startEnd[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            result = 0;
            bfs(startEnd[0][0], startEnd[0][1]);
            if (result == 0) {
                System.out.println("#" + tc + " " + "-1");
            } else {
                System.out.println("#" + tc + " " + result);
            }

        }
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y, 0));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.x == startEnd[1][0] && p.y == startEnd[1][1]) {
                result = p.time;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if (visited[nx][ny] || map[nx][ny] == 1) {
                    continue;
                }

                // 소용돌이
                if (map[nx][ny] == 2) {
                    int currTornado = p.time % 3;
                    // 건널 수 있음
                    if (currTornado == 2) {
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny, p.time + 1));
                    } else {
                        visited[p.x][p.y] = true;
                        queue.offer(new Point(p.x, p.y, p.time + 1));
                    }
                } else if (map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny, p.time + 1));
                }

            }
        }
    }
}