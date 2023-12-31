package dnaPassword_12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static boolean check_valid(int[] ACGT_num, int[] ACGT_cnt) {
		for (int i = 0; i < 4; i++) {
			if (ACGT_num[i] > ACGT_cnt[i]) return false;
		}
		return true;
	}
	
	public static void manage_cnt(String DNA, int[] ACGT_cnt, String ACGT, int[] index, boolean[] increase) {
		for (int i = 0; i < index.length; i++) {
			if (increase[i]) {
				ACGT_cnt[ACGT.indexOf(DNA.charAt(index[i]))]++;
			} else {
				ACGT_cnt[ACGT.indexOf(DNA.charAt(index[i]))]--;
			}
		}
	}
	
	public static void init_cnt(String DNA, int[] ACGT_cnt, String ACGT, int T) {
		for (int i = 0; i < T; i++) {
			ACGT_cnt[ACGT.indexOf(DNA.charAt(i))]++;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		String DNA = br.readLine();
		st = new StringTokenizer(br.readLine());
		int[] ACGT_num = new int[4];
		int[] ACGT_cnt = new int[4];
		int cnt = 0;
		String ACGT = "ACGT";
		boolean[] increase = {true, false};
		int[] index = {0, T};
		for(int i = 0; i < 4; i++) {
			ACGT_num[i] = Integer.parseInt(st.nextToken());
		}
		init_cnt(DNA, ACGT_cnt, ACGT, T);
		if(check_valid(ACGT_num, ACGT_cnt)) cnt++;
		for (index[0] = T, index[1] = 0; index[0] < S; index[0]++, index[1]++) {
			manage_cnt(DNA, ACGT_cnt, ACGT, index, increase);
			if(check_valid(ACGT_num, ACGT_cnt)) cnt++;
		}
		System.out.println(cnt);
		
	}

}
