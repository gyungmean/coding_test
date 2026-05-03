import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int totalPicks = picks[0] + picks[1] + picks[2];
        int maxMinerals = Math.min(minerals.length, totalPicks * 5);
        int chunkCount = (maxMinerals + 4) / 5;

        Chunk[] chunks = new Chunk[chunkCount];
        for (int i = 0; i < chunkCount; i++) {
            chunks[i] = new Chunk(0, 0, 0);
        }

        for (int i = 0; i < maxMinerals; i++) {
            if (minerals[i].equals("diamond")) {
                chunks[i / 5].dia++;
            } else if (minerals[i].equals("iron")) {
                chunks[i / 5].iron++;
            } else {
                chunks[i / 5].stone++;
            }
        }

        Arrays.sort(chunks, (a, b) -> {
            int valA = a.dia * 25 + a.iron * 5 + a.stone;
            int valB = b.dia * 25 + b.iron * 5 + b.stone;
            if (valA != valB) return valB - valA;
            return b.dia - a.dia;
        });

        for (Chunk c : chunks) {
            if (picks[0] > 0) {
                answer += c.dia + c.iron + c.stone;
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += c.dia * 5 + c.iron + c.stone;
                picks[1]--;
            } else if (picks[2] > 0) {
                answer += c.dia * 25 + c.iron * 5 + c.stone;
                picks[2]--;
            } else {
                break;
            }
        }

        return answer;
    }
}

class Chunk {
    int dia;
    int iron;
    int stone;

    public Chunk(int dia, int iron, int stone) {
        this.dia = dia;
        this.iron = iron;
        this.stone = stone;
    }
}