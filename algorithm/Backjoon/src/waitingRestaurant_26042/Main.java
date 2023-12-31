package waitingRestaurant_26042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		String info;
		Queue<Integer> waiting = new ArrayDeque<>();
		int max_length = 0;
		int last = 0;
		int now;
		for(int i = 0; i < N; i++) {
			info = br.readLine();
			if (info.length() == 1) {
				waiting.poll();
			} else {
				st = new StringTokenizer(info);
				st.nextToken();
				now = Integer.parseInt(st.nextToken());
				waiting.add(now);
				if (max_length < waiting.size()) {
					max_length = waiting.size();
					last = now;
				} else if (max_length == waiting.size()) {
					if (last > now) {
						last = now;
					}
				}
			}
		}
		System.out.println(max_length + " " + last);
	}
}
