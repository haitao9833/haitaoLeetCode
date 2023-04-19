package leetcode.LC_Array;

import java.util.ArrayList;
import java.util.List;

public class Solution_118 {

    /**
     * 杨辉三角
     * <P> 边界 == 1
     * <P> 非边界 == 左上角 + 右上角
     */
    public List<List<Integer>> generate(int numRows) {
        // preliminary
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }

        // 下标第 0 行仅有 1 个数字 1
        res.add(new ArrayList<>(){{add(1);}});

        // preRow 为当前行 curRow 的上一行
        List<Integer> preRow = res.get(0);

        for (int i = 1 ; i < numRows ; i++) {
            List<Integer> curRow = new ArrayList<>();

            // 下标第 i 行有 i+1 个数字
            for (int j = 0 ; j <= i ; j++) {
                if (j == 0 || j == i) {
                    curRow.add(1);
                } else {
                    // 左上方 + 右上方
                    curRow.add(preRow.get(j - 1) + preRow.get(j));
                }
            }
            preRow = curRow;
            res.add(curRow);
        }
        return res;
    }
}
