import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, target);
        return answer;
    }
    
    int dfs(int[] numbers, int target) {
        int count = 0;
        Stack<Info> s = new Stack<>();
        s.push(new Info(numbers[0], 0));
        s.push(new Info(0 - numbers[0], 0));
        while(!s.isEmpty()) {
            Info now = s.pop();
            if(now.index == numbers.length - 1){
                if(now.num == target) count++;
            }
            else{
                s.push(new Info(now.num + numbers[now.index + 1], now.index + 1));

                s.push(new Info(now.num - numbers[now.index + 1], now.index + 1));
            }
        }
        return count;
    }
}

class Info {
    int num;
    int index;
    public Info(int num, int index) {
        this.num = num;
        this.index = index;
    }
}