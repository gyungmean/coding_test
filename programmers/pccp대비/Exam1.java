class Exam1 {
    public int[] solution(String command) {
        int[] answer = new int[2];
        int x = 0;
        int y = 0;
        int direction = 0; // +y : 0, +x : 1, -y : 2, -x : 3
        for(char c : command.toCharArray()){
            if(c == 'R'){
                direction += 1;
                direction %= 4;
            }
            else if(c == 'L'){
                direction -= 1;
                if(direction < 0)
                    direction += 4;
            }
            switch(direction){
                case 0:
                    if(c == 'G')
                        y++;
                    else if(c == 'B')
                        y--;
                    break;
                case 1:
                    if(c == 'G')
                        x++;
                    else if(c == 'B')
                        x--;
                    break;
                case 2:
                    if(c == 'G')
                        y--;
                    else if(c == 'B')
                        y++;
                    break;
                case 3:
                    if(c == 'G')
                        x--;
                    else if(c == 'B')
                        x++;
                    break;
            }   
        }
        answer[0] = x;
        answer[1] = y;
        return answer;
    }
}
