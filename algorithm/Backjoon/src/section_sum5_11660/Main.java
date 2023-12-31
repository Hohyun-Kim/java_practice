package section_sum5_11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x1, y1, x2, y2;
		int sum_under_row;
		int sum_row;
		int sum = 0;
		int[][] sum_from_origin = new int[N+1][N+1];
		for (int r = 1; r < N+1; r++) {
			st = new StringTokenizer(br.readLine());
			sum_row = 0;
			for(int c = 1; c < N+1; c++) {
				sum_under_row = sum_from_origin[r-1][c];
				sum_row += Integer.parseInt(st.nextToken());
				sum_from_origin[r][c] = sum_row + sum_under_row;
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			sb.append((sum_from_origin[x2][y2] - sum_from_origin[x1-1][y2] - sum_from_origin[x2][y1-1] + sum_from_origin[x1-1][y1-1])).append("\n");
		}
		System.out.println(sb.toString());
	}

}
