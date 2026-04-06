import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int maxTime = 0;

        m = convert(m);

        for(String info : musicinfos) {
            String[] tmp = info.split(",");
            int startTime = toMinute(tmp[0]);
            int endTime = toMinute(tmp[1]);
            int playTime = endTime - startTime;

            String melody = convert(tmp[3]); 

            StringBuilder played = new StringBuilder();
            for(int i = 0; i < playTime; i++) {
                played.append(melody.charAt(i % melody.length()));
            }

            if(played.toString().contains(m)) {
                if(maxTime < playTime) {
                    maxTime = playTime; 
                    answer = tmp[2];
                }
            }
        }

        return answer.equals("") ? "(None)" : answer;
    }

    int toMinute(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

    // 🔥 핵심: # 처리
    String convert(String s) {
        return s.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
    }
}