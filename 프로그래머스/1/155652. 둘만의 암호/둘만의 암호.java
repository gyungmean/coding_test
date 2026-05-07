import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {

        StringBuilder answer = new StringBuilder();
        Set<Character> skipSet = new HashSet<>();

        for (int i = 0; i < skip.length(); i++) {
            skipSet.add(skip.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            int count = 0;

            while (count < index) {

                c++;

                if (c > 'z') {
                    c = 'a';
                }

                if (skipSet.contains(c)) {
                    continue;
                }

                count++;
            }

            answer.append(c);
        }

        return answer.toString();
    }
}