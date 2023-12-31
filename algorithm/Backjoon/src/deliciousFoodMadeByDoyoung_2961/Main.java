package deliciousFoodMadeByDoyoung_2961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void find_best_taste(int[] sour, int[] bit, int sour_pi, int bit_sum, int[] delicious, int check, int cnt, int total) {
		
		int flavor = Math.abs(sour_pi - bit_sum);
		
		if (delicious[0] > flavor && cnt>0) {
			delicious[0] = flavor;
		}
		
		if (check == total) {
			return;
		}
		
		find_best_taste(sour, bit, sour_pi*sour[check], bit_sum+bit[check], delicious, check+1, cnt+1, total);
		find_best_taste(sour, bit, sour_pi, bit_sum, delicious, check+1, cnt, total);
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		int[] sour = new int[total];
		int[] bit = new int[total];
		int sour_pi = 1;
		int bit_sum = 0;
		int[] delicious = {Integer.MAX_VALUE};
		int check = 0;
		int cnt = 0;
		for (int i = 0; i < total; i++) {
			st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bit[i] = Integer.parseInt(st.nextToken());
		}
		find_best_taste(sour, bit, sour_pi, bit_sum, delicious, check, cnt, total);
		System.out.println(delicious[0]);
		
	}

}
