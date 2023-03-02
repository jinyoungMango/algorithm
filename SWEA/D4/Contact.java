package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Contact {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int[] contact;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max = 100;
        for (int t = 1; t <= 10; t++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int startV = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            contact = new int[max + 1];
            visited = new boolean[max + 1];
            for (int i = 0; i <= max; i++) {
                graph.add(new ArrayList<Integer>());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < len / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph.get(from).add(to);
            }
            for (ArrayList<Integer> list : graph) {
                Collections.sort(list);
            }
            int maxDepth = bfs(startV);
            System.out.println("#" + t + " " + maxDepth);
        }
    }

    static int bfs(int startV) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startV);
        visited[startV] = true;
        contact[startV] = 1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int i = 0; i < graph.get(curr).size(); i++) {
                int nv = graph.get(curr).get(i);
                if (!visited[nv]) {
                    queue.offer(nv);
                    visited[nv] = true;
                    contact[nv] = contact[curr] + 1;
                }
            }
        }

        int maxContact = 0;
        int maxIndex = 0;
        for (int i = 0; i < contact.length; i++) {
            if (contact[i] >= maxContact) {
                maxContact = contact[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
