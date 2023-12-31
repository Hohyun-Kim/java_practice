package killfly;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("./src/killfly/input.txt"));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		int N;
		int M;
		int sum_under_row;
		int sum_row;
		int best;
		int temp;
		int big_r;
		int big_c;
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N+1][N+1];
			for(int r = 1; r < N+1; r++) {
				sum_row = 0;
				st = new StringTokenizer(br.readLine());
				for(int c = 1; c < N+1; c++) {
					sum_under_row = map[r-1][c];
					sum_row += Integer.parseInt(st.nextToken());
					map[r][c] = sum_row + sum_under_row;
				}
			}
			best = map[M][M];
			for(int r = 1; r < N-M+2; r++) {
				for(int c = 1; c < N-M+2; c++) {
					big_r = r+M-1;
					big_c = c+M-1;
					temp = map[big_r][big_c] - map[big_r][c-1] - map[r-1][big_c] + map[r-1][c-1];
					if (best < temp) {
						best = temp;
					}
				}
			}
			sb.append("#").append(t+1).append(" ").append(best).append("\n");
		}
		System.out.println(sb);
	}

}
