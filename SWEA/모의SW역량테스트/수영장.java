package SWEA.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수영장 {
    static int[] price;
    static int[] plan;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            price = new int[4];
            for (int i = 0; i < price.length; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            plan = new int[12];
            for (int i = 0; i < plan.length; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }
            min = price[3];
            calcPrice(0, 0);
            System.out.println("#" + tc + " " + min);
        }
    }

    static void calcPrice(int month, int result) {
        if (month >= 12) {
            if (min > result)
                min = result;

        } else {
            calcPrice(month + 1, result + plan[month] * price[0]);
            calcPrice(month + 1, result + price[1]);
            calcPrice(month + 3, result + price[2]);
        }
    }
}