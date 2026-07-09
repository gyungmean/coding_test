class Solution {
    public int solution(String s) {
        int maxLength = 1; 
        int n = s.length();

        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, expandAroundCenter(s, i, i));
            maxLength = Math.max(maxLength, expandAroundCenter(s, i, i + 1));
        }

        return maxLength;
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; 
    }
}