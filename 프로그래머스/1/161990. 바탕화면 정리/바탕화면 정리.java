import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        int startX = wallpaper.length;
        int startY = wallpaper[0].length();
        int endX = 0;
        int endY = 0;
        for(int i = 0; i < wallpaper.length; i++) {
            char[] line = wallpaper[i].toCharArray();
            for(int j = 0; j < line.length; j++) {
                if(line[j] == '.') continue;
                startX = Math.min(i, startX);
                startY = Math.min(j, startY);
                endX = Math.max(i + 1, endX);
                endY = Math.max(j + 1, endY);
            }
        }
        return new int[]{ startX, startY, endX, endY };
    }
}