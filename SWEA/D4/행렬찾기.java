package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 행렬찾기 {
    static int N, r, c;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];
            list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > 0 && !visited[i][j]) {
                        findMap(i, j);
                        cnt++;
                    }
                }
            }

            Collections.sort(list, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    int diff = o1[0] * o1[1] - o2[0] * o2[1];
                    // 크기가 같을 경우 행이 작은 순으로 정렬
                    if (diff == 0) {
                        return o1[0] - o2[0];
                    }
                    // 크기가 작은 순으로 출력
                    return diff;
                }

            });
            StringBuilder sb = new StringBuilder();
            for (int[] arr : list) {
                sb.append(arr[0] + " ");
                sb.append(arr[1] + " ");
            }
            System.out.print("#" + tc + " " + cnt + " ");
            System.out.println(sb);

        }
    }

    static void findMap(int x, int y) {
        visited[x][y] = true;
        r = 0;
        c = 0;
        for (int i = x; i < N; i++) {
            if (map[i][y] > 0) {
                r++;
            } else {
                break;
            }
        }
        for (int i = y; i < N; i++) {
            if (map[x][i] > 0) {
                c++;
            } else {
                break;
            }
        }

        for (int i = x; i < x + r; i++) {
            for (int j = y; j < y + c; j++) {
                visited[i][j] = true;
            }
        }
        list.add(new int[] { r, c });
    }
}
