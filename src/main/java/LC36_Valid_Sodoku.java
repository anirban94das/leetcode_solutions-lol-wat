import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/description/
 */
class LC36_Valid_Sodoku {
    //LC: 36. Valid Sodoku
    public boolean isValidSudoku(char[][] board) {
        int size = board.length;
        // validate rows
        for (int i = 0; i < size; i++) {
            char[] row = board[i];
            Set<Character> charSet = new HashSet();
            //iterate over row to find duplicates
            for (int j = 0; j < size; j++) {
                char currentChar= board[i][j];
                if(charSet.contains(currentChar)){
                    return false;
                }
                else if(currentChar!='.'){
                    charSet.add(currentChar);
                }
            }
        }
        // validate cols
        for (int i = 0; i < size; i++) {
            char[] col = new char[size];
            Set<Character> charSet = new HashSet();
            for (int j = 0; j < size; j++) {
                char currentChar= board[j][i];
                if(charSet.contains(currentChar)){
                    return false;
                }
                else if(currentChar!='.'){
                    charSet.add(currentChar);
                }
            }
        }
        // validate grid

        for (int boxRow = 0; boxRow < size; boxRow += 3) {
            for (int boxCol = 0; boxCol < size; boxCol+=3) {
                Set<Character> charSet = new HashSet();
                for (int row = boxRow; row < boxRow + 3; row++) {
                    for (int col = boxCol; col < boxCol + 3; col++) {
                        char currentChar= board[row][col];
                        if(charSet.contains(currentChar)){
                            return false;
                        }
                        else if(currentChar!='.'){
                            charSet.add(currentChar);
                        }
                    }
                }
            }
        }
        return true;
    }
}
