package maximum_2566;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int max = -1;
		int max_r = -1;
		int max_c = -1;
		for (int r = 0; r < 9; r++) {
			try {
				st = new StringTokenizer(br.readLine());
				int now;
				for(int c = 0; c < 9; c++) {
					now = Integer.parseInt(st.nextToken());
					if (max < now) {
						max = now;
						max_r = r + 1;
						max_c = c + 1;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(max);
		System.out.println(max_r + " " + max_c);
	}

}
