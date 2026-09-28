import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> c = new HashMap<>();
        for (String[] clothe : clothes) {
            c.put(clothe[1], c.getOrDefault(clothe[1], 0) + 1);
        }

        int answer = 1;
        for (int count : c.values()) {
            answer *= (count + 1);
        }

        return answer - 1; 
    }
}