package Palendrom_10988;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String word = br.readLine();
			int index = 0;
			int len = word.length();
			if (len == 1) {
				System.out.println(1);
				return;
			}
			int check_length = len/2;
			boolean is_palendrom = true;
			while(index < check_length) {
				if (word.charAt(index) != word.charAt(len-1-index)) {
					is_palendrom = false;
					break;
				}
				index++;
			}
			if (is_palendrom) System.out.println(1);
			else System.out.println(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
