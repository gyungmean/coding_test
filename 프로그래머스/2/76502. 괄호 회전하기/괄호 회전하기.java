import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            boolean isCorrect = true;

            for (int j = i; j < i + s.length(); j++) {
                char c = s.charAt(j % s.length());

                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        isCorrect = false;
                        break;
                    }

                    char top = stack.pop();

                    if (c == ')' && top != '(') isCorrect = false;
                    if (c == '}' && top != '{') isCorrect = false;
                    if (c == ']' && top != '[') isCorrect = false;

                    if (!isCorrect) break;
                }
            }

            if (isCorrect && stack.isEmpty()) answer++;
        }

        return answer;
    }
}