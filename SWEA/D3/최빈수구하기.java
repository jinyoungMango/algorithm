package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class 최빈수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            int tc = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] score = Stream.of(str).mapToInt(Integer::parseInt).toArray();
            int[] mode = new int[101];
            for (int j = 0; j < score.length; j++) {
                mode[score[j]]++;
            }

            int max = Arrays.stream(mode).max().getAsInt();
            int result = 0;
            for (int k = 0; k < mode.length; k++) {
                if (mode[k] == max) {
                    result = k;
                }
            }
            System.out.println("#" + i + " " + result);
        }
    }
}
