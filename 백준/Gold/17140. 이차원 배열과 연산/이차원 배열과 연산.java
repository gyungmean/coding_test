import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

	static int r, c, k;
	static int[][] A;
	static int rSize = 3, cSize = 3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());
        
        //ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A = new int[101][101];
        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //입력받기 끝
        
        //행의 개수 ≥ 열의 개수 -> R연산
        //행의 개수 < 열의 개수 -> C연산
        int answer = 0;
        while(A[r][c] != k) {
            if(answer > 100) {
                answer = -1;
                break;
            }
            if(rSize >= cSize) {//R연산
                R();
            }
            else {//C연산
                C();
            }
//            for(int i = 0; i < rSize; i++) {
//            	for(int j = 0; j < cSize; j++) {
//            		System.out.print(A[i][j] + " ");
//            	}
//            	System.out.println();
//            }
//            System.out.println("====================");
            answer++;
        }
        System.out.println(answer);
    }
    
    static void R() {
    	int tmpSize = 0;
    	for(int i = 0; i < rSize; i++) {
    		PriorityQueue<Data> pq = new PriorityQueue<>();
        	Map<Integer, Integer> map = new HashMap<>(); //숫자, 카운트
    		for(int j = 0; j < cSize; j++) {
    			if(A[i][j] == 0) continue;
    			map.compute(A[i][j], (num, count) -> count == null ? 1: count + 1);
    		}
    		map.forEach((k, v) -> pq.add(new Data(k, v)));
    		int idx = 0;
    		while(!pq.isEmpty()) {
    			Data now = pq.poll();
    			A[i][idx++] = now.number;
    			A[i][idx++] = now.count;
    		}
    		tmpSize = Math.max(tmpSize, idx);
    		while(idx <= 99) {
    			A[i][idx++] = 0; //남은 배열 다 0으로 채우기
    		}
    	}
    	cSize = tmpSize;
    }
    
    static void C() {
    	int tmpSize = 0;
    	for(int j = 0; j < cSize; j++) {
    		PriorityQueue<Data> pq = new PriorityQueue<>();
    		Map<Integer, Integer> map = new HashMap<>(); //숫자, 카운트
    		for(int i = 0; i < rSize; i++) {
    			if(A[i][j] == 0) continue;
    			map.compute(A[i][j], (num, count) -> count == null ? 1: count + 1);
    		}
    		map.forEach((k, v) -> pq.add(new Data(k, v)));
    		int idx = 0;
    		while(!pq.isEmpty()) {
    			Data now = pq.poll();
    			A[idx++][j] = now.number;
    			A[idx++][j] = now.count;
    		}
    		tmpSize = Math.max(tmpSize, idx);
    		while(idx <= 99) {
    			A[idx++][j] = 0; //남은 배열 다 0으로 채우기
    		}
    	}
    	rSize = tmpSize;
    }
}
class Data implements Comparable<Data>{
	int number;
	int count;
	
	public Data(int number, int count) {
		this.number = number;
		this.count = count;
	}

	@Override
	public int compareTo(Data o) {
		if(this.count > o.count) {
			return 1;
		} else if(this.count == o.count) {
			return this.number - o.number; //카운트가 같으면 number가 작은거
		}
		return -1;
	}
	
}