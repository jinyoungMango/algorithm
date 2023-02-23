package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            int t = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split("");
            String[] sentence = br.readLine().split("");

            int sum = 0;
            for (int i = 0; i <= sentence.length - str.length; i++) {
                if (sentence[i].equals(str[0])) {
                    for (int j = 1; j < str.length; j++) {
                        if (sentence[i + j].equals(str[j])) {
                            if (j == str.length - 1)
                                sum++;
                        } else {
                            break;
                        }
                    }
                }
            }
            System.out.println("#" + t + " " + sum);
        }
    }

}
