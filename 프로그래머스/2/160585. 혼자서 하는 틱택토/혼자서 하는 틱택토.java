class Solution {

    public int solution(String[] board) {

        int o = 0;
        int x = 0;

        for(String s : board) {
            for(char c : s.toCharArray()) {
                if(c == 'O') o++;
                else if(c == 'X') x++;
            }
        }

        if(x > o || o - x > 1) return 0;

        boolean oWin = win(board, 'O');
        boolean xWin = win(board, 'X');

        if(oWin && xWin) return 0;

        // O 승리 -> O가 한 개 더 많아야 함
        if(oWin && o != x + 1) return 0;

        // X 승리 -> 개수 같아야 함
        if(xWin && o != x) return 0;

        return 1;
    }

    boolean win(String[] b, char t) {

        for(int i = 0; i < 3; i++) {
            // 가로
            if(b[i].charAt(0) == t &&
               b[i].charAt(1) == t &&
               b[i].charAt(2) == t)
                return true;

            // 세로
            if(b[0].charAt(i) == t &&
               b[1].charAt(i) == t &&
               b[2].charAt(i) == t)
                return true;
        }

        // 대각선
        if(b[0].charAt(0) == t &&
           b[1].charAt(1) == t &&
           b[2].charAt(2) == t)
            return true;

        if(b[0].charAt(2) == t &&
           b[1].charAt(1) == t &&
           b[2].charAt(0) == t)
            return true;

        return false;
    }
}