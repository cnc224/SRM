
import java.lang.System;

public class Stamp {
  public int getMinimumCost(String s, int c1, int c2) {
    int res = 1<<30;
    for (int l = 1;l <= s.length(); ++l) {
      int[][] dp = new int[51][3];
      dp[0][0] = dp[0][1] = dp[0][2] = 1;
      String clr = "RGB";
      for (int i = 0;i < s.length(); ++i) {
        System.out.println(dp[2][1]);
        for (int j = 0;j < 3; ++j) {
          if (dp[i][j] == 0) continue;
          int k;
          for (k = i; k < i+l && k < s.length(); ++k) {
            if (s.charAt(k) != '*' && clr.charAt(j) != s.charAt(k)) {
              break;
            }
          }
          if (k == i+l) {
            for (int p = i+1; p< i+l; ++p) {
              if (dp[p][j] == 0 || dp[p][j] > dp[i][j]+1) {
                
                dp[p][j] = dp[i][j]+1;
//                System.out.println(dp[p][j]);
              }
            }
            for (int c = 0;c < 3; ++c) {
              if (dp[i+l][c] == 0 || dp[i+l][c] > dp[i][j]+1) {
                dp[i+l][c] = dp[i][j]+1;
              }
            }
            System.out.println(dp[i][j]);
            System.out.println(i + ", " + j);
          }
        }
      }
      
      for (int c = 0;c < 3; ++c) {
        if (dp[s.length()][c] != 0 && res > (dp[s.length()][c]-1)*c2+c1*l) {
          //System.out.println(dp[s.length()][c]);
          //System.out.println(l);
          res = (dp[s.length()][c]-1)*c2+c1*l;
        }
      }
    }
    return res;
  }

}

