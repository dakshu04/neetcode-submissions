class Solution {
    class Pair {
        int x;
        int y;
        int t;
        Pair(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int cntFresh = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }
                if(grid[i][j] == 1) {
                    cntFresh++;
                }
            }
        }
        int[] drow = {1, 0, -1, 0};
        int[] dcol = {0, 1, 0, -1};
        int cntRoot = 0;
        int tm = 0;
        while(!q.isEmpty()) {
            int r = q.peek().x;
            int c = q.peek().y;
            int t = q.peek().t;
            tm = Math.max(tm, t);
            q.remove();
            for(int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol, t + 1));
                    vis[nrow][ncol] = 2;
                    cntRoot++;
                }
            }
        }
        if(cntFresh != cntRoot) {
            return -1;
        }
        return tm;
    }
}
