package bj.b4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_B4_29738_GoodbyeCodeJam{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++){
            int temp = Integer.parseInt(br.readLine());

            String round = getRound(temp);
            sb.append("Case #"+ i + ": "+round + "\n");
        }

        System.out.print(sb);
    }

    static String getRound(int number){
        String result = "";

        if(number > 4500 ){
            result = "Round 1";
        }else if(number > 1000){
            result = "Round 2";
        }else if(number > 25){
            result = "Round 3";
        }else {
            result = "World Finals";
        }
        return result;
    }
}
