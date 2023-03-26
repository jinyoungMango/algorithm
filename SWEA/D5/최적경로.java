package SWEA.D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최적경로 {
    static int N, min;
    static int[] office, home, arr;
    static int[][] customer, route;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            office = new int[2];
            home = new int[2];
            customer = new int[N][2];
            arr = new int[N];
            visited = new boolean[N];
            route = new int[N + 2][2];
            office[0] = Integer.parseInt(st.nextToken());
            office[1] = Integer.parseInt(st.nextToken());
            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                customer[i][0] = Integer.parseInt(st.nextToken());
                customer[i][1] = Integer.parseInt(st.nextToken());
            }
            min = Integer.MAX_VALUE;
            permutation(0);
            System.out.println("#" + tc + " " + min);

        }
    }

    static void permutation(int cnt) {
        if (cnt == N) {

            route[0][0] = office[0];
            route[0][1] = office[1];
            for (int i = 0; i < arr.length; i++) {
                route[i + 1] = customer[arr[i]];
            }
            route[route.length - 1][0] = home[0];
            route[route.length - 1][1] = home[1];

            int len = 0;
            for (int i = 0; i < route.length - 1; i++) {
                len += Math.abs(route[i][0] - route[i + 1][0]) + Math.abs(route[i][1] - route[i + 1][1]);
            }
            min = Math.min(min, len);
            return;
        }
        for (int i = 0; i < customer.length; i++) {
            if (visited[i])
                continue;
            arr[cnt] = i;
            visited[i] = true;
            permutation(cnt + 1);
            visited[i] = false;
        }
    }
}
