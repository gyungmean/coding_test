import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(String[] operations) {
        StringTokenizer st;
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < operations.length; i++){
            st = new StringTokenizer(operations[i]);
            String op = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            switch(op){
                case "I":
                    minQ.offer(num);
                    break;
                case "D":
                    if(minQ.isEmpty()) break;
                    if(num == 1){
                        stack = new Stack<>();
                        while(!minQ.isEmpty()){
                            stack.push(minQ.poll());
                        }
                        stack.pop();
                        while(!stack.isEmpty()){
                            minQ.offer(stack.pop());
                        }
                    }
                    else if(num == -1){
                        if(minQ.isEmpty()) break;
                        minQ.poll();
                    }
                    break;
            }
        }
        
        stack = new Stack<>();
        int[] answer = new int[2];
        if(!minQ.isEmpty()){
            answer[1] = minQ.poll();
            while(!minQ.isEmpty()){
                stack.push(minQ.poll());
            }
            answer[0] = stack.pop();
        }
        return answer;
    }
}