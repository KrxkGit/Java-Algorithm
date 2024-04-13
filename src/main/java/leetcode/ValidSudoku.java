package leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 滑动窗口可以先仅考虑基点 (以单纯基点作为循环条件)
 * 然后通过基点考虑窗口
 * 一般循环条件： 索引 < 长度； 索引 + 步长 < 长度
 */
public class ValidSudoku {
    private Integer nullInt = '.' - '0';
    public boolean isValidSudoku(char[][] board) {
//        System.out.println(nullInt);
        Matrix matrix = new Matrix(board);

        for (int i = 0; i < board.length; i++) {
            matrix.WalkRow(true, i);
            if (walkRowOrCol(matrix)) return false;
        }

        for (int i = 0; i < board[0].length; i++) {
            matrix.WalkRow(false, i);
            if (walkRowOrCol(matrix)) return false;
        }

//        System.out.println("Run here.");
        for (int i = 0; i < board[0].length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {
                // 根据窗口起点确定窗口
                HashSet<Integer> hashSet = new HashSet<>();
                for (int z = i; z < i + 3; z++) {
                    for (int k = j; k < j + 3; k++) {
                        Integer t = board[z][k] - '0';
                        if (!t.equals(nullInt) && hashSet.contains(t)) {
                            return false;
                        } else {
                            hashSet.add(t);
                        }

                        System.out.printf("%d ", t);
                    }
                    System.out.println();
                }
            }
        }
        return true;
    }

    private boolean walkRowOrCol(Matrix matrix) {
        Set<Integer> hashSet = new HashSet<>();
        while (matrix.hasNext()) {
            Integer t = matrix.next();
            if (!t.equals(nullInt) && hashSet.contains(t)) {
                return true;
            } else {
                hashSet.add(t);
            }
        }
        return false;
    }
}

class Matrix implements Iterator<Integer> {
    private char[][] board;
    private int curPos, index;
    private boolean bWalkRow;

    public Matrix(char[][] board) {
        this.board = board;
    }

    public void WalkRow(boolean bWalkRow, int index) {
        curPos = 0;
        this.index = index;
        this.bWalkRow = bWalkRow;
    }


    @Override
    public boolean hasNext() {
        if (bWalkRow && curPos < board[0].length || !bWalkRow && curPos < board.length) {
            return true;
        }
        return false;
    }

    @Override
    public Integer next() {
        if (bWalkRow) {
            System.out.println(curPos++);
            return board[index][curPos++] - '0';
        } else {
            return board[curPos++][index] - '0';
        }
    }
}