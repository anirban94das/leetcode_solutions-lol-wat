import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
class LC200_Number_Of_Islands {
    //LC: 200. Number of Islands

    public int numIslands_BFS(char[][] grid) {

        int grid_X = grid.length;
        int grid_Y = grid[0].length;

        // state:
        int[][] isVisitedGrid = new int[grid_X][grid_Y];

        // move:
        int countOfIsland = 0;
        for (int row = 0; row <= grid_X; row++) {
            for (int col = 0; col <= grid_Y; col++) {
                if (isVisitedGrid[row][col] == 0 && grid[row][col] == '1') { // implying unVisited AND land
                    countOfIsland++;
                    //start the traversal & mark all the land in island as visited.
                    startDfsTraversal(isVisitedGrid, grid, row, col, grid_X, grid_Y);
                }
            }
        }
        // goal:
        return countOfIsland;
    }
    private void startBfsTraversal(int[][] isVisitedGrid, char[][] grid, int row, int col,
                                   int grid_X, int grid_Y) {
        Queue<Pair> queue =new ArrayDeque<>();


        
    }

    class Pair{
        public int x;
        public int y;
    }


    public int numIslands_DFS(char[][] grid) {

        int grid_X = grid.length;
        int grid_Y = grid[0].length;

        // state:
        int[][] isVisitedGrid = new int[grid_X][grid_Y];

        // move:
        int countOfIsland = 0;
        for (int row = 0; row <= grid_X; row++) {
            for (int col = 0; col <= grid_Y; col++) {
                if (isVisitedGrid[row][col] == 0 && grid[row][col] == '1') { // implying unVisited AND land
                    countOfIsland++;
                    //start the traversal & mark all the land in island as visited.
                    startDfsTraversal(isVisitedGrid, grid, row, col, grid_X, grid_Y);
                }
            }
        }
        // goal:
        return countOfIsland;
    }

    private void startDfsTraversal(int[][] isVisitedGrid, char[][] grid, int row, int col,
                                   int grid_X, int grid_Y) {
        if ((row >= grid_X) || (col >= grid_Y)
                || (row < 0) || (col < 0)) {
            return;
        }

        if (isVisitedGrid[row][col] == 0 && grid[row][col] == '1') {
            //mark this as visited.
            isVisitedGrid[row][col] = 1;
            //spawn DFS on all other rows.
            startDfsTraversal(isVisitedGrid, grid, row+1, col, grid_X, grid_Y);
            startDfsTraversal(isVisitedGrid, grid, row-1, col, grid_X, grid_Y);
            startDfsTraversal(isVisitedGrid, grid, row, col+1, grid_X, grid_Y);
            startDfsTraversal(isVisitedGrid, grid, row, col-1, grid_X, grid_Y);
        }
    }

}
