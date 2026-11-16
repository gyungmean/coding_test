class Solution {
    public int[] solution(String[] park, String[] routes) {
        int height = park.length;
        int width = park[0].length();

        int row = 0;
        int col = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (park[i].charAt(j) == 'S') {
                    row = i;
                    col = j;
                }
            }
        }

        for (String route : routes) {
            String[] op = route.split(" ");
            String direction = op[0];
            int distance = Integer.parseInt(op[1]);

            int dr = 0;
            int dc = 0;

            switch (direction) {
                case "N": dr = -1; break;
                case "S": dr = 1;  break;
                case "W": dc = -1; break;
                case "E": dc = 1;  break;
            }

            int nextRow = row;
            int nextCol = col;
            boolean canMove = true;

            for (int step = 0; step < distance; step++) {
                nextRow += dr;
                nextCol += dc;

                if (nextRow < 0 || nextRow >= height ||
                    nextCol < 0 || nextCol >= width ||
                    park[nextRow].charAt(nextCol) == 'X') {
                    canMove = false;
                    break;
                }
            }

            if (canMove) {
                row = nextRow;
                col = nextCol;
            }
        }

        return new int[] {row, col};
    }
}