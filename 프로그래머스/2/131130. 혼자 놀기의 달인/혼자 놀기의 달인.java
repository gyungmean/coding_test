import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int n = cards.length;
        boolean[] visited = new boolean[n];
        List<Integer> groupSizes = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            int count = 0;
            int current = i;
            while (!visited[current]) {
                visited[current] = true;
                current = cards[current] - 1; // 카드 번호 → 배열 인덱스 변환
                count++;
            }

            groupSizes.add(count);
        }

        if (groupSizes.size() < 2) return 0;

        Collections.sort(groupSizes, Collections.reverseOrder());
        return groupSizes.get(0) * groupSizes.get(1);
    }
}