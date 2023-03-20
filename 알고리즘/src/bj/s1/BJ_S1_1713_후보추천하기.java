package bj.s1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_S1_1713_후보추천하기 {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        ArrayList<People> list = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        
        int N = Integer.parseInt(br.readLine()); 
        int T = Integer.parseInt(br.readLine()); 
        
        st = new StringTokenizer(br.readLine());
        
        for(int t=0; t<T; t++) {
            
        	int student = Integer.parseInt(st.nextToken());
            
            if(list.size() < N) {
                
            	boolean flag = false;                
            	for(int j=0; j<list.size(); j++) {
                    if(list.get(j).num == student) {
                        list.get(j).cnt++;
                        flag = true; 
                        break;
                    }
                }
            	
            	//리스트에 없으면 새로 추가
                if(!flag) {
                	list.add(new People( t, student, 1));
                }
                
            }
            //사이즈가 틀만큼이면
            else {
            	
                Collections.sort(list);
                
                boolean flag = false;
                for(int j=0; j<list.size(); j++) {
                    if(list.get(j).num == student) {
                        list.get(j).cnt++;
                        flag = true;
                        break;
                    }
                }
                
                if(!flag) {
                	//제일 작고 오래된거 삭제
                    list.remove(0);
                    
                    list.add(new People(t, student, 1));
                }
            }
        }
        
 
        for(int i=0; i<list.size(); i++) {
            answer.add(list.get(i).num);
        }
        
        Collections.sort(answer);
        
        for(int i=0; i<answer.size(); i++) {
        	
        	System.out.print(answer.get(i)+" ");
        }
         
    }
    
    static class People implements Comparable<People>{
        int index, num, cnt;
 
        public People(int index, int num, int cnt) {
            super();
            this.index = index;
            this.num = num;
            this.cnt = cnt;
        }
 
        @Override
        public int compareTo(People o) {
            if(this.cnt==o.cnt) {
                return this.index-o.index;
            }
            return this.cnt-o.cnt;
        }
        
    }

}
