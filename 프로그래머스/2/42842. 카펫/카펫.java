class Solution {
    public int[] solution(int brown, int yellow) {
        //가로가 더 길다
        //yellow먼저 배치? //brown먼저 배치?
        /*
        * yellow를 몇줄로 배치할 것인가?
        * 줄 개수 1부터 나누면서 들어감 24 / 1 = 24 이 경우 갈색은 1(줄개수) * 2 + 24(몫) * 2 + 4(모서리) 여야하는데 안됨
        * 줄 개수 2 24 / 2 = 12 2 * 2 + 4 + 12 * 2
        * 24 / 4 = 6 (4 * 2) + 4 + (6 * 2) = 12 + 12 갈색임 끝
        * 몫이 줄 개수보다 커지면 그만하기
        */
        int r = 0, c = 0;
        int rowCount = 1;
        while(yellow >= rowCount){
            if(yellow % rowCount == 0) {
                int newColCount = yellow / rowCount;
                int calcBrown = (newColCount * 2) + (rowCount * 2) + 4;
                if(calcBrown == brown) {
                    r = newColCount + 2;
                    c = rowCount + 2;
                    break;
                }
            }
            rowCount++;
        }
        int[] answer = {r, c};
        return answer;
        
    }
}