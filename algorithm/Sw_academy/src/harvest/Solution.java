package harvest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("./src/harvest/input.txt"));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int N;
		int h;
		int sum;
		int temp;
		String num_row;
		int divider;
		for (int t = 1; t < T+1; t++) {
			N = Integer.parseInt(br.readLine());
			h = N/2;
			sum = 0;
			for (int r = 0; r < N; r++) {
				int n = (-1)*Math.abs(h-r) + h;
				st = new StringTokenizer(br.readLine());
				num_row = st.nextToken();
				for (int c = h-n; c <= h+n; c++) {
					sum += num_row.charAt(c) - '0';
				}
			}
			sb.append("#"+ t + " " + sum + "\n");
		}
		
		System.out.println(sb.toString());

	}

}
