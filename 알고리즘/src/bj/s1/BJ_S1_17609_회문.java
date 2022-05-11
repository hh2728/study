package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_S1_17609_회문 {
	
	public static String s;
	public static int T;
	
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());


        for(int t=0;t<T;t++){
            s = br.readLine();
            sb.append(checkPalindrome(0,0,s.length()-1));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // start 와 last 계속 비교하여 회문인지 판단
    // result 0 : 회문 / result 1 : 유사회문 / result 2 : 아무것도 아님
    public static int checkPalindrome(int result, int start,int last){

        if(result==2){
            return 2;
        }

        while(start<=last){

            if(s.charAt(start) == s.charAt(last)){
                start++;
                last--;
            }
            else{
                // 현재는 회문이 아니다 -> 하나씩 제거하여 비교해서 회문인지 판별
                // 더 작은 값으로 갱신
                result = Integer.min(checkPalindrome(result+1,start+1,last),checkPalindrome(result+1,start,last-1));
                break;
            }
        }
        
        return result;
    }

}
