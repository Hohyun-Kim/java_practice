import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test5 {

  public static boolean in_range(int nr, int nc) {
    if (nr >= 19 || nc >= 19 || nc < 0 || nr < 0)
      return false;
    else
      return true;
  }

  public static void main(String[] args) throws Exception {
    //////////////////////////////////////////////////////////////
    // 테스트 후 아래 파일 입력을 표준입력으로 처리하는 문장은 주석 처리해주세요!!!! ( System.setIn처리 코드 )
    //////////////////////////////////////////////////////////////
    // System.setIn(new FileInputStream("Test5.txt"));

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[][] map = new int[19][19];
    for (int r = 0; r < 19; r++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int c = 0; c < 19; c++) {
        map[r][c] = Integer.parseInt(st.nextToken());
      }
    }

    int[] dr = {0, 1, 1, -1};
    int[] dc = {1, 1, 0, 1};

    int res_r = -1;
    int res_c = -1;
    int winner = 0;

    for (int r = 0; r < 19; r++) {
      for (int c = 0; c < 19; c++) {
        if (map[r][c] == 0)
          continue;
        int now = map[r][c];
        for (int d = 0; d < dr.length; d++) {
          int cnt = 1;
          int nr = r;
          int nc = c;
          while (cnt < 6) {
            nr += dr[d];
            nc += dc[d];
            if (!in_range(nr, nc))
              break;
            if (map[nr][nc] != now)
              break;
            cnt++;
          } ;
          if (cnt == 5) {
            if (in_range(r - dr[d], c - dc[d])) {
              if (map[r - dr[d]][c - dc[d]] == now)
                continue;
            }
            res_r = r + 1;
            res_c = c + 1;
            System.out.println(now);
            if (now != 0)
              System.out.println(res_r + " " + res_c);
            return;
          }
        }
      }
    }
    System.out.println(0);
    return;
  }
}

