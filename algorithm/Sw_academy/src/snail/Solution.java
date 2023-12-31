package snail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int N, cnt, r, c, edge_length, num_turn, now_edge, remainder_2, remainder_4;
		for(int t = 1; t < T+1; t++) {
			sb.append("#" + t + "\n");
			N = Integer.parseInt(br.readLine());
			edge_length = N;
			cnt = 0;
			r = 0;
			c = 0;
			num_turn = 0;
			now_edge = 0;
			remainder_2 = 0;
			remainder_4 = 0;
			int objective = N*N;
			int[][]	snail = new int[N][N];
			while(cnt < objective) {
				now_edge++;
				cnt++;
				if (now_edge == edge_length) {
					now_edge = 0;
					if (remainder_2 == 0) {
						edge_length--;
					}
					num_turn++;
				}
				remainder_2 = num_turn % 2;
				remainder_4 = num_turn % 4;
				snail[r][c] = cnt;
				if(remainder_2 == 0) {
					if (remainder_4 == 0) {
						c += 1;
					} else {
						c -= 1;
					}
				} else {
					if (remainder_4 == 1) {
						r += 1;
					} else {
						r -= 1;
					}
				}
			}
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					sb.append(snail[row][col] + " ");
				}
				sb.append("\n");
			}
					
		}
		System.out.println(sb.toString());
	}

}
