import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            rank.put(players[i], i);
        }
        
        for(String name : callings) {
            int now = rank.get(name);
            int front = rank.get(players[now - 1]);
            String tmp = players[now];
            players[now] = players[front];
            players[front] = tmp;
            rank.put(players[now], now);
            rank.put(players[front], front);
        }
        
        return players;
    }
}