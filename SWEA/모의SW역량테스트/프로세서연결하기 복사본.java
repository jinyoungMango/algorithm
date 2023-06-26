package SWEA.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 프로세서연결하기 {
    static int N, count, maxPowerCnt, minLineCnt;
    static int[][] map;
    static ArrayList<int[]> coreList;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            coreList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    // 코어 위치, 가장자리 코어는 제외
                    if (map[i][j] == 1 && i != 0 && i != N - 1 && j != 0 && j != N - 1) {
                        coreList.add(new int[] { i, j });
                    }
                }
            }
            for (int[] arr : coreList) {
                // System.out.println(Arrays.toString(arr));
            }
            count = 0;
            maxPowerCnt = 0;
            minLineCnt = 0;
            connectProcessor(0, 0, 0);
            System.out.println("#" + tc + " " + minLineCnt);
        }
    }

    static void connectProcessor(int depth, int powerCnt, int lineCnt) {
        if (depth == coreList.size()) {
            if (maxPowerCnt < powerCnt) {
                maxPowerCnt = powerCnt;
                minLineCnt = lineCnt;
            } else if (maxPowerCnt == powerCnt) {
                minLineCnt = Math.min(minLineCnt, lineCnt);
            }
            return;
        }

        int[] currCore = coreList.get(depth);
        for (int i = 0; i < 4; i++) {

            if (checkConnect(currCore, i)) {
                fill(currCore, i, 2);
                connectProcessor(depth + 1, powerCnt + 1, lineCnt + count);
                fill(currCore, i, 0);
            }
        }
        connectProcessor(depth + 1, powerCnt, lineCnt);
    }

    static boolean checkConnect(int[] core, int dir) {
        int x = core[0] + dx[dir]; // core의 x좌표
        int y = core[1] + dy[dir]; // core의 y좌표

        while (x >= 0 && x < N && y >= 0 && y < N) {
            if (map[x][y] != 0) {
                return false;
            }
            x += dx[dir];
            y += dy[dir];
        }

        return true;
    }

    static boolean fill(int core[], int dir, int value) {
        count = 0;
        int x = core[0] + dx[dir]; // core의 x좌표
        int y = core[1] + dy[dir]; // core의 y좌표
        while (x >= 0 && x < N && y >= 0 && y < N) {
            map[x][y] = value;
            count++;
            x += dx[dir];
            y += dy[dir];
        }
        return true;
    }
}
