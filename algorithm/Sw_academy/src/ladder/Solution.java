package ladder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static boolean in_range(int nc) {
		if (nc < 100 && nc >= 0) {
			return true;
		}
		return false;
	}
	
	public static int move_horizental(int[][] map, int r, int next, int d) {
		int c;
		for (c = next + d; in_range(c); c += d) {
			if (map[r][c] == 0) {
				return c-d;
			}
		}
		return c-d;
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("./src/ladder/input.txt"));
		StringTokenizer st;
		int[][] map = new int[100][100];
		int now;
		int next;
		int[] direction = {-1, 1};
		
		for (int t = 1; t < 11; t++) {
			now = -1;
			br.readLine();
			
			for (int r = 0; r < 100; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < 100; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			for (int c = 0; c < 100; c++) {
				if (map[99][c] == 2) {
					now = c;
				}
			}
			for (int r = 98; r > 0; r--) {
				for (int d : direction) {
					next = now + d;
					if (in_range(next)) {
						if (map[r][next] == 1) {
							now = move_horizental(map, r, next, d);
							break;
						}
					}
				}				
			}
			System.out.println("#" + t + " " + now);
			
		}
		
	}
}
