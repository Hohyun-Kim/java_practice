package towerOfHanoi_1914;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
	
	public static int cnt = 0;
	
	public static void move(int start, int dest, int num_disc, BufferedWriter bw) throws IOException {
		if (num_disc == 1) {
			bw.write(start + " " + dest + "\n");
			return;
		}
		int temp = 6 - (start + dest);
		move(start, temp, num_disc-1, bw);
		bw.write(start + " " + dest + "\n");
		move(temp, dest, num_disc-1, bw);
		return;
	}
	
//	public static void move(int start, int dest, int num_disc, int[] cnt, BufferedWriter bw) throws IOException {
//		cnt[0]++;
//		if (num_disc == 1) {
//			bw.write(start + " " + dest + "\n");
//			return;
//		}
//		int temp = 6 - (start + dest);
//		move(start, temp, num_disc-1, cnt, bw);
//		bw.write(start + " " + dest + "\n");
//		move(temp, dest, num_disc-1, cnt, bw);
//		return;
//	}

//	public static void move(int start, int dest, int num_disc, BufferedWriter bw) throws IOException {
//		cnt++;
//		if (num_disc == 1) {
//			bw.write(start + " " + dest + "\n");
//			return;
//		}
//		int temp = 6 - (start + dest);
//		move(start, temp, num_disc-1, bw);
//		bw.write(start + " " + dest + "\n");
//		move(temp, dest, num_disc-1, bw);
//		return;
//	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num_disc = Integer.parseInt(br.readLine());
					
		BigInteger cnt = new BigInteger("2").pow(num_disc);
		cnt = cnt.subtract(new BigInteger("1"));
		System.out.println(cnt);
			
		if (num_disc <= 20) {
			move(1, 3, num_disc, bw);
		}
		
		bw.close();
	}
	
//	public static void main(String[] args) throws IOException {
//		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		int num_disc = Integer.parseInt(br.readLine());
//		
//		if (num_disc > 20) {
//			BigInteger cnt = new BigInteger("2").pow(num_disc);
//			cnt = cnt.subtract(new BigInteger("1"));
//			System.out.println(cnt);
//		} else {
//			move(1, 3, num_disc, bw);
//			System.out.println(cnt);
//		}
//		
//		bw.close();
//	}
	
}
