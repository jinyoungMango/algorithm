package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GNS {
    static String[] number = { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int N = Integer.parseInt(st.nextToken());
            String[] arr = br.readLine().split(" ");
            int[] numCnt = new int[10];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].equals("ZRO")) {
                    numCnt[0]++;
                } else if (arr[i].equals("ONE")) {
                    numCnt[1]++;
                } else if (arr[i].equals("TWO")) {
                    numCnt[2]++;
                } else if (arr[i].equals("THR")) {
                    numCnt[3]++;
                } else if (arr[i].equals("FOR")) {
                    numCnt[4]++;
                } else if (arr[i].equals("FIV")) {
                    numCnt[5]++;
                } else if (arr[i].equals("SIX")) {
                    numCnt[6]++;
                } else if (arr[i].equals("SVN")) {
                    numCnt[7]++;
                } else if (arr[i].equals("EGT")) {
                    numCnt[8]++;
                } else if (arr[i].equals("NIN")) {
                    numCnt[9]++;
                }

            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numCnt.length; i++) {
                for (int j = 0; j < numCnt[i]; j++) {
                    if (i == 0) {
                        sb.append("ZRO" + " ");
                    } else if (i == 1) {
                        sb.append("ONE" + " ");
                    } else if (i == 2) {
                        sb.append("TWO" + " ");
                    } else if (i == 3) {
                        sb.append("THR" + " ");
                    } else if (i == 4) {
                        sb.append("FOR" + " ");
                    } else if (i == 5) {
                        sb.append("FIV" + " ");
                    } else if (i == 6) {
                        sb.append("SIX" + " ");
                    } else if (i == 7) {
                        sb.append("SVN" + " ");
                    } else if (i == 8) {
                        sb.append("EGT" + " ");
                    } else if (i == 9) {
                        sb.append("NIN" + " ");
                    }
                }
            }

            System.out.println("#" + tc);
            System.out.println(sb);
            System.out.println();
        }
    }
}
