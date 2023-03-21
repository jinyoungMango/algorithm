package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 단순2진암호코드 {
    static String[] code = { "0001101", "0011001", "0010011", "0111101",
            "0100011", "0110001", "0101111", "0111011", "0110111", "0001011" };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String pass[] = new String[M];
            String[] resultCode = new String[8];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                if (line.contains("1")) {
                    pass = line.split("");
                }
            }
            int lastPass = 0;
            for (int i = 0; i < pass.length; i++) {
                if (pass[i].equals("1")) {
                    lastPass = i;
                }
            }
            int cnt = 0;
            for (int i = lastPass - 55; i < lastPass; i += 7) {
                resultCode[cnt] = pass[i];
                resultCode[cnt] += pass[i + 1];
                resultCode[cnt] += pass[i + 2];
                resultCode[cnt] += pass[i + 3];
                resultCode[cnt] += pass[i + 4];
                resultCode[cnt] += pass[i + 5];
                resultCode[cnt] += pass[i + 6];
                cnt++;
            }

            int result = checkPassword(resultCode);
            System.out.println("#" + tc + " " + result);

        }
    }

    static int checkPassword(String[] rcode) {
        int[] decode = new int[8];
        int cnt = 0;
        for (int i = 0; i < rcode.length; i++) {
            for (int j = 0; j < code.length; j++) {
                if (rcode[i].equals(code[j])) {
                    decode[cnt++] = j;
                    break;
                }
            }
        }

        int even = 0;
        int odd = 0;
        int sum = 0;
        // 암호코드 확인
        for (int i = 0; i < decode.length; i++) {
            sum += decode[i];
            if (i % 2 == 0) {
                odd += decode[i];
            } else {
                even += decode[i];
            }
        }
        int chkdecode = (odd * 3) + even;
        int result = 0;
        if (chkdecode % 10 == 0) {
            result = sum;
        } else {
            result = 0;
        }
        return result;
    }
}
