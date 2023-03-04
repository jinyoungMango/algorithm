package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 정사각형방 {

    static int n, cnt;
    static int[][] map;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int maxCnt = Integer.MIN_VALUE;
            int start = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    cnt = 0;
                    bfs(i, j);
                    if (maxCnt < cnt) {
                        maxCnt = cnt;
                        start = map[i][j];
                    } else if (maxCnt == cnt && start > map[i][j]) {
                        start = map[i][j];
                    }
                }
            }
            System.out.println("#" + tc + " " + start + " " + (maxCnt + 1));

        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { x, y });
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                // 숫자 1이 더 크면 이동 가능
                if ((map[nx][ny] - 1) == map[curr[0]][curr[1]]) {
                    queue.add(new int[] { nx, ny });
                    cnt++;
                }
            }
        }
    }
}
