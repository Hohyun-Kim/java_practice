package flatten;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
//		BufferedReader br = new BufferedReader(new FileReader("./src/flatten/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] boxes = new int[100];
		List<Integer>[] heights = new List[100];
		for (int i = 0; i < 100; i++) {
			heights[i] = new ArrayList<>();
		}
		int dump = 0;
		int max;
		int min;
		int res = 0;
		for (int t = 1; t < 11; t++) {
			dump = Integer.parseInt(br.readLine());
			max = 0;
			min = 101;
			res = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				heights[i].clear();
			}
			for (int i = 0; i < 100; i++) {
				boxes[i] = Integer.parseInt(st.nextToken());
				heights[boxes[i]-1].add(Integer.valueOf(i));
				if (max < boxes[i]) {
					max = boxes[i];
				}
				if (min > boxes[i]) {
					min = boxes[i];
				}
			}
			
			
			while (dump > 0) {
				int max_box = heights[max-1].get(0);
				int min_box = heights[min-1].get(0);
				heights[max-2].add(Integer.valueOf(max_box));
				heights[max-1].remove(0);
				heights[min].add(Integer.valueOf(min_box));
				heights[min-1].remove(0);
				boxes[max_box]--;
				boxes[min_box]++;
				
				if (heights[max-1].size() == 0) max--;
				if (heights[min-1].size() == 0) min++;
				dump--;
				if (max-min<=1) {
					break;
				}
			}
			
			res = max - min;
			System.out.println("#" + t + " " + res);
		}
	}
}
