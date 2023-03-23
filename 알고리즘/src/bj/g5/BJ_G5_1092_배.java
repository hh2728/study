package bj.g5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_G5_1092_배 {

	static int N,M;
	static ArrayList<Integer> crane,box;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		crane = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			crane.add(Integer.parseInt(st.nextToken()));
		}
		
		M = Integer.parseInt(br.readLine());
		
		box = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(crane, Collections.reverseOrder());
		Collections.sort(box, Collections.reverseOrder());
		
		int ans = 0;
		
		if(box.get(0) > crane.get(0)) {
			System.out.println("-1");
			return;
		}
	    
        while(!box.isEmpty()) {
            
        	int index =0;
            
            for(int i=0; i<N;) {
                
            	if(index == box.size()) break;
                else if(crane.get(i) >= box.get(index)) {
                    box.remove(index);
                    i++;
                }else index++;
            }
            ans++;
        }
        
        System.out.println(ans);

	}

}
