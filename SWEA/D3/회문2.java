package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 회문2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            int tc = Integer.parseInt(br.readLine());
            String[][] arr = new String[100][100];
            for (int i = 0; i < arr.length; i++) {
                String[] line = br.readLine().split("");
                for (int j = 0; j < arr.length; j++) {
                    arr[i][j] = line[j];
                }
            }

            ArrayList<Integer> maxLen = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    ArrayList<String> rowWord = new ArrayList<>();
                    ArrayList<String> colWord = new ArrayList<>();
                    for (int k = 0; k < arr.length - j; k++) {
                        rowWord.add(arr[i][j + k]);
                        colWord.add(arr[j + k][i]);
                        for (int l = 0; l < rowWord.size(); l++) {
                            if (rowWord.get(l).equals(rowWord.get(rowWord.size() - l - 1))) {
                                if (l == (rowWord.size() - 1)) {
                                    maxLen.add(rowWord.size());
                                }
                            } else
                                break;
                        }

                        for (int l = 0; l < colWord.size(); l++) {
                            if (colWord.get(l).equals(colWord.get(colWord.size() - l - 1))) {
                                if (l == (colWord.size() - 1)) {
                                    maxLen.add(colWord.size());
                                }
                            } else
                                break;
                        }
                    }
                }
            }
            Collections.sort(maxLen);
            System.out.println("#" + t + " " + maxLen.get(maxLen.size() - 1));
        }
    }
}
