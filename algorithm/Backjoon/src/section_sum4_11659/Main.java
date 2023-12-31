package section_sum4_11659;

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
		int[] sum_from_0 = new int[N+1];
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += Integer.parseInt(st.nextToken());
			sum_from_0[i+1] = sum;
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append((sum_from_0[end]-sum_from_0[start-1]) + "\n");
		}
		System.out.println(sb.toString());

	}

}
