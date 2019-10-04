/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 * 
 * 做题思路：这是我做的第一道DFS/BFS遍历的题目。首先要明白连通图和连通分量的定义，
 * 知道这道题其实就是在找连通分量的数量。当自己是'1'时，只要上下左右有一个1，那就
 * 是同一个岛。这是一开始比较困惑的地方。
 * 
 * 然后dfs的构建和主函数是参考以下视频和博客的：
 * https://www.youtube.com/watch?v=hhBiPyr1Byo&t=856s
 * https://www.cnblogs.com/handsomelixinan/p/10346065.html
 * 讲得都很好
 * 
 * for each二维数组也可以学习一下。来offer的这个代码比别的标准submit优雅很多。
 */
class Solution {
    final static int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        //sanity check
        if(grid==null || grid.length==0||grid[0].length==0){
            return 0;
        }
        int count = 0;
        final int rows = grid.length;
        final int cols = grid[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j,rows,cols);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x ,int y, int rows, int cols){
        //base case
        if(x<0||x>=rows||y<0||y>=cols||grid[x][y]=='0'){
            return ;
        }
        //recursive
        grid[x][y] = '0';
        for(int[]dir:dirs){
            int neiX = dir[0] + x;
            int neiY = dir[1] + y;
            dfs(grid,neiX,neiY,rows,cols);
        }
    }
}

