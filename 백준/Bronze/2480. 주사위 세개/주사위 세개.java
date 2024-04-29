import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dice = new int[3];
        for(int i = 0; i < 3; i++) {
        	dice[i] = Integer.parseInt(st.nextToken());
        }
        int reward = 0;
        if(dice[0] == dice[1] && dice[1] == dice[2]) {
        	reward = dice[0] * 1000 + 10000;
        }
        else if(dice[0] == dice[1] && dice[1] != dice[2]) {
        	reward = dice[0] * 100 + 1000;
        }
        else if(dice[1] == dice[2] && dice[2] != dice[0]) {
        	reward = dice[1] * 100 + 1000;
        }
        else if(dice[2] == dice[0] && dice[1] != dice[0]) {
        	reward = dice[2] * 100 + 1000;
        }
        else {
        	int max = -1;
        	for(int i = 0; i < 3; i++) {
        		if(dice[i] > max) max = dice[i];
        	}
        	reward = max * 100;
        }
        System.out.println(reward);
       
    }
}
