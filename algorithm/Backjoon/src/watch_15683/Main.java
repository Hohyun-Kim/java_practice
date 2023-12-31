package watch_15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	// 0: left
	// 1: up
	// 2: right
	// 3: down
	public static int[][] camera_dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
	
	public static int[][] camera_1 = {{0}, {1}, {2}, {3}};
	
	public static int[][] camera_2 = {{0, 2}, {1, 3}};
	
	public static int[][] camera_3 = {{0, 1}, {1, 2}, {2, 3}, {3, 0}};
	
	public static int[][] camera_4 = {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}};
	
	public static int[][] camera_5 = {{0, 1, 2, 3}};
	
	public static int[][] map;
	
	public static int N;
	
	public static int M;
	
	public static int min;
	
	public static boolean in_range(int nr, int nc) {
		if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 6 ) {
			return false;
		}
		return true;
	}
	
	public static void watch_map(List<int[]> cameras, int now_camera_index, int[] visited){
		
		if (now_camera_index == cameras.size()) {
			int temp = N*M;
			for(int r = 0; r < N; r++) {
				int visit_row = visited[r];
				for(int c = 0; c < M; c++) {
					if((visit_row&(1<<c)) != 0) {
						temp--;
					}
				}
			}
			if (min > temp) {
				min = temp;
			}
			return;
		}
		
		int[] camera = cameras.get(now_camera_index);
		
		int[][] direction_arr;
		
		switch(camera[2]) {
		case 1:
			direction_arr = camera_1;
			break;
		case 2:
			direction_arr = camera_2;
			break;
		case 3:
			direction_arr = camera_3;
			break;
		case 4:
			direction_arr = camera_4;
			break;
		case 5:
			direction_arr = camera_5;
			break;
		default:
			direction_arr = camera_1;
			break;
		}
		int nr;
		int nc;
		int[] now_visited = new int[N];
		
		// choose direction
		for(int[] direction : direction_arr) {
			// init visit
			for(int i = 0; i < N; i++) {
				now_visited[i] = visited[i];
			}
			// check area where camera can see
			for(int dir : direction) {
				nr = camera[0] + camera_dir[dir][0];
				nc = camera[1] + camera_dir[dir][1];
				while(in_range(nr, nc)) {
					now_visited[nr] = now_visited[nr]|(1 << nc);
					nr += camera_dir[dir][0];
					nc += camera_dir[dir][1];
				}
			}
			watch_map(cameras, now_camera_index+1, now_visited);
		}		
	};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = N * M;
		map = new int[N][M];
		int[] visited = new int[N];
		int res = N * M;
		int now_camera_index = 0;
		
		List<int[]> cameras = new ArrayList<int[]>(); 
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] != 0) {
					if (map[r][c] != 6) {
						int[] camera = {r, c, map[r][c]}; 
						cameras.add(camera);
					}
					visited[r] = visited[r]|1<<c;
				}
			}
		}
		
		watch_map(cameras, now_camera_index, visited);
		System.out.println(min);
		
	}

}
