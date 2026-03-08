import java.util.*;
class Solution {
    // code, date, maximum, remain
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<Data> datas = new ArrayList<>();
        for(int i = 0; i < data.length; i++) {
            int code = data[i][0];
            int date = data[i][1];
            int maximum = data[i][2];
            int remain = data[i][3];
            
            boolean flag = false;
            switch(ext) {
                case "code":
                    if(code < val_ext) flag = true;
                    break;
                case "date":
                    if(date < val_ext) flag = true;
                    break;
                case "maximum":
                    if(maximum < val_ext) flag = true;
                    break;
                case "remain":
                    if(remain < val_ext) flag = true;
                    break;
            }
            if(flag) {
                datas.add(new Data(code, date, maximum, remain));
            }
        }
        switch(sort_by) {
                case "code":
                    Collections.sort(datas, (d1, d2) -> d1.code - d2.code);
                    break;
                case "date":
                    Collections.sort(datas, (d1, d2) -> d1.date - d2.date);
                    break;
                case "maximum":
                    Collections.sort(datas, (d1, d2) -> d1.maximum - d2.maximum);
                    break;
                case "remain":
                    Collections.sort(datas, (d1, d2) -> d1.remain - d2.remain);
                    break;
        }
        int[][] answer = new int[datas.size()][4];
        for(int i = 0; i < answer.length; i++) {
            Data d = datas.get(i);
            answer[i] = new int[]{ d.code, d.date, d.maximum, d.remain };
        }
        return answer;
    }
}

class Data {
    int code;
    int date;
    int maximum;
    int remain;
    public Data(int code, int date, int maximum, int remain) {
        this.code = code;
        this.date = date;
        this.maximum = maximum;
        this.remain = remain;
    }
}