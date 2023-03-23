package SWEA.D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 공통조상 {
    static int V, E, v1, v2, result2;
    static ArrayList<ArrayList<Integer>> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            tree = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                tree.add(new ArrayList<Integer>());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                tree.get(start).add(end);
            }

            ArrayList<Integer> parentList1 = new ArrayList<>();
            ArrayList<Integer> parentList2 = new ArrayList<>();
            parentList1.add(v1);
            parentList2.add(v2);

            while (true) {
                if (parentList1.contains(1) && parentList2.contains(1)) {
                    break;
                }
                for (int i = 1; i <= V; i++) {
                    if (tree.get(i).contains(parentList1.get(parentList1.size() - 1))) {
                        parentList1.add(i);
                    }
                    if (tree.get(i).contains(parentList2.get(parentList2.size() - 1))) {
                        parentList2.add(i);
                    }
                }
            }
            // 공통부분 빼고 버리기
            parentList1.retainAll(parentList2);
            int result1 = parentList1.get(0);
            result2 = 0;
            bfs(result1); // 공통 조상의 번호로 크기 찾기
            System.out.println("#" + tc + " " + result1 + " " + result2);
        }

    }

    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            result2++;
            int curr = queue.poll();
            for (int i = 0; i < tree.get(curr).size(); i++) {
                queue.offer(tree.get(curr).get(i));
            }
        }
    }
}
