import java.util.*;
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int iPos = timeToInt(pos);
        int iVideoLen = timeToInt(video_len);
        int iOpStart = timeToInt(op_start);
        int iOpEnd = timeToInt(op_end);
        for(String command : commands) {
            if(iOpStart <= iPos && iPos <= iOpEnd) {
                iPos = iOpEnd;
            }
            if(command.equals("next")) {
                iPos += 10;
                if(iPos > iVideoLen) iPos = iVideoLen;
            }
            else {
                iPos -= 10;
                if(iPos < 0) iPos = 0;
            }
        }
        if(iOpStart <= iPos && iPos <= iOpEnd) {
                iPos = iOpEnd;
            }
        StringBuilder answer = new StringBuilder();
        if(iPos / 60 < 10) {
            answer.append(0).append(iPos/60);
        }
        else {
            answer.append(iPos/60);
        }
        answer.append(":");
        if(iPos % 60 < 10) {
            answer.append(0).append(iPos%60);
        }
        else {
            answer.append(iPos%60);
        }
        return answer.toString();
    }
    
    int timeToInt(String time) {
        String[] arr = time.split(":");
        int result = Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
        return result;
    }
}