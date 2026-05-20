import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Queue<Character> q = new ArrayDeque<>();
        Set<Character> set = new HashSet<>();
        for(char c : skill.toCharArray()) {
            set.add(c);
        }
        for(String tree : skill_trees) {
            boolean isPossible = true;
            q = new ArrayDeque<>();
            for(char c : skill.toCharArray()) {
                q.add(c);
            }
            for(char s : tree.toCharArray()) {
                if(set.contains(s)) {
                    if(s != q.peek()) {
                        isPossible = false;
                        break;
                    }
                    q.poll();
                }
            }
            if(isPossible) answer++;
        }
        return answer;
    }
}