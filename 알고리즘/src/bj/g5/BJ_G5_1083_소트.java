package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_G5_1083_소트 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int S = Integer.parseInt(br.readLine());
       
        //현재값.
        int totalCnt = 0; 
        int temp = 0;
        
        // 카운트 안에들어가고 , 크기 안에 들어가는걸로하자.
        while (totalCnt < S && temp < N - 1) {
            
        	int maxNum = arr.get(temp); 
            int maxIdx = -1;
            
            //다음값
            int target = temp + 1; 
            int count = 1;
            
            // 다음꺼부터 쭉 돌아보자.
            while (totalCnt + count <= S && target < N) {
                
            	int num = arr.get(target);
                
            	if (num > maxNum) {
                    maxNum = num;
                    maxIdx = target;
                }
                
            	count++;
                target++;
            }
            
            //변화 있으면 값 바꿔주기.
            if (maxIdx != -1) {
                arr.remove(maxIdx);
                arr.add(temp, maxNum);
                totalCnt += maxIdx - temp;
            }
            
            temp++;
        }
        arr.add(0,23);
        arr.add(0,353);

        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);
        br.close();
	}

}
